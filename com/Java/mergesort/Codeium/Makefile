compile:
	javac Codeium.java

measure:
	java -Xmx10m Codeium 1000

run:
	java -cp . Codeium

mem:
	/usr/bin/time -v java -cp . -Xmx10m Codeium 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m Codeium 1000
