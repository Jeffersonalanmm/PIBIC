compile:
	javac BlackBox.java

measure:
	java -Xmx10m BlackBox 100000

run:
	java -cp . BlackBox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.BlackBox.BlackBox 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.BlackBox.BlackBox 100000
