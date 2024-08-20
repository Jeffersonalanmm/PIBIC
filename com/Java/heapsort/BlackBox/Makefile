compile:
	javac BlackBox.java

measure:
	java -Xmx10m BlackBox 1000

run:
	java -cp . BlackBox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.BlackBox.BlackBox 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.BlackBox.BlackBox 1000
