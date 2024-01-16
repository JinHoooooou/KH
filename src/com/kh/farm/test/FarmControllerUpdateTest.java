package com.kh.farm.test;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class FarmControllerUpdateTest {


  FarmController controller;

  @BeforeEach
  public void setUp() {
    controller = new FarmController();
  }

  @Test
  @DisplayName("이미 저장된 (과일-사과)인 Farm 객체와 수량이 주어질 때")
  void updateKindSuccessTest1() {
    // Given: (과일-사과)인 Farm 객체가 100개 저장되어 있고
    int kind = 1;
    String name = "사과";
    addFarm(kind, name, 100);
    assert controller.getMap().size() == 1;
    // Given: (과일-사과)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);
    // And: 수량은 50이 주어진다.
    int amount = 50;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 1이다.
    HashMap<Farm, Integer> map = controller.getMap();
    assertThat(map.size()).isEqualTo(1);
    // And: 수량은 50개로 수정된다.
    assertThat(map.get(givenFarm)).isEqualTo(amount);
  }

  @Test
  @DisplayName("이미 저장된 (채소-양배추)인 Farm 객체와 수량이 주어질 때")
  void updateKindSuccessTest2() {
    // Given: (채소-양배추)인 Farm 객체가 1개 저장되어 있고
    int kind = 2;
    String name = "양배추";
    addFarm(kind, name, 1);
    assert controller.getMap().size() == 1;
    // Given: (채소-양배추)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);
    // And: 수량은 80이 주어진다.
    int amount = 80;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 1이다.
    HashMap<Farm, Integer> map = controller.getMap();
    assertThat(map.size()).isEqualTo(1);
    // And: 수량은 80개로 수정된다.
    assertThat(map.get(givenFarm)).isEqualTo(amount);
  }

  @Test
  @DisplayName("이미 저장된 (견과-땅콩)인 Farm 객체와 수량이 주어질 때")
  void updateKindSuccessTest3() {
    // Given: (견과-땅콩)인 Farm 객체가 55개 저장되어 있고
    int kind = 3;
    String name = "땅콩";
    addFarm(kind, name, 55);
    assert controller.getMap().size() == 1;
    // Given: (견과-땅콩)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);
    // And: 수량은 250이 주어진다.
    int amount = 250;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 1이다.
    HashMap<Farm, Integer> map = controller.getMap();
    assertThat(map.size()).isEqualTo(1);
    // And: 수량은 250개로 수정된다.
    assertThat(map.get(givenFarm)).isEqualTo(amount);
  }

  @Test
  @DisplayName("map에 (견과-땅콩)인 Farm 객체가 저장되어 있지 않을 때")
  void updateKindFailTest1() {
    // Given: map은 empty이고
    assert controller.getMap().isEmpty();
    // And: (견과-땅콩)인 Farm 객체가 주어진다.
    int kind = 3;
    String name = "땅콩";
    Farm givenFarm = Farm.create(kind, name);
    // And: 수량은 100이 주어진다.
    int amount = 100;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: controller의 map의 size는 0이다.
    HashMap<Farm, Integer> map = controller.getMap();
    assertThat(map.size()).isEqualTo(0);
  }

  @Test
  @DisplayName("Invalid Farm 객체가 주어질 때")
  void updateKindFailTest2() {
    // Given: (견과-땅콩)인 Farm 객체가 88개 저장되어 있고
    int kind = 3;
    String name = "땅콩";
    addFarm(kind, name, 88);
    assert controller.getMap().size() == 1;
    // And: Invalid Farm 객체가 주어진다.
    Farm invalidFarm = null;
    // And: 수량은 250이 주어진다.
    int amount = 250;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(invalidFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: 저장되어있던 (견과-땅콩)인 Farm객체의 amount는 88이다.
    HashMap<Farm, Integer> map = controller.getMap();
    for (Farm farm : controller.getMap().keySet()) {
      assertThat(map.get(farm)).isEqualTo(88);
    }
  }

  @Test
  @DisplayName("수량이 음수로 주어질 때")
  void updateKindFailTest3() {
    // Given: (견과-땅콩)인 Farm 객체가 88개 저장되어 있고
    int kind = 3;
    String name = "땅콩";
    addFarm(kind, name, 88);
    assert controller.getMap().size() == 1;
    // And: Invalid Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);
    // And: 수량은 -10이 주어진다.
    int amount = -10;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.changeAmount(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: 저장되어있던 (견과-땅콩)인 Farm객체의 amount는 88이다.
    HashMap<Farm, Integer> map = controller.getMap();
    for (Farm farm : controller.getMap().keySet()) {
      assertThat(map.get(farm)).isEqualTo(88);
    }
  }


  private void addFarm(int kind, String name, int amount) {
    controller.addNewKind(Farm.create(kind, name), amount);
  }
}
