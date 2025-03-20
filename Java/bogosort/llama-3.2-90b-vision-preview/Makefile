compile:
	javac -d . Llama_3_2_90b_vision_preview.java

measure:
	sudo modprobe msr
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Llama_3_2_90b_vision_preview 10" Java Llama_3_2_90b_vision_preview

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Llama_3_2_90b_vision_preview 10

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . Llama_3_2_90b_vision_preview 10

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . Llama_3_2_90b_vision_preview 10
