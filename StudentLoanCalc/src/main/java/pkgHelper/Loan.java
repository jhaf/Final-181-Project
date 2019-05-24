package pkgHelper;

import java.util.LinkedList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.*;


public class Loan {
	
	private double LoanAmount;
	private double IntRate;
	private int Term;
	private double ExtraPayment;
	private Date FirstDueDate;
	private boolean bCompoundType;
	private double FutureValue;
	
	private LinkedList<Payment> LoanPayments = new LinkedList<Payment>();
	
	public Loan(double loanAmount, double intRate, int term, double extraPayment, Date firstDueDate,
			boolean bCompountType, double futureValue) {
		super();
		
		LoanAmount = loanAmount;
		IntRate = intRate;
		Term = term;
		ExtraPayment = extraPayment;
		FirstDueDate = firstDueDate;
		this.bCompoundType = bCompoundType;
		FutureValue = futureValue;
		
		double dRollingBalance = this.LoanAmount;
		int iPaymentNbr = 0;
		
		do {
			Payment p = new Payment (++iPaymentNbr, firstDueDate, dRollingBalance, this);
			
			LoanPayments.add(p);
			System.out.print("Payment Nbr ");
			System.out.print(iPaymentNbr);
			System.out.print(" ");
			System.out.println(LoanPayments.getLast().getBalance());
			
			if (LoanPayments.getLast().getBalance() <= 0) {
				LoanPayments.getLast().ZeroBalance();
				break;
			}
		}
		while(true);
		System.out.println(LoanPayments.size());
	}

	
 double getLoanAmount() {
			return LoanAmount;
		}
		
		public double getIntRate() {
			return IntRate;
		}
		
		public int getTerm() {
			return Term;
		}
		
		public double getExtraPayment() {
			return ExtraPayment;
		}
		
		public double getFutureValue() {
			return FutureValue;
		}
		
		public static Date parseDate(String date) {
			try {
				return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			}
			catch (ParseException e) {
				return null;
			}
		}
}
