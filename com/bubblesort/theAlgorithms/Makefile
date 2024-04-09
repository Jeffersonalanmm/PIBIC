compile:
	/usr/bin/javac -d . theAlgorithms.java

measure:
	/usr/bin/java -cp . theAlgorithms 1000

run:
	/usr/bin/java -cp . -Xmx2g theAlgorithms

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.theAlgorithms.theAlgorithms 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.theAlgorithms.theAlgorithms 1000
