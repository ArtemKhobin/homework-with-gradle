package algo.stack;

import algo.queue.Queue;
import list.LinkedList;

public class LinkedListStack<T> implements Stack<T> {
  private LinkedList<T> list = new LinkedList<>();

  public void push(T item) {
    list.add(item);
  }

  public T pop() {
    int index = list.size() - 1;
    T item = list.get(index);
    list.remove(index);
    return item;
  }
}
