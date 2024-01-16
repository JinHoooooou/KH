package com.kh.farm.model.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Farm {

  private static Map<Integer, String> kinds;
  private String kind;

  static {
    kinds = new HashMap<>();
    kinds.put(1, "과일");
    kinds.put(2, "채소");
    kinds.put(3, "견과");
  }

  public Farm() {

  }

  public Farm(String kind) {
    this.kind = kind;
  }

  public static Farm create(int kind, String name) {
    if (kind == 1) {
      return new Fruit(kinds.get(kind), name);
    } else if (kind == 2) {
      return new Vegetable(kinds.get(kind), name);
    } else if (kind == 3) {
      return new Nut(kinds.get(kind), name);
    }
    return null;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }

  public String getName() {
    return "";
  }

  public void setName() {

  }

  @Override
  public String toString() {
    return "Farm [kind=" + kind + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Farm other = (Farm) obj;
    return Objects.equals(kind, other.kind);
  }
}
