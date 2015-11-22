package pl.stepniak.example.client;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stepniak.example.exceptions.NotFoundException;
import pl.stepniak.example.utils.Utils;
import static pl.stepniak.example_db.tables.Client.CLIENT;
import pl.stepniak.example_db.tables.records.ClientRecord;

@Component
public class ClientSaver {

    private static final String CLIENT_NOT_FOUND = "Client not found";
    private static final String NEXT_ID = "next_id";
    private final DSLContext jooq;
    private final ClientRepository clientRepo;

    @Autowired
    public ClientSaver(DSLContext jooq, ClientRepository clientRepo) {
        this.jooq = jooq;
        this.clientRepo = clientRepo;
    }

    public final ClientModel createClient(ClientModel client) {
        ClientRecord record = updateOrCreateClient(client, null);
        return record.map(clientRepo::toClient);
    }

    public final ClientModel updateClient(ClientModel client) {
        ClientRecord record = jooq.selectFrom(CLIENT).where(CLIENT.ID.eq(client.getId())).fetchOne();
        if (record == null) {
            throw new NotFoundException(CLIENT_NOT_FOUND);
        }
        updateOrCreateClient(client, record);
        return record.map(clientRepo::toClient);
    }

    public final ClientRecord updateOrCreateClient(ClientModel client, ClientRecord record) {

        if (record == null) {
            record = jooq.newRecord(CLIENT);

            Long nextId = jooq
                    .select(CLIENT.ID.max().add(1L).as(NEXT_ID))
                    .from(CLIENT)
                    .fetchOne()
                    .value1();
            record.setId(nextId);

        } 
        record.setAccountLevel(client.getAccountLevel());
        record.setCreatedDate(Utils.convertDateToSqlDate(client.getCreatedDate()));
        record.setEmail(client.getEmail());
        record.setPassword(client.getPassword());
        record.setPromo(client.getPromo());
        record.setTermsAcceptedDate(Utils.convertDateToSqlDate(client.getTermsAcceptedDate()));
        record.setTimezone(client.getTimeZone());
        record.setUsername(client.getUsername());
        record.store();
        return record;
    }

}
