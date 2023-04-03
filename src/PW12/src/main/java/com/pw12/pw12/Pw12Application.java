package com.pw12.pw12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//./gradlew bootRun -Pargs="input.txt","output.txt"
@SpringBootApplication
public class Pw12Application implements CommandLineRunner {
	@Autowired
	private FileWorker fileWorker;

	public static void main(String[] args) {
		SpringApplication.run(Pw12Application.class, args);
	}

	@Override
	public void run(String... args) {
		if (args.length == 2)
			fileWorker.start(args[0], args[1]);
		else
			fileWorker.hash();
	}
}
