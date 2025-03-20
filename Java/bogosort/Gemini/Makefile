compile:
	javac -d . Gemini.java

measure:
	sudo modprobe msr
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.Gemini.Gemini 10" Java Gemini

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . bogosort.Gemini.Gemini 10

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . bogosort.Gemini.Gemini 10

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . bogosort.Gemini.Gemini 10
