package si20.mqdemo.testproducer.commandLine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendMsgCmdLineRunner implements CommandLineRunner {

    private JmsTemplate jmsTemplate;

    public SendMsgCmdLineRunner(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        jmsTemplate.convertAndSend("/queue/test", "Hello World from Java!");
    }
}
