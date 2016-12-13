package algo.queue;

import list.LinkedList;

public class LinkedListQueue<T> implements Queue<T> {
  private LinkedList<T> list = new LinkedList<>();

  public void enqueue(T item) {
    list.add(item);
  }

  public T dequeue() {
    T item = list.get(0);
    list.remove(0);
    return item;
  }
}
