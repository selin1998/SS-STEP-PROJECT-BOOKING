package io;

import java.util.Scanner;

public class UnixConsole implements Console {

  private final Scanner sc;

  public UnixConsole(Scanner sc) {
    this.sc = sc;
  }

  @Override
  public String readLn() {
    return sc.nextLine();
  }


  @Override
  public int readInt() {
    return sc.nextInt();
  }


  @Override
  public void print(String line) {
    System.out.print(line);
  }

  @Override
  public void printf(String line, int a) {
    System.out.printf(line,a);
    System.out.println();
  }


  @Override
  public void close() {
    sc.close();
  }


  @Override
  public boolean hasNextInt() {
    return sc.hasNextInt();
  }


  @Override
  public String readLnNext(){
    return sc.next();
  }
}
