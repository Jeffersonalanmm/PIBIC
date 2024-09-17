compile:
	javac SortUtils.java SortAlgorithm.java TheAlgorithms.java

measure:
	java -Xmx10m TheAlgorithms 1000

run:
	java -cp . TheAlgorithms

mem:
	/usr/bin/time -v java -cp . -Xmx10m TheAlgorithms 1000

valgrind:
	valgrind --tool=massif --stacks=yes java -cp . -Xmx10m TheAlgorithms 1000
