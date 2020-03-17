package io;

public interface Console {
  String readLn();
  int readInt();


  void print(String line);
  void printf(String line,int a);
  default void printLn(String line) {
    print(line);
    printLn();
  }

  default void printLn() {
    print("\n");
  }
  void close();
  boolean hasNextInt();
  String readLnNext();

}
