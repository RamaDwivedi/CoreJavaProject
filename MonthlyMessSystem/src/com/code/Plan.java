package com.code;

public enum Plan {
	 MONTHLY(3000), QUATERLY(11700), HALFYEAR(17500), YEARLY(32000);
	private double minBalance;

	private Plan(double minBalance) {
		this.minBalance = minBalance;
	}
	
	public double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(double minBalance) {
		this.minBalance = minBalance;
	}

	public String toString()

{
	return name();
		}
}
