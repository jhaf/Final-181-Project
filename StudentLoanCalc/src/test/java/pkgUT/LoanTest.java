package pkgUT;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import pkgHelper.Loan;

public class LoanTest {

	@Test
	public void LoanTest() {
		
		double loanAmount = 100000;
		double intRate = 0.07;
		int term = 20;
		double extraPayment = 0;
		Date firstDueDate = Loan.parseDate("2019-06-01");
		
		boolean bCompoundType = false;
		double futureValue = 0;
		
		Loan l = new Loan(loanAmount, intRate, term, extraPayment, firstDueDate, bCompoundType, futureValue);
		
	}
}