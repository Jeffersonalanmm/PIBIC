compile:
	javac Copilot.java

measure:
	java -Xmx10m Copilot 1000

run:
	java -cp . Copilot

mem:
	/usr/bin/time -v java -cp . -Xmx10m Copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m Copilot 1000
