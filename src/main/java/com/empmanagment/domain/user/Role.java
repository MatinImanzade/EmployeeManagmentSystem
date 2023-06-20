package com.empmanagment.domain.user;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;
    @Column
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Roles_Privileges",joinColumns = @JoinColumn(name = "roles_id",referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "privileges_id",referencedColumnName = "privilege_id"))
    private List<Privilege> privileges;
    @OneToMany(mappedBy = "role")
    private List<User> users;

    public Role() {
    }

    public Role(String roleName, List<Privilege> privileges, List<User> users) {
        this.roleName = roleName;
        this.privileges = privileges;
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(List<Privilege> privileges) {
        this.privileges = privileges;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }
}
