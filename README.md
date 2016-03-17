Vehicle Counter
==============

This is a coding test for implementation a vehicle counter. Please read REQUESTMENT.md for more detail.

ENV Requirement
----------------
* Maven(>3.0.0)
* JSDK (>1.8.0)
* JUnit

Compile
-----
type:

    mvn compile
   
Unit Test
---------
Just type:
    
    mvn test
    
Usage
-----

	java -cp CLASSPATH gov.city.vehicleCounter.App dataFilePath [timespan]
	
	This is a simple command line tools to analyze the data file of 'vehicle counter' sensors
	
	Timespan:
		day - Timespan is 24 hours, you can get the report of day
		hd - Timespan is 12 hours, you can get the report of morning & evening
		hour - Timespan is 1 hour, you can get the report of hours
		30 - Timespan is 30 minutes, you can get the report of half hour
		20 - Timespan is 20 minutes, you can get the report of 20 minutes
		15 - Timespan is 15 minutes, you can get the report of 15 minutes
		[empty] - A set of reports including all above

Show Usage Help:

	java -cp CLASSPATH gov.city.vehicleCounter.App -h

If you are in the directory ./vehicle-counter, the CLASSPATH is target/classes, example:

	java -cp target/classes gov.city.vehicleCounter.App datafile.txt


