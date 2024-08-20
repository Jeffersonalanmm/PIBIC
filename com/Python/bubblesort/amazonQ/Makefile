compile:
	javac amazonQ.java

measure:
	java -Xmx10m amazonQ 1000
	
run:
	java -cp . amazonQ

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 10000
