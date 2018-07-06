package spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

public class UserStorageTest {
    @Test
    public void whenAddUserToStorageShouldSaveIt() throws Exception {
       MemoryStorage memmoryStorage = new MemoryStorage();
        UserStorage storage = new UserStorage(memmoryStorage);
        storage.add(new User());
    }

    @Test
    public void whenLoadContexShouldGetBeansXml() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storage memoryStorage = context.getBean(MemoryStorage.class);
        memoryStorage.add(new User());
        UserStorage userStorage = context.getBean(UserStorage.class);
        userStorage.add(new User());
        assertNotNull(memoryStorage);
        assertNotNull(userStorage);
    }

    @Test
    public void whenLoadContexShouldGetBeansAnnotation() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Storage jdbcStorage = context.getBean(JdbcStorage.class);
        jdbcStorage.add(new User());
        assertNotNull(jdbcStorage);
    }
}