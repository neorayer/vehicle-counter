#!/bin/sh

# --------------------------------------------------------------------------
# Usage: java -cp CLASSPATH gov.city.vehicleCounter.App dataFilePath [timespan]
#
# This is a simple command line tools to analyze the data file of 'vehicle counter' sensors
#
# Timespan:
# 	day - Timespan is 24 hours, you can get the report of day
# 	hd - Timespan is 12 hours, you can get the report of morning & evening
# 	hour - Timespan is 1 hour, you can get the report of hours
# 	30 - Timespan is 30 minutes, you can get the report of half hour
# 	20 - Timespan is 20 minutes, you can get the report of 20 minutes
# 	15 - Timespan is 15 minutes, you can get the report of 15 minutes
# 	[empty] - A set of reports including all above
# -------------------------------------------------------------------------------

PRG="$0"
PRGDIR=`dirname "$PRG"`
CLASSPATH=$PRGDIR/vehicle-counter.jar
java -cp $CLASSPATH gov.city.vehicleCounter.App $1 $2
