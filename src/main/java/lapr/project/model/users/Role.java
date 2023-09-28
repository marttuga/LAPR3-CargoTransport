package lapr.project.model.users;

import java.util.Objects;

/**
 * The type Role.
 */
public class Role {
    private String role;

    /**
     * Instantiates a new Role.
     */
    public Role(){

    }

    /**
     * Instantiates a new Role.
     *
     * @param role the role
     */
    public Role(String role) {
        this.role = role;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role1 = (Role) o;
        return getRole().equals(role1.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRole());
    }

    @Override
    public String toString() {
        return "Role{" +
                "role='" + role + '\'' +
                '}';
    }
}
