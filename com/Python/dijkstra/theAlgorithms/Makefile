compile:
	javac theAlgorithms.java

measure:
	java -Xmx10m theAlgorithms 1000

run:
	java -cp . -Xmx2g theAlgorithms

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.theAlgorithms.theAlgorithms 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.theAlgorithms.theAlgorithms 1000
