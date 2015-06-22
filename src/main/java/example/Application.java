package example;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Application {

	public static void main(String... args) {
		SpringApplication.run(Application.class, args);
	}
	
	@EventListener
	public void curl(ApplicationReadyEvent ready) throws IOException, InterruptedException {
		
		// This should return a 400 but returns a 200
		Process p = new ProcessBuilder().inheritIO().command(
				"/usr/bin/curl",
				"-v" ,
				"-s",
				"-XPOST",
	            "-H", "Content-Type: application/json",
	            "http://localhost:8080/entities",
	            "-d", "{}").start();
		p.waitFor();
	}
	
}
