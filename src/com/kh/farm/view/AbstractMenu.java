package com.kh.farm.view;

import java.util.Scanner;

public abstract class AbstractMenu {
  public static final String ADD = "추가";
  public static final String REMOVE = "삭제";
  public static final String UPDATE = "수정";
  public static final String BUY = "구매";
  public static final String CANCEL = "구매 취소";
  public static final int EXIT = 9;

  protected int command;
  protected Scanner scanner;
  protected Printer printer;

  public AbstractMenu() {
    this.command = -1;
    this.printer = new Printer();
  }

  public void mainMenu() {
    command = scanner.nextInt();
    scanner.nextLine();
    printer.userInput(command);

    execute();
  }

  public abstract void execute();
}
