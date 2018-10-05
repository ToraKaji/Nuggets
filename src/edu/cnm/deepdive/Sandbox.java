package edu.cnm.deepdive;

public class Sandbox {

  public static void main(String[] args) {
    int num = 21;
    int x = 20;
    int y = 9;
    int z = 6;
    boolean nug;

    while(num >= z){
      if(num%x==0){
        nug = true;
      }
      if(num/x>1){
        num -= x;
      }
    }
  }
}
