compile:
	javac -d . AmazonQ.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . binarysearch.AmazonQ.AmazonQ 1000" Java AmazonQ

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . binarysearch.AmazonQ.AmazonQ 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . binarysearch.AmazonQ.AmazonQ 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . binarysearch.AmazonQ.AmazonQ 1000
