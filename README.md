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

Questions? Add me on Line @Sqam

##mmmhax

#Example images of the configuration:

![alt tag](https://i.gyazo.com/75373d5b119a53cec727235a40c384d7.png)
![alt tag](https://i.gyazo.com/aa0bc29225676517f142539dd4e9d531.png)
