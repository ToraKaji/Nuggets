package edu.cnm.deepdive;

import static java.lang.System.out;
import static java.lang.System.setOut;

import java.util.Scanner;

public class nugger {

  Scanner in = new Scanner(System.in);
  int x;
  int y;
  int z;
  int num;
  int start;
  int bbox = 0;
  int mbox = 0;
  int sbox = 0;

  void setup() {
    System.out.println("Number of nuggets:");
    num = in.nextInt();
    start = num;
    System.out.println("Biggest box:");
    x = in.nextInt();
    System.out.println("Middle box:");
    y = in.nextInt();
    while (y >= x) {
      System.out.println(
          "Please make the middle box:\"" + y + "\" smaller than the biggest box:\"" + x + "\"");
      y = in.nextInt();
    }
    System.out.println("Small box:");
    z = in.nextInt();
    while (z >= y) {
      System.out.println(
          "Please make the smallest box:\"" + z + "\" smaller than the middle box:\"" + y + "\"");
      z = in.nextInt();
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
            break;
          }

        }
        if (num % y == 0) {
          while (num > 0) {
            int q = num /= y;
            mbox += q;
            break;
          }

        }
        if (num % z == 0) {
          while (num > 0) {
            int q = num /= z;
            sbox += q;
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
