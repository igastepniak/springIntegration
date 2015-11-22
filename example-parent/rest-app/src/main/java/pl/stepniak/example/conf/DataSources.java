package pl.stepniak.example.conf;

import javax.sql.DataSource;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSources {

    public static final String JOOQ_EXAMPLE = "jooq.example";

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier(JOOQ_EXAMPLE)
    public DSLContext exampleJooqProvider() {
        return DSL.using(primaryDataSource(), SQLDialect.POSTGRES);
    }
}