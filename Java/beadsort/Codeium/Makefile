compile:
	javac Codeium.java

measure:
	java -Xmx10m Codeium 1000

run:
	java -cp . Codeium

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.beadsort.Codeium.Codeium 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.beadsort.Codeium.Codeium 1000
