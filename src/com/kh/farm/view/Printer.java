package com.kh.farm.view;

import com.kh.farm.model.vo.Farm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Printer {
  HashMap<Integer, String> commands;

  public Printer() {
    commands = new HashMap<>();
    commands.put(1, "추가");
  }


  public void mainMenu() {
    System.out.println("========== KH 마트 ==========");
    System.out.println("******* 메인 메뉴 *******");
    System.out.println("1. 직원 메뉴");
    System.out.println("2. 손님 메뉴");
    System.out.println("9. 종료");
    System.out.print("메뉴 번호 선택: ");

  }

  public void adminMenu() {
    System.out.println("******* 직원 메뉴 *******");
    System.out.println("1. 새 농산물 추가");
    System.out.println("2. 종류 삭제");
    System.out.println("3. 수량 수정");
    System.out.println("4. 농산물 목록");
    System.out.println("9. 메인으로 돌아가기");
    System.out.print("메뉴 번호 선택: ");
  }

  public void customMenu(HashMap<Farm,Integer> map) {
    System.out.println("현재 KH마트 농산물 수량");
    printFarm(map);
    System.out.println("******* 고객 메뉴 *******");
    System.out.println("1. 농산물 사기");
    System.out.println("2. 농산물 빼기");
    System.out.println("3. 구입한 농산물 보기");
    System.out.println("9. 메인으로 돌아가기");
    System.out.print("메뉴 번호 선택: ");
  }

  public void printFarm(HashMap<Farm, Integer> map) {
    for (Map.Entry<Farm, Integer> entry : map.entrySet()) {
      Farm target = entry.getKey();
      System.out.printf("%s: %s(%d개)\n", target.getKind(), target.getName(), entry.getValue());
    }
  }

  public void exit() {
    System.out.println("프로그램 종료.");
  }

  public void menuError() {
    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
  }


  public void kind() {
    System.out.println("1. 과일 / 2. 채소 / 3. 견과");
  }

  public int inputKind(Scanner scanner, String command) {
    int result;
    while (true) {
      System.out.print(command + "할 종류 번호: ");
      result = scanner.nextInt();
      scanner.nextLine();
      if (result == 1 || result == 2 || result == 3) {
        break;
      }
      this.menuError();
    }
    return result;
  }


  public String inputName(Scanner scanner) {
    System.out.print("이름: ");
    return scanner.next();
  }

  public int inputAmount(Scanner scanner) {
    System.out.println("수량: ");
    int result = scanner.nextInt();
    scanner.nextLine();
    return result;
  }

  public void addKindResult(boolean result) {
    System.out.println(result ? "새 농산물이 추가되었습니다." : "새 농산물 추가에 실패하였습니다. 다시 입력해주세요.");

  }

  public void removeKindResult(boolean result) {
    System.out.println(result ? "농산물 삭제에 성공하였습니다." : "농산물 삭제에 실패하였습니다. 다시 입렵해주세요.");
  }

  public void updateKindResult(boolean result) {
    System.out.println(result ? "농산물 수량이 수정되었습니다." : "농산물 수량 수정에 실패하였습니다.");
  }
}
