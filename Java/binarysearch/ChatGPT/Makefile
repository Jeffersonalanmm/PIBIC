compile:
	javac ChatGPT.java

measure:
	java -Xmx10m ChatGPT 1000

run:
	java -cp . ChatGPT

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m beadsor.ChatGPT.ChatGPT 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m beadsort.ChatGPT.ChatGPT 1000
