/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.autopark;

import java.util.Set;
import java.util.HashSet;

public class Route {
  private Long id;
  private String name;
  private int number;
  private Set busses = new HashSet();

  public Route(){
  }
  public void setId(Long id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setNumber(int number) {
    this.number = number;
  }
  public void setBusses(Set busses) {
    this.busses = busses;
  }
  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public int getNumber() {
    return number;
  }
  public Set getBusses() {
    return busses;
  }
}