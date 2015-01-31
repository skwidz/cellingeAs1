package cellinge.as1;

import java.util.Date;



public class Claim {
	
	
	protected Date startDate;
	protected Date endDate;
	protected String Name;
	protected String description;
	protected String status;
	
	
	public Claim() {
		super();
		
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStartDate(){
		return startDate;
	}
	
	public void setStartDate(Date date){
		this.startDate = date;
	}
	
	public Date getEndDate(){
		return endDate;
	}
	
	public void setEndDate(Date date){
		this.endDate = date; 
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String name){
		this.Name = name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String string){
		this.description = string;
	}
	
	public String toString(){
		return "Claim[name=" + Name + ", startDate=" + startDate + ", endDate=" + endDate + ", description=" + description +"]";
	}
	
}
	