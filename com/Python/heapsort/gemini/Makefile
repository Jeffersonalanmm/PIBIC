compile:
	javac gemini.java

measure:
	java -Xmx10m gemini 1000

run:
	java -cp . gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.gemini.gemini 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.gemini.gemini 1000
