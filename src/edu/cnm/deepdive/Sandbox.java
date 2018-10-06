package edu.cnm.deepdive;

import java.util.Scanner;

public class Sandbox {

  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      nugger nug = new nugger();
      nug.setup();
      if (nug.isNug()) {
        System.out.println("Does have solution:");
        nug.end();
      } else {
        System.out.println("Does not have solution.");
      }

    }
  }
}