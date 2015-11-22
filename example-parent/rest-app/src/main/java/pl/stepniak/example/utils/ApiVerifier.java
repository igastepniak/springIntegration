package pl.stepniak.example.utils;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.stepniak.example.exceptions.Unauthorized;
import static pl.stepniak.example_db.tables.Client.CLIENT;

@Component
public class ApiVerifier {

    private static final String AUTORIZATION_WITH_API_FAILED = "Autorization with API failed";
    private final DSLContext mJooq;

    @Autowired
    public ApiVerifier(DSLContext jooq) {
        this.mJooq = jooq;
    }

    public long verifyUser(String sessionKey) {

        if (sessionKey == null) {
            throw new Unauthorized(AUTORIZATION_WITH_API_FAILED);
        }

        Record value = mJooq.select().from(CLIENT).where((CLIENT.SESSION_KEY.trim().eq(sessionKey.trim()))).fetchOne();

        if (value == null) {
            throw new Unauthorized(AUTORIZATION_WITH_API_FAILED);
        }

        return value.getValue(CLIENT.ID);
    }

}
