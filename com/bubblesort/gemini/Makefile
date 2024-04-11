compile:
	/usr/bin/javac -d . gemini.java

measure:
	/usr/bin/java -cp . gemini 10000

run:
	/usr/bin/java -cp . -Xmx2g gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.gemini.gemini 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.gemini.gemini 10000
