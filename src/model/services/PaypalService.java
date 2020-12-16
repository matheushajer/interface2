package model.services;

public class PaypalService implements OnlinePayment {

	private static final double fee_percentage = 0.02;
	private static final double month_percentage = 0.01;
	
	@Override
	public double paymentFee(double amount) {
		return amount * fee_percentage;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * month_percentage * months;
	}

}
