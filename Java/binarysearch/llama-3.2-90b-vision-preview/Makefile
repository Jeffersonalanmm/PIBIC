compile:
	javac -d . Llama_3_2_90b_vision_preview.java

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Llama_3_2_90b_vision_preview 1000

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . Llama_3_2_90b_vision_preview 1000

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . Llama_3_2_90b_vision_preview 1000
