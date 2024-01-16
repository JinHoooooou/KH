package com.kh.farm.test;

import com.kh.farm.view.FarmMenu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MenuTest {

  private ByteArrayInputStream in;

  @BeforeEach
  public void setUp() {
  }

  @AfterEach
  public void tearDown() {
    System.setIn(System.in);
  }

  @Test
  public void test() {
    String input = "1\n" + // 메인메뉴 -> 어드민 메뉴

            // add kind 성공
            "1\n" + // 농산물 추가
            "1\n" + // kind
            "사과\n" + // 이름
            "20\n" + // 수량

            "1\n" + // 농산물 추가
            "2\n" + // kind
            "양배추\n" + // 이름
            "10\n" + // 수량

            "1\n" + // 농산물 추가
            "1\n" + // kind
            "레몬\n" + //이름
            "10\n" + //수량

            "1\n" + //농산물 추가
            "2\n" + // kind
            "사과\n" + // 이름
            "30\n" + // 수량

            "1\n" + // 농산물 추가
            "1\n" + // kind
            "땅콩\n" + // 이름
            "500\n" + // 수량

            "1\n" + // 농산물 추가
            "3\n" + // kind
            "양배추\n" + // 이름
            "30\n" + // 수량

            // add kind 실패
            "1\n" + // 농산물 추가
            "4\n" + // kind -> 다시입력
            "1\n" +  // kind
            "사과\n" + // 이름
            "20\n" + // 수량 -> 이미 있어서 실패
            "3\n" + // kind
            "콩\n" + // 이름
            "-10\n" + // 수량 -> 음수라서 실패
            "3\n" + // kind
            "콩\n" + // 이름
            "10\n" + // 수량 -> 성공

            // print
            "4\n" +

            // remove kind 성공
            "2\n" + // 종류 삭제
            "2\n" + // kind
            "사과\n" +// 이름

            "2\n" + // 종류삭제
            "1\n" + // kind
            "땅콩\n" + // 이름

            "2\n" + // 종류 삭제
            "3\n" + // kind
            "양배추\n" + // 이름

            // remove kind 실패
            "2\n" + // 종류 삭제
            "8\n" + // kind -> 실패, 다시
            "2\n" + // kind
            "고수\n" + // 이름 -> 없어서 실패, 다시
            "1\n" + // kind
            "사과\n" + // 이름 -> 성공

            // print
            "4\n" +

            // update kind 성공
            "3\n" + // 수량 수정
            "1\n" + // kind
            "레몬\n" + // 이름
            "100\n" + // 수량

            "3\n" + // 수량 수정
            "3\n" + // kind
            "콩\n" + // 이름
            "30\n" + // 수량

            // update kind 실패
            "3\n" + // 수량 수정
            "5\n" + // kind -> 실패, 다시
            "2\n" + // kind
            "양배차\n" + // 이름
            "50\n" + // 수량 -> 이름이 없어서 실패, 다시
            "2\n" + // kind
            "양배추\n" + // 이름
            "-150\n" + // 수량 -> 수량이 음수라서 실패, 다시
            "2\n" + // kind
            "양배추\n" + // 이름
            "50\n" + // 수량 -> 성공

            //print
            "4\n" +

            "9\n" + // 메인으로
            "9\n"; // 종료
    in = new ByteArrayInputStream(input.getBytes());
    System.setIn(in);

    FarmMenu menu = new FarmMenu();
    menu.mainMenu();
  }
}
