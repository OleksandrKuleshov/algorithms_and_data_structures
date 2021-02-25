package Labs.Uppg2;

public class Main_uppg2 {
  public static void main(String[] args) {
    SingleLinkedList<String> list = new SingleLinkedList<>();
    for (int i = 0; i < 4; i++) {
      list.add("e" + i);
    }
    list.remove(3);
    list.add(0, "först");
    list.add("sist");
    System.out.println(list);
  }
}
