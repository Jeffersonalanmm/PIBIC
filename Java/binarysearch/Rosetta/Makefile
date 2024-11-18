compile:
	javac Rosetta.java

measure:
	java -Xmx10m Rosetta 1000

run:
	java -cp . Rosetta

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m beadsor.Rosetta.Rosetta 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m beadsort.Rosetta.Rosetta 1000
