package pl.stepniak.example.client;

import java.util.List;
import java.util.Optional;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stepniak.example.exceptions.NotFoundException;
import static pl.stepniak.example_db.tables.Client.CLIENT;
import pl.stepniak.example_db.tables.records.ClientRecord;

@Component
public class ClientRepository {

    private static final String CLIENT_NOT_FOUND = "Client not found";
    private final DSLContext jooq;

    @Autowired
    public ClientRepository(DSLContext jooq) {
        this.jooq = jooq;
    }

    public List<ClientModel> fetchClients() {
        return jooq.fetch(CLIENT).map(this::toClient);
    }

    public ClientModel getClient(Long clientId) {
        ClientRecord record = jooq.selectFrom(CLIENT)
                .where(CLIENT.ID.eq(clientId))
                .fetchOne();

        Optional<ClientModel> optional = Optional.ofNullable(toClient(record));
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException(CLIENT_NOT_FOUND);
        }
    }

    public int deleteClient(Long clientId) {
        ClientModel client = getClient(clientId);
        return jooq.deleteFrom(CLIENT).where(CLIENT.ID.eq(client.getId())).execute();
    }

    public ClientModel toClient(Record record) {
        return ClientModel.builder()
                .name(record.getValue(CLIENT.NAME))
                .accountLevel(record.getValue(CLIENT.ACCOUNT_LEVEL))
                .createdDate(record.getValue(CLIENT.CREATED_DATE))
                .email(record.getValue(CLIENT.EMAIL))
                .password(record.getValue(CLIENT.PASSWORD))
                .promo(record.getValue(CLIENT.PROMO))
                .replacementCount(countReplacement(record))
                .termsAcceptedDate(record.getValue(CLIENT.TERMS_ACCEPTED_DATE))
                .trackingUrlCount(countTrackingUrls(record))
                .id(record.getValue(CLIENT.ID))
                .build();
    }

    public Integer countReplacement(Record record) {
        return 0;
    }

    public Integer countTrackingUrls(Record record) {
        return 0;
    }
}
