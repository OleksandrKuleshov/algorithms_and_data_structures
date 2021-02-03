import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

  private class Itr implements Iterator<E> {

    Node<E> current;

    public Itr(Node<E> start) {
      current = start;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public E next() {
      if (current == null) {
        throw new NoSuchElementException();
      }
      E returnValue = current.data;
      current = current.next;
      return returnValue;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  private static class Node<E> {
    private E data;
    private Node<E> next;

    private Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head;
  private Node<E> tail;
  private int size;

  public SingleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  @Override
  public Iterator<E> iterator() {
    return new Itr(head);
  }

  public void add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == 0) {
      addFirst(item);
    } else if (index == size) {
      addAfter(tail, item);
    } else {
      Node<E> node = getNode(index - 1);
      addAfter(node, item);
    }
  }

  public void addFirst(E data) {
    head = new Node<E>(data, head);
    if (size == 0)
      tail = head;
    size++;
  }

  private Node<E> getNode(int index) {
    if (index == size - 1)
      return tail;
    Node<E> node = head;
    for (int i = 0; i < index && node != null; i++) {
      node = node.next;
    }
    return node;

  }

  public E getTail() {
    return this.tail.data;
  }

  private void addAfter(Node<E> node, E data) {
    node.next = tail = new Node<E>(data, node.next);
    size++;
  }

  public boolean add(E item) {
    add(size, item);
    return true;
  }

  public E remove(int index) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException();
    E returnValue = null;
    if (index == 0) {
      returnValue = removeFirst();
    } else {
      Node<E> nodeBefore = getNode(index - 1);
      if (index == size - 1) {
        tail = nodeBefore;
      }
      returnValue = removeAfter(nodeBefore);
    }
    return returnValue;
  }

  private E removeAfter(Node<E> node) {
    Node<E> temp = node.next;
    if (temp != null) {
      node.next = temp.next;
      size--;
      return temp.data;
    } else {
      return null;
    }
  }

  private E removeFirst() {
    Node<E> temp = head;
    if (head != null) {
      head = head.next;
    }
    if (temp != null) {
      size--;
      return temp.data;
    } else
      return null;
  }

  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> node = getNode(index);
    return node.data;
  }

  public E set(int index, E newValue) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Node<E> node = getNode(index);
    E result = node.data;
    node.data = newValue;
    return result;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    Node<E> node = head;
    while (node != null) {
      sb.append(node.data);
      if (node.next != null)
        sb.append(">>>");
      node = node.next;
    }
    sb.append("]");
    return sb.toString();
  }
}
