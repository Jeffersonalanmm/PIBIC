compile:
	/usr/bin/javac -d . rosetta.java

measure:
	/usr/bin/java -cp . rosetta 1000

run:
	/usr/bin/java -cp . -Xmx2g rosetta

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.rosetta.rosetta 1000
