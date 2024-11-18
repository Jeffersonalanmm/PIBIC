compile:
	javac Copilot.java

measure:
	java -Xmx10m Copilot 1000

run:
	java -cp . Copilot

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m beadsor.Copilot.Copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m beadsort.Copilot.Copilot 1000
