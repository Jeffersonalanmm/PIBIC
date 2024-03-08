compile:
	/usr/bin/javac -d . gemini.java

measure:
	/usr/bin/java -cp . gemini 1000

run:
	/usr/bin/java -cp . -Xmx2g gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.gemini.gemini 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.gemini.gemini 1000
