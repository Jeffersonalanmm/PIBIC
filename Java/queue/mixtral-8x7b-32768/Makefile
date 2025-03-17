compile:
	javac -d . Mixtral_8x7b_32768.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Mixtral_8x7b_32768 1000" Java Mixtral_8x7b_32768

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Mixtral_8x7b_32768 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . Mixtral_8x7b_32768 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . Mixtral_8x7b_32768 1000
