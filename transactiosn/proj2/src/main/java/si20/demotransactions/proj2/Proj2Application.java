package si20.demotransactions.proj2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class Proj2Application {

    public static void main(String[] args) {
        SpringApplication.run(Proj2Application.class, args);
    }

}
