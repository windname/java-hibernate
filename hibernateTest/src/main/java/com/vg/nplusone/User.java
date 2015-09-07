/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.nplusone;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 1
 */
public class User {
    private Integer userId;
    private String name;
    private int age;
    private Set<Permision> permisions = new HashSet();;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Permision> getPermisions() {
        return permisions;
    }

    public void setPermisions(Set<Permision> permisions) {
        this.permisions = permisions;
    }
    
    
    
}
