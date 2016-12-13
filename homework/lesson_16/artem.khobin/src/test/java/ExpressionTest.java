import algo.eval.Expression;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ExpressionTest {
  private Expression expr;

  @Before
  public void init() {
    expr = new Expression();
  }

  @Test
  public void simpleExpressionTest() {
    assertThat(expr.evaluate("2+3"), is(5.0));
  }

  @Test
  public void bigNumbersExpressionTest() {
    assertThat(expr.evaluate("52+118-50"), is(120.0));
  }

}
