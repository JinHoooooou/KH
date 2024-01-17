package com.kh.farm.view;

import com.kh.farm.controller.FarmController;
import com.kh.farm.model.vo.Farm;

import java.util.ArrayList;
import java.util.Scanner;

public class FarmMenu extends AbstractMenu {
  private static final int ADMIN = 1;
  private static final int CUSTOM = 2;
  private FarmController farmController;
  private AdminMenu admin;
  private CustomMenu custom;

  public FarmMenu() {
    super();
    scanner = new Scanner(System.in);
    farmController = new FarmController();
    admin = new AdminMenu(farmController, scanner);
    custom = new CustomMenu(farmController, scanner);
  }

  @Override
  public void mainMenu() {
    while (command != EXIT) {
      printer.title();
      printer.farmMain();
      super.mainMenu();
    }
  }

  @Override
  public void execute() {
    if (command == ADMIN) {
      admin.mainMenu();
    } else if (command == CUSTOM) {
      custom.mainMenu();
    } else if (command == EXIT) {
      printer.exit();
    } else {
      printer.menuError();
    }
  }
}
