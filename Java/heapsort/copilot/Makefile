compile:
	javac copilot.java

measure:
	java -Xmx10m copilot 1000

run:
	java -cp . copilot

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.copilot.copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.copilot.copilot 1000
