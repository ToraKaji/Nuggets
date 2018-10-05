package edu.cnm.deepdive;

import javax.sound.midi.SysexMessage;

public class Sandbox {

  public static void main(String[] args) {
    if (isNug(10)) {
      System.out.println("is nug");
    } else System.out.println("not nug");
  }


    public static boolean isNug (int num){
      int x = 20;
      int y = 9;
      int z = 6;
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
