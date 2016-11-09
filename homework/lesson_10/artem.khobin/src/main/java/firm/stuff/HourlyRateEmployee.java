package firm.stuff;

import firm.Employee;

public class HourlyRateEmployee extends Employee {
  public HourlyRateEmployee(String employeeName, float employeeRate) {
    name = employeeName;
    rate = employeeRate;
  }

  public float calculatePayment() {
    return workingHours * rate;
  }
}
