package com.kh.farm.view;

import com.kh.farm.controller.FarmController;

import javax.naming.directory.InvalidAttributesException;
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
    while (mainMenu != 9) {
      mainMenu = scanner.nextInt();
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
    while (adminMenu != -9) {
      printer.adminMenu();
      adminMenu = scanner.nextInt();
      executeAdmin();
    }

  }

  private void executeAdmin() {
    if (adminMenu == 1) {
      this.addNewKind();
    } else if (adminMenu == 2) {
      this.removeKind();
    }

  }

  public void customMenu() {
    printer.customMenu(farmController.printFarm());
  }

  public void addNewKind() {
    printer.kind();
    int kind = printer.inputKind(scanner, ADD);
    String name = printer.inputName(scanner);
    int amount = printer.inputAmount(scanner);
    printer.addKindResult(farmController.addNewKind(kind, name, amount));
  }

  public void removeKind() {
    printer.kind();
    int kind = printer.inputKind(scanner, REMOVE);
    String name = printer.inputName(scanner);
    printer.removeKindResult(farmController.removeKind(kind, name));
  }

  public void changeAmount() {
    printer.kind();
    int kind = printer.inputKind(scanner, UPDATE);
    String name = printer.inputName(scanner);
    int amount = printer.inputAmount(scanner);
    printer.updateKindResult(farmController.updateKind(kind,name,amount));
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
