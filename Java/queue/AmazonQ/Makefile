compile:
	javac AmazonQ.java

measure:
	java -Xmx10m AmazonQ 1000

run:
	java -cp . AmazonQ

mem:
	/usr/bin/time -v java -cp . -Xmx10m AmazonQ 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m AmazonQ 1000
