package com.empmanagment.domain.user;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Column
    private String firstName;
    private String lastName;
    @Column(unique = true,nullable = false)
    private String userName;
    private String email;
    @Column(length = 60)
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean creditionalsNonExpired;
    private boolean accountNonLocked;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;
    public User(){
        this.enabled = false;

        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.creditionalsNonExpired = true;
    }

    public User(String firstName, String lastName, String userName, String email, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isCreditionalsNonExpired() {
        return creditionalsNonExpired;
    }

    public void setCreditionalsNonExpired(boolean creditionalsNonExpired) {
        this.creditionalsNonExpired = creditionalsNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId.equals(user.userId) && userName.equals(user.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
