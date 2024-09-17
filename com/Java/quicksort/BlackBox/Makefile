compile:
	javac BlackBox.java

measure:
	java -Xmx10m BlackBox 1000

run:
	java -cp . BlackBox

mem:
	/usr/bin/time -v java -cp . -Xmx10m BlackBox 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m BlackBox 1000