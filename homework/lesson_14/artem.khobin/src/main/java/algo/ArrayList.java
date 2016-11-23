package algo;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
  private Object[] list;
  private int size;

  public void add(T item) {
    if (list == null) {
      list = new Object[1];
      list[0] = item;
    } else {
      list = Arrays.copyOf(list, list.length + 1);
      list[list.length - 1] = item;
    }
    size++;
  }

  public T get(int index) {
    return (T) list[index];
  }

  public void remove(int index) {
    if (index >= list.length || index < 0) {
      return;
    }

    Object[] newList = new Object[list.length - 1];
    for (int i = 0, j = 0; i < list.length - 1; i++, j++) {
      if (i == index) {
        j--;
        continue;
      }
      newList[j] = list[i];
    }

    list = newList;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    list = null;
    size = 0;
  }

  public Iterator<T> iterator() {
    return new Iterator<>();
  }

  public ReverseIterator<T> reverseIterator() {
    return new ReverseIterator<>();
  }

  public Iterator<T> randomIterator() {
    return new RandomIterator<T>();
  }

  private class Iterator<T> implements algo.Iterator<T> {
    int index;

    public boolean hasNext() {
      return list != null && index < list.length;
    }

    public T next() {
      return (T) list[index++];
    }
  }

  private class ReverseIterator<T> implements algo.ReverseIterator<T> {
    int index;

    public ReverseIterator() {
      index = list.length - 1;
    }

    public boolean hasPrevious() {
      return list != null && index >= 0;
    }

    public T previous() {
      return (T) list[index--];
    }
  }

  private class RandomIterator<T> extends Iterator<T> {
    int iteration = 0;
    final int limit = 100;

    public boolean hasNext() {
      return list != null && iteration < limit;
    }

    public T next() {
      int randomIndex = (int) Math.random() * list.length;
      iteration++;
      return (T) list[randomIndex];
    }
  }
}
