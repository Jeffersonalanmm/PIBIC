compile:
	javac Gemini.java

measure:
	java -Xmx10m Gemini 1000

run:
	java -cp . Gemini

mem:
	/usr/bin/time -v java -cp . -Xmx10m Gemini 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m Gemini 1000
