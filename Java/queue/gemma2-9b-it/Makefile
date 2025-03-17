compile:
	javac -d . Gemma2_9b_it.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Gemma2_9b_it 1000" Java Gemma2_9b_it

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Gemma2_9b_it 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . Gemma2_9b_it 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . Gemma2_9b_it 1000
