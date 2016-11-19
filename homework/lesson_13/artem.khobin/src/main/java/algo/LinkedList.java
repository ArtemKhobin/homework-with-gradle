package algo;

public class LinkedList<T> implements List<T> {
  private Node<T> lastNode;
  private Node<T> firstNode;
  private int size;

  public void add(T item) {
    if (size == 0) {
      firstNode = lastNode = new Node<>();
      lastNode.value = item;
    } else {
      Node<T> temp = lastNode;
      lastNode = new Node<>();
      lastNode.value = item;

      if (temp != null) {
        temp.next = lastNode;
      }
      lastNode.prev = temp;
    }
    size++;
  }

  public T get(int index) {
    T result = null;
    if (index < size / 2 ) {
      Iterator<T> iterator = iterator();
      for (int i = 0; i <= index; i++) {
        if (!iterator.hasNext()) {
          break;
        }
        result = iterator.next();
      }
    } else {
      ReverseIterator<T> iterator = reverseIterator();
      for (int i = size - 1; i >= index; i--) {
        if (!iterator.hasPrevious()) {
          break;
        }
        result = iterator.previous();
      }
    }
    return result;
  }

  public void remove(int index) {
    Node<T> nodeToRemove = firstNode;
    for (int i = 0; i < index; i++) {
      nodeToRemove = nodeToRemove.next;
    }

    if (nodeToRemove.next != null) {
      nodeToRemove.next.prev = nodeToRemove.prev;
    } else {
      lastNode = nodeToRemove.prev;
    }
    if (nodeToRemove.prev != null) {
      nodeToRemove.prev.next = nodeToRemove.next;
    } else {
      firstNode = nodeToRemove.next;
    }

    size--;
  }

  public boolean isEmpty() {
    return firstNode == null && lastNode == null;
  }

  public int size() {
    return size;
  }

  public void clear() {
    firstNode = null;
    lastNode = null;
    size = 0;
  }

  public Iterator<T> iterator() {
    return new Iterator<>(firstNode);
  }

  public ReverseIterator<T> reverseIterator() {
    return new ReverseIterator<>(lastNode);
  }


  private static class Node<T> {
    public T value;
    Node<T> next;
    Node<T> prev;
  }

  public class Iterator<T> implements algo.Iterator {
    Node<T> current;

    public Iterator(Node<T> node) {
      current = node;
    }

    public boolean hasNext() {
      return current != null;
    }

    public T next() {
      T item = current.value;
      current = current.next;
      return item;
    }
  }

  public class ReverseIterator<T> implements algo.ReverseIterator {
    Node<T> current;

    public ReverseIterator(Node<T> node) {
      current = node;
    }

    public boolean hasPrevious() {
      return current != null;
    }

    public T previous() {
      T item = current.value;
      current = current.prev;
      return item;
    }
  }
}
