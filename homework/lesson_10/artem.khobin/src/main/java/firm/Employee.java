package firm;

public abstract class Employee implements Payable {
  protected String name;
  protected float rate;
  protected int workingHours;
  protected int paymentDaysPeriod;

  public void setWorkingHours(int workingHours) {
    this.workingHours = workingHours;
  }
}
