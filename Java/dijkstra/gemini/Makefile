compile:
	javac gemini.java

measure:
	java -Xmx10m gemini 1000

run:
	java -cp . -Xmx2g gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.gemini.gemini 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.gemini.gemini 1000
