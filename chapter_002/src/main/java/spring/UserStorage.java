package spring;

import org.apache.log4j.Logger;

public class UserStorage {
    private static final Logger LOG = Logger.getLogger(UserStorage.class);
    private final Storage storage;

    public UserStorage(final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
