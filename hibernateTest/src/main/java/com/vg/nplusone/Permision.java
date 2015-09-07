/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.nplusone;

/**
 *
 * @author 1
 */
public class Permision {
    private Integer permisionId;
    private User user;
    private String role;
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getPermisionId() {
        return permisionId;
    }

    public void setPermisionId(Integer permisionId) {
        this.permisionId = permisionId;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
