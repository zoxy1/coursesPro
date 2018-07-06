package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserStorageAnnotationTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void whenLoadContextShouldGetBeansXml() {
        Storage memoryStorage = context.getBean("memory", MemoryStorage.class);
        memoryStorage.add(new User());
        UserStorage userStorage = context.getBean("userStorage", UserStorage.class);
        userStorage.add(new User());
        assertNotNull(memoryStorage);
        assertNotNull(userStorage);
    }

    @Test
    public void whenLoadContextShouldGetBeansAnnotation() {
        Storage jdbcStorage = context.getBean("jdbcStorage", JdbcStorage.class);
        jdbcStorage.add(new User());
        assertNotNull(jdbcStorage);
    }
}
