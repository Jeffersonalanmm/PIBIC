compile:
	javac codeium.java

measure:
	java -Xmx10m codeium 1000

run:
	java -cp . codeium

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.codeium.codeium 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.codeium.codeium 1000
