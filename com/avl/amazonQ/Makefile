compile:
	/usr/bin/javac -d . amazonQ.java

measure:
	/usr/bin/java -Xmx10m amazonQ 100000

run:
	/usr/bin/java -cp . amazonQ

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 100000