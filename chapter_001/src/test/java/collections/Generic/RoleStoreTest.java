package collections.Generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class RoleStoreTest {
    @Test
    public void thenAddUserShouldFindUserInStoreForId() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        assertThat(roleStore.findById("1"), is(new Role("1", "Admin")));
    }

    @Test
    public void thenReplacementUserShouldChangeUserInStore() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "User"));
        roleStore.replace("1", new Role("1", "Admin"));
        assertThat(roleStore.findById("1"), is(new Role("1", "Admin")));
    }

    @Test
    public void thenDeleteUserShouldNotUserInStore() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "Admin"));
        roleStore.add(new Role("2", "User"));
        roleStore.delete("2");
        assertThat(roleStore.findById("2"), is(nullValue()));
    }
}