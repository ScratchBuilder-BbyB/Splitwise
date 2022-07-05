package domain;

public class OweDetails {
    private double currentAmount;
    private double previousAmount;

    public OweDetails(double amount) {
        this.currentAmount = amount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public double getPreviousAmount() {
        return previousAmount;
    }

    public void setPreviousAmount(double previousAmount) {
        this.previousAmount = previousAmount;
    }

    @Override
    public String toString() {
        return "OweDetails{" +
            "currentAmount=" + currentAmount +
            ", previousAmount=" + previousAmount +
            '}';
    }
}
