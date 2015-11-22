package pl.stepniak.example.client;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RestController;
import pl.stepniak.example.utils.ApiVerifier;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientSaver clientSaver;
    @Autowired
    private ApiVerifier verifier;

    @RequestMapping(method = GET, value = "/list")
    public List<ClientModel> fetchClients(@RequestHeader(value = "session_key", required = false) String sessionKey) {
        verifier.verifyUser(sessionKey);
        return clientRepository.fetchClients();
    }

    @RequestMapping(method = GET, value = "{clientId}")
    public ClientModel getClient(@RequestHeader(value = "session_key", required = false) String sessionKey, @PathVariable Long clientId) {
        verifier.verifyUser(sessionKey);
        return clientRepository.getClient(clientId);
    }

    @RequestMapping(method = POST, value = "/new")
    public ClientModel createKeyword(@RequestHeader(value = "session_key", required = false) String sessionKey, @RequestBody ClientModel client) {
        verifier.verifyUser(sessionKey);
        return clientSaver.createClient(client);

    }

    @RequestMapping(method = PUT, value = "/update")
    public ClientModel updateKeyword(@RequestHeader(value = "session_key", required = false) String sessionKey, @RequestBody ClientModel client) {
        verifier.verifyUser(sessionKey);
        return clientSaver.updateClient(client);
    }

    @RequestMapping(method = DELETE, value = "{clientId}")
    public Integer deleteKeyword(@RequestHeader(value = "session_key", required = false) String sessionKey, @PathVariable Long clientId) {
        verifier.verifyUser(sessionKey);
        return clientRepository.deleteClient(clientId);

    }

}
