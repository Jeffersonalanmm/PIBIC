compile:
	javac -d . Codeium.java

measure:
	sudo modprobe msr
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.Codeium.Codeium 10" Java Codeium

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.Codeium.Codeium 10

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . bogosort.Codeium.Codeium 10

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . bogosort.Codeium.Codeium 10
