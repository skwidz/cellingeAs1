package cellinge.as1;

import java.util.Date;

import android.widget.EditText;

public class Expense extends Claim {

	protected String category; 
	protected String description; 
	protected int  amount;
	protected String currency;
	protected Date date;
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	

	
	
}
