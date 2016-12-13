import algo.stack.LinkedListStack;
import algo.stack.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LinkedListStackTest {
  private Stack<String> stack;

  @Before
  public void init() {
    stack = new LinkedListStack<>();
  }

  @Test
  public void addItemTest() {
    stack.push("ololo");
    assertThat(stack.pop(), is("ololo"));
  }

  @Test
  public void addMultipleItemsTest() {
    stack.push("a");
    stack.push("b");
    stack.push("c");
    stack.push("d");
    assertThat(stack.pop(), is("d"));
    assertThat(stack.pop(), is("c"));
    assertThat(stack.pop(), is("b"));
    assertThat(stack.pop(), is("a"));
  }

  @Test
  public void addAndRemoveMultipleItemsTest() {
    stack.push("a");
    stack.push("b");
    stack.pop();
    stack.push("c");
    stack.pop();
    stack.push("d");
    assertThat(stack.pop(), is("d"));
  }
}
