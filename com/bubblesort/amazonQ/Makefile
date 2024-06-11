compile:
	/usr/bin/javac -d . amazonQ.java

measure:
<<<<<<< HEAD
	/usr/bin/java -Xmx10m amazonQ 1000
=======
	/usr/bin/java -cp . amazonQ 10000
>>>>>>> 940bb33bcea40c37a8390f8a77a489cdf72996bd

run:
	/usr/bin/java -cp . amazonQ

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.amazonQ.amazonQ 10000
