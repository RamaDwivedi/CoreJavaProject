package com.code;

public enum ServicePlan {
SILVER(1000),GOLD(2000),dIAMOND(5000),PLATINUM(10000);
	private double planCharge;

	private ServicePlan(double planCharge) {
		this.planCharge = planCharge;
	}
	
	
	public double getPlanCharge() {
		return planCharge;
	}


	public String toString()
	{
		return name()+" "+ordinal()+" "+planCharge;
		
	}
}

