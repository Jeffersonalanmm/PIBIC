compile:
	javac TheAlgorithms.java

measure:
	java -Xmx10m TheAlgorithms 1000

run:
	java -cp . TheAlgorithms

mem:
	/usr/bin/time -v java -cp . -Xmx10m TheAlgorithms 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -cp . -Xmx10m TheAlgorithms 1000
