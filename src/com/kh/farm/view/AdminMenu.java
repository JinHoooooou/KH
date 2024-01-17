package com.kh.farm.view;

import com.kh.farm.controller.FarmController;

import java.util.Scanner;

public class AdminMenu extends AbstractMenu {

  private static final int ADD_NEW_KIND = 1;
  private static final int REMOVE_NEW_KIND = 2;
  private static final int CHANGE_AMOUNT = 3;
  private static final int PRINT_FARM = 4;
  private FarmController farmController;

  public AdminMenu() {

  }

  public AdminMenu(FarmController farmController, Scanner scanner) {
    super();
    this.scanner = scanner;
    this.farmController = farmController;
  }

  @Override
  public void mainMenu() {
    while (command != EXIT) {
      printer.adminMain();
      super.mainMenu();
    }
  }

  @Override
  public void execute() {
    if (command == ADD_NEW_KIND) {
      this.addNewKind();
    } else if (command == REMOVE_NEW_KIND) {
      this.removeKind();
    } else if (command == CHANGE_AMOUNT) {
      this.changeAmount();
    } else if (command == PRINT_FARM) {
      this.printFarm();
    } else if (command == EXIT) {
      return;
    } else {
      printer.menuError();
    }
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


}
