compile:
	javac chatGPT.java

measure:
	java -Xmx10m chatGPT 1000

run:
	java -cp . -Xmx2g chatGPT

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m com.avl.chatGPT.chatGPT 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m com.avl.chatGPT.chatGPT 1000
