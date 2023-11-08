package com.code;

public enum ServicePlan {
SILVER(1000), GOLD(2000),dIAMOND(5000),pLATINUM(10000);
private double plancharge;

private ServicePlan(double plancharge) {
	this.plancharge = plancharge;
}

	public double getPlancharge() {
		return plancharge;
	}
	public String toString()
	{
		return name()+" "+plancharge;
	}
	
}
