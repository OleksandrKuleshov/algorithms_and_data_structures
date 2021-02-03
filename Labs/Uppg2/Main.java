
public class Main {
  public static void main(String[] args) {
    SingleLinkedList<Integer> list = new SingleLinkedList<>();
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);
    System.out.println(list);
    list.remove(0); // remove 5
    System.out.println("tail now is: " + list.getTail());
    System.out.println(list);
    list.remove(3); // remove 9
    System.out.println("tail now is: " + list.getTail());
    System.out.println(list);
    list.remove(1); // remove 7
    System.out.println("tail now is: " + list.getTail());
    System.out.println(list);
    list.remove(55); // exception

  }
}
