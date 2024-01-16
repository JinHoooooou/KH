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
    Farm givenFarm = Farm.create(1, "사과");
    // And: 수량은 50이 주어진다.
    int amount = 50;

    // When: updateKind 메소드를 호출한다.
    boolean actual = controller.updateKind(givenFarm, amount);

    // Then: 결과는 true이다.
    assertThat(actual).isTrue();
    // And: controller의 map의 size는 1이다.
    HashMap<Farm, Integer> map  = controller.getMap();
    assertThat(map.size()).isEqualTo(1);
    // And: 수량은 50개로 수정된다.
    assertThat(map.get(givenFarm)).isEqualTo(amount);
  }


  private void addFarm(int kind, String name, int amount) {
    controller.addNewKind(Farm.create(kind, name), amount);
  }
}
