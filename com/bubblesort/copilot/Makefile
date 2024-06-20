compile:
	javac copilot.java

measure:
	java -Xmx10m copilot 10000

run:
	java -cp . copilot

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.copilot.copilot 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.copilot.copilot 10000
