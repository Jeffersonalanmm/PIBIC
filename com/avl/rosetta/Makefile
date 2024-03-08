compile:
	/usr/bin/javac -d . rosetta.java

measure:
	/usr/bin/java -Xmx10m rosetta 100000

run:
	/usr/bin/java -cp . rosetta

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 100000
