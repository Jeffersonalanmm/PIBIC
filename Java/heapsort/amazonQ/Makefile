compile:
	javac amazonQ.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . heapsort.amazonQ.amazonQ 1000" Java amazonQ

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . heapsort.amazonQ.amazonQ 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . heapsort.amazonQ.amazonQ 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . heapsort.amazonQ.amazonQ 1000
