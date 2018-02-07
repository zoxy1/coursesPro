package Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class UserStoreTest {
    @Test
    public void thenAddUserShouldFindUserInStoreForId() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1", "Egor"));
        assertThat(userStore.findById("1"), is(new User("1", "Egor")));
    }

    @Test
    public void thenReplacementUserShouldChangeUserInStore() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1", "Egor"));
        userStore.replace("1", new User("1", "Andrey"));
        assertThat(userStore.findById("1"), is(new User("1", "Andrey")));
    }

    @Test
    public void thenDeleteUserShouldNotUserInStore() {
        UserStore userStore = new UserStore();
        userStore.add(new User("1", "Egor"));
        userStore.add(new User("2", "Maxim"));
        userStore.delete("2");
        assertThat(userStore.findById("2"), is(nullValue()));
    }
}