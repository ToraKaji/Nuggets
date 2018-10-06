package edu.cnm.deepdive;

import static java.lang.System.out;
import static java.lang.System.setOut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class nugger {

  Scanner in = new Scanner(System.in);
  int x = 1;
  int y = 1;
  int z = 1;
  int num;
  int start;
  int bbox = 0;
  int mbox = 0;
  int sbox = 0;

  void setup() {
    try {
      System.out.println("Number of nuggets:");
      num = in.nextInt();
      start = num;
      while (num == 0) {
        num = in.nextInt();
        start = num;
      }
      System.out.println("Biggest box:");
      x = in.nextInt();
      while (x == 0) {
        System.out.println("Please make the box size greater than 0:");
        x = in.nextInt();
      }
      System.out.println("Middle box:");
      y = in.nextInt();
      while (y >= x || y == 0) {
        while (y == 0) {
          System.out.println("Please make the box size greater than 0:");
          y = in.nextInt();
        }
        while (y >= x) {
          System.out.println(
              "Please make the middle box:\"" + y + "\" smaller than the biggest box:\"" + x
                  + "\"");
          y = in.nextInt();
        }
      }
      System.out.println("Small box:");
      z = in.nextInt();
      while (z >= y || z == 0) {
        while (z == 0) {
          System.out.println("Please make the box size greater than 0");
          z = in.nextInt();
        }
        while (z >= y) {
          System.out.println(
              "Please make the small box:\"" + z + "\" smaller than the middle box:\"" + y
                  + "\"");
          z = in.nextInt();
        }
      }

    } catch (InputMismatchException e) {
      System.out.println("Please only use numbers!");
    }
  }

  void end() {
    System.out.println(
        "One solution: " + x + "'s:" + bbox + " " + y + "'s:" + mbox + " " + z + "'s:" + sbox);
    System.out.println("For a total of:" + start + " nuggets!");
    System.out.println("");

  }

  boolean isNug() {

    boolean nug = true;
    boolean notNug = false;
    while (num >= z) {
      if ((num % x == 0) || (num % y == 0) || (num % z == 0)) {

        if (num % x == 0) {
          while (num > 0) {
            int q = num /= x;
            bbox += q;
            num = 0;
            break;
          }


        }
        if (num % y == 0) {
          while (num > 0) {
            int q = num /= y;
            mbox += q;
            num = 0;
            break;
          }

        }
        if (num % z == 0) {
          while (num > 0) {
            int q = num /= z;
            sbox += q;
            num = 0;
            break;
          }

        }
        return nug;
      } else if ((num / x >= 1) && (num - x >= z)) {
        num -= x;
        ++bbox;
        return isNug();

      } else if (num / y >= 1 && (num - y >= z)) {
        num -= y;
        ++mbox;
        return isNug();
      } else if (num / z >= 1 && (num - x >= z)) {
        num -= z;
        ++sbox;
        return isNug();
      }
      break;
    }

    return notNug;
  }
}
