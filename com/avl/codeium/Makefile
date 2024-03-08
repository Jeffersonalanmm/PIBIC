compile:
	/usr/bin/javac -d . codeium.java

measure:
	/usr/bin/java -Xmx10m codeium 100000

run:
	/usr/bin/java -cp . codeium

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.codeium.codeium 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.codeium.codeium 100000
