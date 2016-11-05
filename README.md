# SWFC-Simulator
A noobish try to create a SWFC battle simulator

Thought I'd release my SWFC simulator project as I'm no longer working on it, maybe other people can continue to develop it.
All features later than 27.01.16 are not included (like cards, skills ...) and quite some who were released before that (like vehicles).
The simulator itself is written in Java (so you need Java to be installed) and I added some php scripts to visualize and make it easier to run it.
It pulls the card information from a simple MySQL database, I added a .sql file that you can easily import.


So how the f*ck do I run this?

You'll need an IDE (like Eclipse), a JDBC driver (https://dev.mysql.com/downloads/connector/j/5.1.html) as referenced library, (and if you
want to visualize the battle) a program like xampp to setup the SQL database and run the php scripts (https://www.apachefriends.org/index.html)
and the huge image folder for the card images (https://www.dropbox.com/s/rcd5lk6bg81glfw/images.zip).

You can easily run the simulator in your IDE, you just need to pass the paramters manually. And maybe change the info() functions to
actually print out useful information instead of html code.
If you want to run the simulator with the php scripts, start with "../deckbuilder/j_deckbuilder_create.php", the simulator.jar is the version
from the 27th January 2016. If you change code in the simulator, just export it as .jar file and replace the current simulator.jar.

#Questions? Add me on Line @Sqam

### #mmmhax

#Example images:
http://imgur.com/a/KcpWp

# Vagrant

Vagrant is software that can build a virtual machine from a file containing instructions on what to build. It is often used by developers to preserve and share their development environment. Source code is shared between the host machine and the virtual machine.

To use Vagrant: (for OSX, Linux, or windows)

1. Install virtualbox: https://www.virtualbox.org/wiki/Downloads
1. Install Vagrant: https://www.vagrantup.com/downloads.html
1. Install Vagrant vbguest additions: `$ vagrant plugin install vagrant-vbguest`
1. Start Vagrant. On the command line from the same directory as the Vagrantfile (this will take a while the first time you run it)

    ```$ vagrant up```

1. Browse to the simulator: http://localhost:8080

1. You can edit code etc by sshing into the vagrant machine

```shell
$ vagrant ssh
$ cd SWFC-Simulator
```

# Development Cycle
In the SWFC-Simulator directory, there is a build.sh script. After making changes to source code just run
```./build.sh``` This will compile the java code, deploy all code to the webserver (at /var/www), and restart the webserver.
