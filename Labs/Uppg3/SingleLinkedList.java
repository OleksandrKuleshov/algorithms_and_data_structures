package Labs.Uppg3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SingleLinkedList<E> implements Iterable<E> {

  private class Itr implements Iterator<E> {
    Node<E> current;
    Node<E> prevCurrent;
    Node<E> prevPrevCurrent;

    public Itr(Node<E> start) {
      this.current = start;
      prevCurrent = null;
      prevPrevCurrent = null;
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
      if (prevPrevCurrent == prevCurrent || prevCurrent == current)
        prevPrevCurrent = null;
      else
        prevPrevCurrent = prevCurrent;
      prevCurrent = current;
      current = current.next;
      return returnValue;
    }

    @Override
    public void remove() {
      if (prevCurrent == null)
        throw new NoSuchElementException();
      if (prevPrevCurrent == null) {
        head = prevCurrent = head.next;
      } else {
        System.out.println(prevPrevCurrent.data + " " + prevCurrent.data + " " + current.data);
        prevCurrent = prevPrevCurrent;
        prevCurrent.next = current;
        prevPrevCurrent = null;
      }
    }

  }

  private static class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<E> head;
  private int size;

  public SingleLinkedList() {
    head = null;
    size = 0;
  }

  public Iterator<E> iterator() {
    return new Itr(head);
  }

  public void add(int index, E element) {
    if (index == 0)
      addFirst(element);

    else {
      Node<E> node = getNode(index - 1);
      addAfter(node, element);
    }
  }

  public void addFirst(E element) {
    head = new Node<E>(element, head);
    size++;
  }

  private Node<E> getNode(int index) {
    Node<E> current = head;

    for (int i = 0; i < index && current != null; i++) {
      current = current.next;
    }
    return current;
  }

  public void addAfter(Node<E> node, E element) {
    node.next = new Node<E>(element, node.next);
    size++;
  }

  public boolean add(E element) {
    add(size, element);
    return true;
  }

  public E get(int index) {
    if (index > size)
      throw new IndexOutOfBoundsException();

    return getNode(index).data;
  }

  @Override
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
