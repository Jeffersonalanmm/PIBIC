compile:
	/usr/bin/javac -d . chatGPT.java

measure:
	/usr/bin/java -cp . chatGPT 1000

run:
	/usr/bin/java -cp . -Xmx2g chatGPT

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.heapsort.chatGPT.chatGPT 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.heapsort.chatGPT.chatGPT 1000
