package com.kh.farm.test;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FarmControllerRemoveTest {
  FarmController controller;

  @BeforeEach
  public void setUp() {
    controller = new FarmController();
  }

  @Test
  @DisplayName("이미 저장된 (과일-사과)Farm 객체를 삭제할 때")
  public void removeKindSuccessTest1() {
    // Given: (과일-사과)인 Farm 객체가 저장되어 있다.
    int kind = 1;
    String name = "사과";
    addFarm(kind, name);
    assert controller.getMap().size() == 1;
    // And: (과일-사과)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);

    // When: removeKind 메소드를 호출한다.
    boolean actual = controller.removeKind(givenFarm);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 0이다.
    assertThat(controller.getMap().isEmpty()).isTrue();
  }

  @Test
  @DisplayName("이미 저장된 (채소-무)Farm 객체를 삭제할 때")
  public void removeKindSuccessTest2() {
    // Given: (채소-무)인 Farm 객체가 저장되어 있다.
    int kind = 2;
    String name = "무";
    addFarm(kind, name);
    assert controller.getMap().size() == 1;
    // And: (채소-무)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);

    // When: removeKind 메소드를 호출한다.
    boolean actual = controller.removeKind(givenFarm);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 0이다.
    assertThat(controller.getMap().isEmpty()).isTrue();
  }

  @Test
  @DisplayName("이미 저장된 (견과-호두)Farm 객체를 삭제할 때")
  public void removeKindSuccessTest3() {
    // Given: (견과-땅콩)인 Farm 객체가 저장되어 있다.
    int kind = 3;
    String name = "땅콩";
    addFarm(kind, name);
    assert controller.getMap().size() == 1;
    // And: (견과-땅콩)인 Farm 객체가 주어진다.
    Farm givenFarm = Farm.create(kind, name);

    // When: removeKind 메소드를 호출한다.
    boolean actual = controller.removeKind(givenFarm);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 0이다.
    assertThat(controller.getMap().isEmpty()).isTrue();
  }

  @Test
  @DisplayName("invalid Farm 객체를 삭제할 때")
  public void removeKindFailTest1() {
    // Given: (견과-땅콩)인 Farm 객체가 저장되어 있다.
    int kind = 3;
    String name = "땅콩";
    addFarm(kind, name);
    assert controller.getMap().size() == 1;
    // And: invalid한 Farm 객체가 주어진다.
    Farm invalidFarm = null;

    // When: removeKind 메소드를 호출한다.
    boolean actual = controller.removeKind(invalidFarm);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
    // And: controller의 map의 size는 1이다.
    assertThat(controller.getMap().size()).isEqualTo(1);
  }

  @Test
  @DisplayName("map에 해당 객체가 저장되어있지 않을 때")
  public void removeKindFailTest2() {
    // Given: map은 empty이고
    assert controller.getMap().isEmpty();
    // And: (과일-배)인 Farm 객체가 주어진다.
    int kind = 1;
    String name = "배";
    Farm givenFarm = Farm.create(kind, name);

    // When: removeKind 메소드를 호출한다.
    boolean actual = controller.removeKind(givenFarm);

    // Then: 결과는 false이다.
    assertThat(actual).isFalse();
  }


  private void addFarm(int kind, String name) {
    controller.addNewKind(kind, name, 100);
  }
}
