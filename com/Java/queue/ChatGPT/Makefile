compile:
	javac ChatGPT.java

measure:
	java -Xmx10m ChatGPT 1000

run:
	java -cp . ChatGPT

mem:
	/usr/bin/time -v java -cp . -Xmx10m ChatGPT 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m ChatGPT 1000
