package com.kh.farm.test;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class FarmControllerAddTest {


  FarmController controller;

  @BeforeEach
  public void setUp() {
    controller = new FarmController();
  }

  @Test
  @DisplayName("과일-사과인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest1() {
    // Given: Farm 객체로 kind:1, name:사과가 주어지고
    Farm givenFarm = Farm.create(1, "사과");
    // And: 수량은 30이 주어진다.
    int amount = 30;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map에 저장된 Farm 객체는 givenFarm과 같다.
    for (Farm farm : controller.getMap().keySet()) {
      assertThat(farm).isEqualTo(givenFarm);
    }
  }

  @Test
  @DisplayName("채소-양배추인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest2() {
    // Given: Farm 객체로 kind:2, name:양배추가 주어지고
    Farm givenFarm = Farm.create(2, "양배추");
    // And: 수량은 10이 주어진다.
    int amount = 10;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map에 저장된 Farm 객체는 givenFarm과 같다.
    for (Farm farm : controller.getMap().keySet()) {
      assertThat(farm).isEqualTo(givenFarm);
    }
  }

  @Test
  @DisplayName("견과-땅콩인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest3() {
    // Given: Farm 객체로 kind:3, name:땅콩이 주어지고
    Farm givenFarm = Farm.create(3, "땅콩");
    // And: 수량은 52이 주어진다.
    int amount = 52;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map에 저장된 Farm 객체는 givenFarm과 같다.
    for (Farm farm : controller.getMap().keySet()) {
      assertThat(farm).isEqualTo(givenFarm);
    }
  }

  @Test
  @DisplayName("kind가 같고 name이 다른 객체를 추가할 때")
  void addNewKindSuccessTest4() {
    // Given: (과일-사과)인 Farm 객체가 저장되어 있고
    addFarm(1, "사과");
    assert controller.getMap().size() == 1;
    // And: (과일-배)인 Farm 객체가 주어지고
    Farm givenFarm = Farm.create(1, "배");
    // And: 수량은 52이 주어진다.
    int amount = 52;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: map의 size는 2이다.
    assertThat(controller.getMap().size()).isEqualTo(2);
  }

  @Test
  @DisplayName("kind가 다르고 name이 같은 객체를 추가할 때")
  void addNewKindSuccessTest5() {
    // Given: (과일-사과)인 Farm 객체가 저장되어 있고
    addFarm(1, "사과");
    assert controller.getMap().size() == 1;
    // And: (채소-과일)인 Farm 객체가 주어지고
    Farm givenFarm = Farm.create(2, "사과");
    // And: 수량은 100이 주어진다.
    int amount = 100;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: map의 size는 2이다.
    assertThat(controller.getMap().size()).isEqualTo(2);
  }

  @Test
  @DisplayName("kind가 invalid한 Farm 객체와 수량이 주어질 때")
  void addNewKindFailTest1() {
    // Given: Farm 객체로 kind:4, name:배가 주어지고
    assert controller.getMap().isEmpty();
    Farm givenFarm = Farm.create(4, "배");
    // And: 수량은 100이 주어진다.
    int amount = 100;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: map의 size는 1이다.
    assertThat(controller.getMap().isEmpty()).isTrue();
  }

  @Test
  @DisplayName("이미 같은 객체가 저장되어 있을 때")
  void addNewKindFailTest2() {
    // Given: 이미 (과일-사과)인 Farm 객체가 저장되어 있고
    int kind = 1;
    String name = "사과";
    addFarm(kind, name);
    assert controller.getMap().size() == 1;
    // And: (과일-사과)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);
    int amount = 100;
    controller.addNewKind(givenFarm, amount);

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: map의 size는 1이다.
    assertThat(controller.getMap().size()).isEqualTo(1);
  }

  private void addFarm(int kind, String name) {
    controller.addNewKind(Farm.create(kind, name), 100);
  }
}
