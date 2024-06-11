compile:
	/usr/bin/javac -d . copilot.java

measure:
	/usr/bin/java -Xmx10m copilot 1000

run:
	/usr/bin/java -cp . copilot

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.copilot.copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.copilot.copilot 1000
