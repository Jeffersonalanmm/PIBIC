compile:
	javac chatGPT.java

measure:
	java -Xmx10m chatGPT 10000

run:
	java -cp . chatGPT

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.bubblesort.chatGPT.chatGPT 10000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.bubblesort.chatGPT.chatGPT 10000
