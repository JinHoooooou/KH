package com.kh.farm.controller;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.farm.model.vo.Farm;

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
    if (amount < 0) {
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

  public boolean changeAmount(int kind, String name, int amount) {
    return changeAmount(Farm.create(kind, name), amount);
  }

  public boolean changeAmount(Farm farm, int amount) {
    if (farm == null) {
      return false;
    }
    if (!map.containsKey(farm)) {
      return false;
    }
    if (amount < 0) {
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

  public boolean buyFarm(int kind, String name) {
    return this.buyFarm(Farm.create(kind, name));
  }

  private boolean buyFarm(Farm farm) {
    if (farm == null) {
      return false;
    }
    if (!map.containsKey(farm)) {
      return false;
    }
    if (map.get(farm) == 0) {
      return false;
    }
    list.add(farm);
    map.replace(farm, map.get(farm) - 1);
    return true;
  }

  public boolean removeFarm(int kind, String name) {
    return removeFarm(Farm.create(kind, name));
  }

  private boolean removeFarm(Farm farm) {
    if (farm == null) {
      return false;
    }
    if (!list.contains(farm)) {
      return false;
    }
    list.remove(farm);
    map.replace(farm, map.get(farm) + 1);
    return true;
  }

  public ArrayList<Farm> printBuyFarm() {
    return list;
  }
}
