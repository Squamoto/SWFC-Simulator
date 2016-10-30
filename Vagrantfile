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
  end

  config.vm.provision "shell", inline: <<-SHELL
  
  sudo -i
  yum update
  yum install -y httpd expect mariadb-server php php-pear php-mysql java-1.8.0-openjdk unzip git
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

  cd /home/vagrant/SWFC-Simulator/images
  if [[ ! -f /home/vagrant/SWFC-Simulator/images/images.zip ]]; then
    curl -L -O https://www.dropbox.com/s/rcd5lk6bg81glfw/images.zip
  fi

  cp -r /home/vagrant/SWFC-Simulator/deckbuilder /var/www/html/simulator
  cp  /home/vagrant/SWFC-Simulator/deckbuilder/index.html /var/www/html
  mkdir -p /var/www/html/SWFC
  cp -r /home/vagrant/SWFC-Simulator/images /var/www/html/SWFC/images
  SHELL
end
