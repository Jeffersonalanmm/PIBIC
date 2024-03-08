compile:
	/usr/bin/javac -d . copilot.java

measure:
	/usr/bin/java -cp . copilot 1000

run:
	/usr/bin/java -cp . -Xmx2g copilot

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.copilot.copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.copilot.copilot 1000
