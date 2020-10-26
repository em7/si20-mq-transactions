package si20.demotransactions.proj1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si20.demotransactions.proj1.model.FakeUserRepository;
import si20.demotransactions.proj1.model.User;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final String messageDestination;

    private final JmsTemplate jmsTemplate;
    private final FakeUserRepository fakeUserRepository;

    public DemoController(@Value("${message.destination}") String messageDestination,
                          JmsTemplate jmsTemplate,
                          FakeUserRepository fakeUserRepository) {
        this.messageDestination = messageDestination;
        this.jmsTemplate = jmsTemplate;
        this.fakeUserRepository = fakeUserRepository;
    }

    @GetMapping("/findUser/{name}")
    @Transactional
    public String findUserTransactional(@PathVariable String name) {
        jmsTemplate.convertAndSend(messageDestination, String.format("Search for user '%s' has begun.", name));
        User retrieved = fakeUserRepository.retrieveUser(name);
        jmsTemplate.convertAndSend(messageDestination, String.format("Search for user '%s' has finished.", name));
        return String.format("User found '%s'.", retrieved.getName());
    }
}
