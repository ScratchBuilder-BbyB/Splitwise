package domain;

public class OweDetailsWrapper {
  private String userName;
  private Double amount;

  public OweDetailsWrapper(String userName, Double amount) {
    this.userName = userName;
    this.amount = amount;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "OweDetailsWrapper{" +
        "userName='" + userName + '\'' +
        ", amount=" + amount +
        '}';
  }
}
