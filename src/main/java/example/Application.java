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
		// Results in 500
		Process p = new ProcessBuilder().inheritIO().command(
				"/usr/bin/curl",
				"-v" ,
				"-s",
	            "http://localhost:8080/alps/entities").start();
		p.waitFor();
	}

}
