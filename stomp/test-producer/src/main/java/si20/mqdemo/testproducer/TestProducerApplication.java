package si20.mqdemo.testproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class TestProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestProducerApplication.class, args);
    }

}
