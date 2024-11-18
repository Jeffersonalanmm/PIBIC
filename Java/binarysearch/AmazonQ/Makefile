compile:
	javac AmazonQ.java

measure:
	java -Xmx10m AmazonQ 1000

run:
	java -cp . AmazonQ

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m beadsor.AmazonQ.AmazonQ 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m beadsort.AmazonQ.AmazonQ 1000
