# Aliot

This project shoudl help Gabbay to get list of sugested Olim for the next Shabbat.

Requirements:
* Bassed on important dates of each Prayer and based on last time the prayer recieved Aliyah, we shoudl get the list of next X suggested Olim.
* Statistics on the Prayers (list of Aliyot, etc.)
* Prayers' info (Important dates, etc.)


### For Developers:

Need to get the HebCalendar (great work!)
1. To do so, get project from https://github.com/hebcal/hebcal-java 
2. maven package it using mvn assembly:assembly
3. Set it into your repository using >mvn install:install-file -Dfile=<path_to_jar>\hebcalJ-0.5.jar -DgroupId=net.sf.hebcal -DartifactId=hebcalJ -Dversion=0.5 -Dpackaging=jar -DgeneratePom=true
4. Then add it as a dependency in pom:
```
  <dependency>
    <groupId>net.sf.hebcal</groupId>
    <artifactId>hebcalJ</artifactId>
      <packaging>jar</packaging>
    <version>0.5</version>
  </dependency>
```
