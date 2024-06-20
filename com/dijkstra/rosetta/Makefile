compile:
	javac rosetta.java

measure:
	java -Xmx10m rosetta 1000

run:
	java -cp . -Xmx2g rosetta

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 1000
