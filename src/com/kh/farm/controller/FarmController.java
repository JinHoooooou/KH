package com.kh.farm.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.directory.InvalidAttributesException;

import com.kh.farm.model.vo.Farm;
import com.kh.farm.model.vo.Fruit;
import com.kh.farm.model.vo.Nut;
import com.kh.farm.model.vo.Vegetable;

public class FarmController {

  private HashMap<Farm, Integer> map;
  private ArrayList<Farm> list;

  public FarmController() {
    this.map = new HashMap<>();
    this.list = new ArrayList<>();
  }

  public boolean addNewKind(int kind, String name, int amount) {
    return addNewKind(Farm.create(kind, name), amount);
  }

  public boolean addNewKind(Farm farm, int amount) {
    if (farm == null) {
      return false;
    }
    if (map.containsKey(farm)) {
      return false;
    }
    map.put(farm, amount);
    return true;
  }

  public boolean removeKind(int kind, String name) {
    return removeKind(Farm.create(kind, name));
  }

  public boolean removeKind(Farm farm) {
    if (farm == null) {
      return false;
    }
    if (!map.containsKey(farm)) {
      return false;
    }
    map.remove(farm);
    return true;
  }

  public boolean updateKind(int kind, String name, int amount) {
    return updateKind(Farm.create(kind, name), amount);
  }

  public boolean updateKind(Farm farm, int amount) {
    if (farm == null) {
      return false;
    }
    if (!map.containsKey(farm)) {
      return false;
    }
    if (map.get(farm) == amount) {
      return false;
    }
    map.replace(farm, amount);
    return true;
  }

  public HashMap<Farm, Integer> printFarm() {
    return map;
  }

  public HashMap<Farm, Integer> getMap() {
    return map;
  }

}
