package spring;

import org.apache.log4j.Logger;

public class MemoryStorage implements Storage {
    private static final Logger LOG = Logger.getLogger(MemoryStorage.class);

    @Override
    public void add(User user) {
        LOG.info("Store to memory");
    }
}
