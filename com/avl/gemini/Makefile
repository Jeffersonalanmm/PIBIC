compile:
	/usr/bin/javac -d . gemini.java

measure:
	/usr/bin/java -Xmx10m gemini 100000

run:
	/usr/bin/java -cp . gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.gemini.gemini 100000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.gemini.gemini 100000
