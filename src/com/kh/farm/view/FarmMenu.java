package com.kh.farm.view;

import com.kh.farm.controller.FarmController;

import java.util.Scanner;

public class FarmMenu {
  public static final String ADD = "추가";
  public static final String REMOVE = "삭제";
  public static final String UPDATE = "수정";

  private int mainMenu;
  private int adminMenu;
  private int customMenu;
  private Scanner scanner;
  private Printer printer;
  private FarmController farmController;

  public FarmMenu() {
    mainMenu = -1;
    adminMenu = -1;
    customMenu = -1;
    scanner = new Scanner(System.in);
    printer = new Printer();
    farmController = new FarmController();
  }

  public void mainMenu() {
    printer.title();
    while (mainMenu != 9) {
      printer.mainMenu();
      mainMenu = scanner.nextInt();
      scanner.nextLine();
      printer.userInput(mainMenu);
      executeMain();
    }
  }

  public void executeMain() {
    if (mainMenu == 1) {
      adminMenu();
    } else if (mainMenu == 2) {
      customMenu();
    } else if (mainMenu == 9) {
      printer.exit();
    } else {
      printer.menuError();
    }
  }

  public void adminMenu() {
    while (adminMenu != 9) {
      printer.adminMenu();
      adminMenu = scanner.nextInt();
      scanner.nextLine();
      printer.userInput(adminMenu);
      executeAdmin();
    }

  }

  private void executeAdmin() {
    if (adminMenu == 1) {
      this.addNewKind();
    } else if (adminMenu == 2) {
      this.removeKind();
    } else if (adminMenu == 3) {
      this.changeAmount();
    } else if (adminMenu == 4) {
      this.printFarm();
    } else if (adminMenu == 9) {
      return;
    }

  }

  public void customMenu() {
    printer.customMenu(farmController.printFarm());
  }

  public void addNewKind() {
    boolean result = false;
    while (!result) {
      printer.kind();
      int kind = printer.inputKind(scanner, ADD);
      String name = printer.inputName(scanner);
      int amount = printer.inputAmount(scanner);
      result = farmController.addNewKind(kind, name, amount);
      printer.addKindResult(result);
    }
  }

  public void removeKind() {
    boolean result = false;
    while (!result) {
      printer.kind();
      int kind = printer.inputKind(scanner, REMOVE);
      String name = printer.inputName(scanner);
      result = farmController.removeKind(kind, name);
      printer.removeKindResult(result);
    }
  }

  public void changeAmount() {
    boolean result = false;
    while (!result) {
      printer.kind();
      int kind = printer.inputKind(scanner, UPDATE);
      String name = printer.inputName(scanner);
      int amount = printer.inputAmount(scanner);
      result = farmController.changeAmount(kind, name, amount);
      printer.changeAmountResult(result);
    }
  }

  public void printFarm() {
    printer.printFarm(farmController.printFarm());
  }

  public void buyFarm() {

  }

  public void removeFarm() {

  }

  public void printBuyFarm() {

  }
}
