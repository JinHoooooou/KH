package com.kh.farm.view;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomMenu extends AbstractMenu {

  private FarmController farmController;

  public CustomMenu() {

  }

  public CustomMenu(FarmController farmController, Scanner scanner) {
    super();
    this.scanner = scanner;
    this.farmController = farmController;
  }

  @Override
  public void mainMenu() {
    while (command != EXIT) {
      printer.customMain(farmController.printFarm());
      super.mainMenu();
    }
  }

  @Override
  public void execute() {
    if (command == 1) {
      buyFarm();
    } else if (command == 2) {
      removeFarm();
    } else if (command == 3) {
      printBuyFarm();
    } else if (command == 9) {
      return;
    } else {
      printer.menuError();
    }
  }

  public void buyFarm() {
    boolean result = false;
    while (!result) {
      printer.kind();
      int kind = printer.inputKind(scanner, BUY);
      String name = printer.inputName(scanner);
      result = farmController.buyFarm(kind, name);
      printer.buyFarmResult(result);
    }
  }

  public void removeFarm() {
    boolean result = false;
    while (!result) {
      printer.kind();
      int kind = printer.inputKind(scanner, CANCEL);
      String name = printer.inputName(scanner);
      result = farmController.removeFarm(kind, name);
      printer.removeFarmResult(result);
    }
  }

  public void printBuyFarm() {
    ArrayList<Farm> list = farmController.printBuyFarm();
    printer.printBuyFarm(list);
  }
}
