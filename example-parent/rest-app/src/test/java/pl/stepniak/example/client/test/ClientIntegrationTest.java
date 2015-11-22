package pl.stepniak.example.client.test;

import java.util.List;
import javafx.application.Application;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.stepniak.example.client.ClientModel;
import pl.stepniak.example.client.ClientRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:database-test.properties")
@ContextConfiguration(classes = Application.class)
public class ClientIntegrationTest {

    @Autowired
    private ClientRepository repo;

    @Test
    public void should_return_proper_sponsor_list_length() {
        List<ClientModel> allClients = repo.fetchClients();
        assertThat("Client list shoud return 7 record", allClients.size(), is(7));
    }
}
