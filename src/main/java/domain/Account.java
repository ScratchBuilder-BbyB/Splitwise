package domain;

import utils.IDGenerator;

public class Account {

  private final String id;
  private User lendUser;
  private User owedUser;
  private OweDetails oweDetails;

  public Account(User lendUser, User owedUser) {
    this.id = IDGenerator.getAccountId(lendUser.getName(), owedUser.getName());
    this.lendUser = lendUser;
    this.owedUser = owedUser;
    this.oweDetails = new OweDetails(0);
  }

  public String getId() {
    return id;
  }

  public User getLendUser() {
    return lendUser;
  }

  public void setLendUser(User lendUser) {
    this.lendUser = lendUser;
  }

  public User getOwedUser() {
    return owedUser;
  }

  public void setOwedUser(User owedUser) {
    this.owedUser = owedUser;
  }

  public OweDetails getOweDetails() {
    return oweDetails;
  }

  public void setOweDetails(OweDetails oweDetails) {
    this.oweDetails = oweDetails;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id='" + id + '\'' +
        ", lendUser=" + lendUser +
        ", owedUser=" + owedUser +
        ", oweDetails=" + oweDetails +
        '}';
  }
}
