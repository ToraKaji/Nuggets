package edu.cnm.deepdive;

import java.util.Scanner;

public class Sandbox {

  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    while (true) {
      System.out.println("Input # of nuggets:");
      if (isNug(in.nextInt())) {
        System.out.println("is nug");
      } else
        System.out.println("not nug");
    }
  }
    public static boolean isNug ( int num){
      System.out.println("Input biggest box size:");
      int x = in.nextInt();
      System.out.println("Input middle box size:");
      int y = in.nextInt();
      System.out.println("Input smallest box size:");
      int z = in.nextInt();
      boolean nug = true;
      boolean notNug = false;
      while (num >= z) {
        if ((num % x == 0) || (num % y == 0) || (num % z == 0)) {
          return nug;
        } else if (num / x > 1) {
          num -= x;
          return isNug(num);
        } else if (num / y > 1) {
          num -= y;
          return isNug(num);
        } else if (num / z > 1) {
          num -= z;
          return isNug(num);
        }
        break;
      }
      return notNug;
    }

}