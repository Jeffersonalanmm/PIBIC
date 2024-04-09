compile:
	/usr/bin/javac -d . blackbox.java

measure:
	/usr/bin/java -cp . blackbox 1000

run:
	/usr/bin/java -cp . -Xmx2g blackbox

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.blackbox.blackbox 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.blackbox.blackbox 1000
