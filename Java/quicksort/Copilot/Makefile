compile:
	javac Copilot.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . quicksort.Copilot.Copilot 1000" Java Copilot

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . quicksort.Copilot.Copilot 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . quicksort.Copilot.Copilot 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . quicksort.Copilot.Copilot 1000
