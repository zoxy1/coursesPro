package collections.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class UserTest {
    @Test
    public void overrideHashCode() {
        Calendar calendar = new GregorianCalendar();
        User userOne = new User("Anton", 16, calendar);
        User userTwo = new User("Anton", 16, calendar);
        System.out.println(userOne.hashCode());
        System.out.println(userTwo.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(userOne, 1);
        map.put(userTwo, 2);
        System.out.println(map);
    }

}