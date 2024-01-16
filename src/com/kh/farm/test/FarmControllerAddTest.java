package com.kh.farm.test;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FarmControllerAddTest {


  FarmController controller;

  @BeforeEach
  public void setUp() {
    controller = new FarmController();
  }

  @Test
  @DisplayName("(과일-사과)인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest1() {
    // Given: (과일-사과)인 Farm 객체가 주어지고
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
  @DisplayName("(채소-양배추)인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest2() {
    // Given: (채소-양배추)인 Farm 객체가 주어지고
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
  @DisplayName("(견과-땅콩)인 Farm 객체와 수량이 주어질 때")
  void addNewKindSuccessTest3() {
    // Given: (견과-땅콩)인 Farm 객체가 주어지고
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
    // And: (채소-사과)인 Farm 객체가 주어지고
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
    // Given: (Invalid-배)인 Farm 객체가 주어지고
    assert controller.getMap().isEmpty();
    Farm givenFarm = Farm.create(4, "배");
    // And: 수량은 100이 주어진다.
    int amount = 100;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: map은 empty이다.
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

  @Test
  @DisplayName("수량이 음수로 주어질 때")
  void updateKindFailTest3() {
    // Given: (견과-땅콩)인 Farm 객체가 주어지고
    Farm givenFarm = Farm.create(3, "땅콩");
    // And: 수량은 -10이 주어진다.
    int amount = -10;

    // When: addNewKind 메소드를 호출한다.
    boolean actual = controller.addNewKind(givenFarm, amount);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: map은 empty이다.
    assertThat(controller.getMap().isEmpty()).isTrue();
  }

  private void addFarm(int kind, String name) {
    controller.addNewKind(Farm.create(kind, name), 100);
  }
}
