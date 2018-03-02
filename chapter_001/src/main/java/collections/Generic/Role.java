package collections.Generic;

public class Role extends Base {
    private String typeRole;

    protected Role(String id, String typeRole) {
        super(id);
        this.typeRole = typeRole;
    }

    public String getTypeRole() {
        return typeRole;
    }

    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (super.getId() != null ? !super.getId().equals(role.getId()) : role.getId() != null) return false;
        return typeRole != null ? typeRole.equals(role.typeRole) : role.typeRole == null;
    }

    @Override
    public int hashCode() {
        int result = super.getId() != null ? super.getId().hashCode() : 0;
        result = 31 * result + (typeRole != null ? typeRole.hashCode() : 0);
        return result;
    }
}
