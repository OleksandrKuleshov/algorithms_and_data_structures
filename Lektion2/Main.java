package Lektion2;

import java.util.Iterator;

public class Main {
  public static void main(String[] args) {

    SingleLinkedList<String> list = new SingleLinkedList<String>();
    for (int i = 1; i <= 10; i++)// O(n2
      list.add("String: " + i);

    Iterator<String> iter = list.iterator();

    while (iter.hasNext())// O(n)
      System.out.println(iter.next());
  }
}
