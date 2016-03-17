Vehicle Counter
==============

This is a coding test for implementation a vehicle counter. Please read REQUESTMENT.md for more detail.

ENV Requirement
----------------
* Maven(>3.0.0)
* JSDK(> 1.8.0)
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
java -cp  CLASSPATH gov.city.vehicleCounter.App DATA_filePath




Code Challenge
==============

A small city government recently bought a vehicle counter. In order for the vehicle counter to work, pneumatic rubber hoses are stretched across the road. Data is produced by the vehicle counter as traffic drives across the hoses. The city government requires a program to interpret the data that the machine produces.


The data from the machine looks like this:

    A268981
    A269123
    A604957
    B604960
    A605128
    B605132
    A1089807
    B1089810
    A1089948
    B1089951

The numbers are the number of milliseconds since midnight when the mark occurred. Thus, the first line above represents a pair of tires driving by at 12:04:28am. The second line represents another pair of tires going by 142ms later (almost certainly the 2nd axle of the car).

The vehicle counter has two pneumatic rubber hoses - one stretches across both lanes of traffic, and one goes just across traffic in one direction. Each hose independently records when tires drive over it. As such, cars going in one direction (say, northbound) only record on one sensor (preceded with an 'A'), while cars going in the direction (say, southbound) are recorded on both sensors. Lines 3-6 above represent a second car going in the other direction. The first set of tires hit the 'A' sensor at 12:10:04am, and then hit the 'B' sensor 3ms later. The second set of tires then hit the 'A' sensor 171ms later, and then the 'B' sensor 4ms later.

The machine was left to run for 5 days in a row (starting on a Monday). This is obvious because the times in the data make several sudden drops:

     A86328771
     B86328774
     A86328899
     B86328902
     A582668
     B582671
     A582787
     B582789

The city has asked you to create a command line interface for end user to query the following analytic data:

1. Total vehicle counts in each direction: morning versus evening, per hour, per half hour, per 20 minutes, and per 15 minutes.
2. The above counts can be displayed for each day of the session, or you can see averages across all the days.
3. Peak volume times.

Luckily for you, you know that:
------------------------------

1. The speed limit on the road where this is recorded is 60kph (that doesn't mean that everyone drives this speed, or that no one exceeds it, but it's a good starting point).
2. The average wheelbase of cars in the city is around 2.5 metres between axles.
3. Only 2-axle vehicles were allowed on this road during the recording sessions.



Deliverable requirements:
-------------------------

1. This coding challenge should be accompanied with a data file containing the full vehicle survey data to be analysed by the program.
2. The deliverable should contain executable, source code and instructions to execute. 
3. You should only use core Java libraries to implement the solution (No third-party libraries should be used). 
4. For testing, you can choose any third-party libraries/frameworks.
4. The executable should be able to take a data file path as input parameter.


