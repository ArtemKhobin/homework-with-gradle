package firm;

public interface Payable {
  int WORKING_HOURS_PER_DAY = 8;
  int WORKING_DAYS_PER_WEEK = 5;

  float calculatePayment();
  
  void setWorkingHours(int workingHours);
}
