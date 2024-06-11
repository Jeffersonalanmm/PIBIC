compile:
	/usr/bin/javac -d . blackbox.java

measure:
	/usr/bin/java -Xmx10m blackbox 10000

run:
	/usr/bin/java -cp . blackbox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.blackbox.blackbox 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.blackbox.blackbox 10000
