import org.junit.Before;
import org.junit.Test;

import algo.queue.LinkedListQueue;
import algo.queue.Queue;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedListQueueTest {
  private Queue<String> queue;

  @Before
  public void init() {
    queue = new LinkedListQueue<>();
  }

  @Test
  public void addItemTest() {
    queue.enqueue("ololo");
    assertThat(queue.dequeue(), is("ololo"));
  }

  @Test
  public void addMultipleItemsTest() {
    queue.enqueue("a");
    queue.enqueue("b");
    queue.enqueue("c");
    queue.enqueue("d");
    assertThat(queue.dequeue(), is("a"));
    assertThat(queue.dequeue(), is("b"));
    assertThat(queue.dequeue(), is("c"));
    assertThat(queue.dequeue(), is("d"));
  }

  @Test
  public void addAndRemoveMultipleItemsTest() {
    queue.enqueue("a");
    queue.enqueue("b");
    queue.dequeue();
    queue.enqueue("c");
    queue.dequeue();
    queue.enqueue("d");
    assertThat(queue.dequeue(), is("c"));
  }
}
