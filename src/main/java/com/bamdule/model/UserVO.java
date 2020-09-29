package com.bamdule.model;

/**
 *
 * @author kim
 */
public class UserVO {

    private String email;
    private String password;
    private String role;
    private String name;
    private boolean isEnable;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public boolean getIsEnable() {
        return isEnable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVO{" + "email=" + email + ", password=" + password + ", role=" + role + ", name=" + name + ", isEnable=" + isEnable + '}';
    }

}
