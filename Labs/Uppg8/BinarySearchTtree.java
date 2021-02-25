package Labs.Uppg8;

public class BinarySearchTtree<E extends Comparable<E>> {

  private static class Node<E> {
    private E data;
    private Node<E> left, right;

    private Node(E data) {
      this.data = data;
      left = right = null;
    }

    @Override
    public String toString() {
      return data.toString();
    }
  }

  private Node<E> root;

  public BinarySearchTtree() {
    root = null;
  }

  public boolean add(E data) {
    if (root == null) {
      root = new Node<E>(data);
      return true;
    } else {
      return add(data, root);
    }
  }

  public E find(E target) {
    return find(target, root);
  }

  private E find(E target, Node<E> node) {
    if (node == null) {
      return null;
    }
    if (target.compareTo(node.data) == 0) {
      return node.data;
    } else if (target.compareTo(node.data) < 0) {
      return find(target, node.left);
    } else {
      return find(target, node.right);
    }
  }

  public E getNextLarger(E target) {
    if (root == null)
      return null;
    return getNextLarger(target, root);
  }

  public E getNextLarger(E target, Node<E> node) {
    if (target.compareTo(node.data) < 0) {
      if (node.left == null || target.compareTo(node.left.data) > 0 || target.compareTo(node.left.data) == 0) {
        return node.data;
      } else {
        return getNextLarger(target, node.left);
      }
    } else {
      if (node.right == null) {
        return null;
      } else {
        return getNextLarger(target, node.right);
      }
    }
  }

  private boolean add(E data, Node<E> node) {
    if (data.compareTo(node.data) == 0)
      return false;
    else if (data.compareTo(node.data) < 0) {
      if (node.left == null) {
        node.left = new Node<E>(data);
        return true;
      } else {
        return add(data, node.left);
      }
    } else {
      if (node.right == null) {
        node.right = new Node<E>(data);
        return true;
      } else {
        return add(data, node.right);
      }
    }
  }

  private void inOrder(Node<E> node, StringBuilder sb) {
    if (node != null) {
      inOrder(node.left, sb);
      sb.append(": " + node);
      inOrder(node.right, sb);
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    inOrder(root, sb);
    return sb.toString();
  }
}
