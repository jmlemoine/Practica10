package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public class AppRole implements Serializable {

    @Id
    @GeneratedValue

    private int roleId;

    private String roleName;

    public AppRole() {

    }

    public AppRole(String rolename) {
        this.roleName = rolename;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
