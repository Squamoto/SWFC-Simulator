# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.box = "centos/7"

  config.vm.network "forwarded_port", guest: 80, host: 8080
  #config.vm.network "private_network", ip: "192.168.33.10"

  config.vm.synced_folder ".", "/home/vagrant/SWFC-Simulator"

  config.vm.provider "virtualbox" do |vb|
    # Display the VirtualBox GUI when booting the machine
    # Customize the amount of memory on the VM:
    vb.memory = "2048"
    vb.customize ["modifyvm", :id, "--nictype1", "virtio" ]
    # suggested fix for slow network performance
    # see https://github.com/mitchellh/vagrant/issues/1807
    vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
    vb.customize ["modifyvm", :id, "--natdnsproxy1", "on"]
  end

  config.vm.provision "shell", inline: <<-SHELL
  
  sudo -i
  yum update
  yum install -y httpd expect mariadb-server php php-pear php-mysql java-1.8.0-openjdk-devel unzip git

  # Set JAVA_HOME for vagrant user
  echo "export JAVA_HOME=/usr/lib/jvm/java" >> /home/vagrant/.bashrc
  chown vagrant:vagrant /home/vagrant/.bashrc
  source /home/vagrant/.bashrc

  # Set JAVA_HOME for root user
  echo "export JAVA_HOME=/usr/lib/jvm/java" >> /root/.bashrc

  #For audit2allow
  #yum install -y policycoreutils-python 
  
  sudo systemctl enable httpd
  sudo systemctl start httpd
  sudo systemctl enable mariadb.service
  sudo systemctl start mariadb.service
  
  VARA=$(expect -c '
  spawn /usr/bin/mysql_secure_installation
  expect "Enter current password for root (enter for none):"
  send "\r"
  expect "Set root password?"
  send "Y\r"
  expect "New password:"
  send "swfc4life\r"
  expect "Re-enter new password:"
  send "swfc4life\r"
  expect "Remove anonymous users?"
  send "Y\r"
  expect "Disallow root login remotely?"
  send "Y\r"
  expect "Remove test database and access to it?"
  send "Y\r"
  expect "Reload privilege tables now?"
  send "Y\r"
  expect eof
  ')
  echo "$VARA"

  #Setup the Database
  echo "create database cardinfo" | mysql --user=root --password=swfc4life
  mysql --user=root --password=swfc4life cardinfo < /home/vagrant/SWFC-Simulator/database/cardinfo.sql
  semodule -i /home/vagrant/SWFC-Simulator/security/swfc.pp

  #Build and install the app
  sudo -u vagrant -i
  cd /home/vagrant/SWFC-Simulator
  ./build.sh
  SHELL
end
