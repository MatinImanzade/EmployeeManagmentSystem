package com.empmanagment.domain.user;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "privilege_id")
    private Long privilegeId;
    @Column
    private String privilageName;
    @ManyToMany(mappedBy ="privileges")
    private List<Role> roles;

    public Privilege() {
    }

    public Privilege(String privilageName, List<Role> roles) {
        this.privilageName = privilageName;
        this.roles = roles;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getPrivilageName() {
        return privilageName;
    }

    public void setPrivilageName(String privilageName) {
        this.privilageName = privilageName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Privilege privilege = (Privilege) o;
        return privilegeId.equals(privilege.privilegeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privilegeId);
    }
}
