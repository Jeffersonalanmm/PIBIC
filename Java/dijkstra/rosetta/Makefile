compile:
	javac rosetta.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . dijkstra.rosetta.rosetta 1000" Java rosetta

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . dijkstra.rosetta.rosetta 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . dijkstra.rosetta.rosetta 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . dijkstra.rosetta.rosetta 1000
