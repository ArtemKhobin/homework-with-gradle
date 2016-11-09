package firm;

public enum PaymentPeriod {
  WEEKLY, BIWEEKLY, MONTHLY;

  public int getWeeks() {
    switch (this) {
      case WEEKLY:
        return 1;
      case BIWEEKLY:
        return 2;
      case MONTHLY:
        return 4;
      default:
        return 0;
    }
  }
}
