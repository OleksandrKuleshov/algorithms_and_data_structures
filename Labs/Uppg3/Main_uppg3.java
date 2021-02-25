package Labs.Uppg3;

import java.util.Iterator;

public class Main_uppg3 {
  public static void main(String[] args) {
    SingleLinkedList<String> list = new SingleLinkedList<>();
    for (int i = 0; i < 10; i++) {
      list.add("e" + i);
    }
    System.out.println(list);
    Iterator<String> iter = list.iterator();
    // while (iter.hasNext()) {
    // iter.next();
    // iter.remove();
    // System.out.println(list);
    // }

    iter.next();
    iter.next();
    iter.remove();
    iter.next();
    iter.remove();

    System.out.println(list);
  }
}