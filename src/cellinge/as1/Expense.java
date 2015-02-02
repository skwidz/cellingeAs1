package cellinge.as1;

import java.util.Date;

import android.widget.EditText;

public class Expense extends Claim {

	protected String category; 
	protected String expenseDescription; 
	protected String  amount;
	protected String currency;
	protected String date;
	
	public Expense() {
		super("In Progress");
		// TODO Auto-generated constructor stub
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getexpenseDescription() {
		return expenseDescription;
	}

	public void setexpenseDescription(String expenseDescription) {
		this.expenseDescription = expenseDescription;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	
	
	

	
	
}
