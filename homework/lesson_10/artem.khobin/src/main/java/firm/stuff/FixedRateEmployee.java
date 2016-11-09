package firm.stuff;

import firm.Employee;
import firm.PaymentPeriod;

public class FixedRateEmployee extends Employee {
  protected int paymentDaysPeriod;

  public FixedRateEmployee(String employeeName, float employeeRate, PaymentPeriod employeePaymentPeriod) {
    super(employeeName);
    rate = employeeRate;
    paymentDaysPeriod = employeePaymentPeriod.getWeeks() * WORKING_DAYS_PER_WEEK;
  }

  public float calculatePayment() {
    int fullWorkingDays = workingHours / WORKING_HOURS_PER_DAY;
    if (fullWorkingDays < paymentDaysPeriod) {
      return 0;
    }
    return (fullWorkingDays - (fullWorkingDays % paymentDaysPeriod)) * rate;
  }

}
