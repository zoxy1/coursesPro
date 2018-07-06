package spring;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("jdbcStorage")
public class JdbcStorage implements Storage {
    private static final Logger LOG = Logger.getLogger(JdbcStorage.class);

    @Override
    public void add(User user) {
        LOG.info("Store to jdbc");
    }
}
