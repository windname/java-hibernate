/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vg.autopark.dao;

import com.vg.autopark.Bus;
import com.vg.autopark.Driver;
import com.vg.autopark.Route;
import java.sql.SQLException;
import java.util.Collection;

public interface BusDAO {
  public void addBus(Bus bus) throws SQLException;
  public void updateBus(Long bus_id, Bus bus) throws SQLException;
  public Bus getBusById(Long bus_id) throws SQLException;
  public Collection<Bus> getAllBusses() throws SQLException;
  public void deleteBus(Bus bus) throws SQLException;
  public Collection getBussesByDriver(Driver driver) throws SQLException;
  public Collection getBussesByRoute(Route route) throws SQLException;

}
