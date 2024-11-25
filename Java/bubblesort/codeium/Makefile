compile:
	javac codeium.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . binarysearch.codeium.codeium 1000" Java codeium

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . binarysearch.codeium.codeium 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . binarysearch.codeium.codeium 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . binarysearch.codeium.codeium 1000
