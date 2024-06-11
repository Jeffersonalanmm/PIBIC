compile:
	/usr/bin/javac -d . theAlgorithms.java

measure:
	/usr/bin/java -Xmx10m theAlgorithms 10000

run:
	/usr/bin/java -cp . theAlgorithms

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.theAlgorithms.theAlgorithms 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.theAlgorithms.theAlgorithms 10000
