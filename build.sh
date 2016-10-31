#!/bin/bash -e

rm -rf output
mkdir -p output/html/simulator

#Copy deckbuilder files
cp -r deckbuilder/* output/html/simulator
cp deckbuilder/index.html output/html

#Compile and build simulator.jar
cd "SWFC Simulator"
./gradlew clean jar
cp build/libs/SWFC\ Simulator.jar ../output/html/simulator/simulator.jar
cd ..


#Fetch images if we haven't
cd /home/vagrant/SWFC-Simulator/images
if [[ ! -f images.zip ]]; then
  echo "Fetching images"
  curl -L -O https://www.dropbox.com/s/rcd5lk6bg81glfw/images.zip
fi

#Unzip images --there's an error in the zip
unzip -q -o images.zip || true
mkdir -p ../output/html/SWFC/images
cp -r /home/vagrant/SWFC-Simulator/images/images/* ../output/html/SWFC/images

#Deploy the files
echo Stopping service
sudo systemctl stop httpd
echo Deploying new files
set +e
sudo rm -r /var/www/html/SWFC
sudo rm -r /var/www/html/simulator
set -e
sudo cp -r /home/vagrant/SWFC-Simulator/output/html/* /var/www/html
echo Re-starting service
sudo systemctl start httpd
