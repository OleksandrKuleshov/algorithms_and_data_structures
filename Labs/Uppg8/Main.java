package Labs.Uppg8;

public class Main {
  public static void main(String[] args) {
    BinarySearchTtree<Integer> tree = new BinarySearchTtree<>();

    tree.add(5);
    tree.add(2);
    tree.add(1);
    tree.add(8);
    tree.add(12);
    System.out.println(tree.getNextLarger(2));
    System.out.println(tree.getNextLarger(3));
    System.out.println(tree.getNextLarger(4));
    System.out.println(tree.getNextLarger(5));
    System.out.println(tree.getNextLarger(6));
    System.out.println(tree.getNextLarger(9));
    System.out.println(tree.getNextLarger(12));
    System.out.println(tree.getNextLarger(13));
  }

}
