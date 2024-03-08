compile:
	/usr/bin/javac -d . theAlgorithms.java

measure:
	/usr/bin/java -Xmx10m theAlgorithms 100000

run:
	/usr/bin/java -cp . theAlgorithms

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.theAlgorithms.theAlgorithms 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.theAlgorithms.theAlgorithms 100000
