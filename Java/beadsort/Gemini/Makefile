compile:
	javac Gemini.java

measure:
	java -Xmx10m Gemini 1000

run:
	java -cp . Gemini

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.beadsort.Gemini.Gemini 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.beadsort.Gemini.Gemini 1000
