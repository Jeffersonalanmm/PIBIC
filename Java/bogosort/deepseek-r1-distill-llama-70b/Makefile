compile:
	javac -d . Deepseek_r1_distill_llama_70b.java

measure:
	sudo ../RAPL/main "/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Deepseek_r1_distill_llama_70b 10" Java Deepseek_r1_distill_llama_70b

run:
	/usr/lib/jvm/java-11-openjdk-amd64/bin/java -cp . Deepseek_r1_distill_llama_70b 10

mem:
	/usr/bin/time -v /usr/bin/java -Xmx10m -cp . Deepseek_r1_distill_llama_70b 10

valgrind:
	valgrind --tool=massif --stacks=yes /usr/bin/java -Xmx10m -cp . Deepseek_r1_distill_llama_70b 10
