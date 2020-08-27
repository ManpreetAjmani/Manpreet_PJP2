package income;


public class IncomeUtil {
	
	private Double amount;
	private String currency;
	private String city;
	private String gender;
	private String country;
	
	public Double getAverageIncome() {
		return amount;
	}
	public void setAverageIncome(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
