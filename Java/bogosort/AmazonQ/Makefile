compile:
	javac -d . AmazonQ.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.AmazonQ.AmazonQ 10" Java AmazonQ

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.AmazonQ.AmazonQ 10

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . bogosort.AmazonQ.AmazonQ 10

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . bogosort.AmazonQ.AmazonQ 10
