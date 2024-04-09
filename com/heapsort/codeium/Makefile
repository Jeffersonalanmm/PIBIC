compile:
	/usr/bin/javac -d . codeium.java

measure:
	/usr/bin/java -cp . codeium 1000

run:
	/usr/bin/java -cp . -Xmx2g codeium

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.codeium.codeium 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.codeium.codeium 1000
