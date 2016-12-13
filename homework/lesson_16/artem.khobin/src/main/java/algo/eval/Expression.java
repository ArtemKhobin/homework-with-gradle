package algo.eval;

import algo.stack.LinkedListStack;
import algo.stack.Stack;

public class Expression {
  private Stack<Character> operators = new LinkedListStack<>();
  private Stack<Double> operands = new LinkedListStack<>();

  public double evaluate(String exprStr) {
    int operandLength;
    int operationsCount = 0;
    int bracketOperationsCount = 0;
    for (int i = 0; i < exprStr.length(); i++) {
      char ch = exprStr.charAt(i);
      if ("*/+-".indexOf(ch) != -1) {
        operators.push(ch);
        operationsCount++;
        bracketOperationsCount++;
      } else if (Character.isDigit(ch)) {
        operandLength = getOperandCharsCount(exprStr, i);
        operands.push(Double.parseDouble(exprStr.substring(i, i + operandLength)));
        i = i + operandLength - 1;
      } else if (ch == '(') {
        bracketOperationsCount = 0;
      }

      if (ch == ')') {
        for (int j = 0; j < bracketOperationsCount; j++) {
          makeOperation();
        }
        operationsCount = operationsCount - bracketOperationsCount;
      } else if (i >= exprStr.length() - 1) {
        for (int j = 0; j < operationsCount; j++) {
          makeOperation();
        }
      }
    }

    return operands.pop();
  }

  private int getOperandCharsCount(String expression, int position) {
    int result = 0;
    while (position < expression.length() && Character.getNumericValue(expression.charAt(position)) > -1) {
      result++;
      position++;
    }
    return result;
  }

  private void makeOperation() {
    double result = operands.pop();
    char operation = operators.pop();
    switch (operation) {
      case '+':
        result += operands.pop();
        break;
      case '-':
        result = operands.pop() - result;
        break;
      case '*':
        result *= operands.pop();
        break;
      case '/':
        result = operands.pop() / result;
        break;
      default:
        break;
    }
    operands.push(result);
  }
}
