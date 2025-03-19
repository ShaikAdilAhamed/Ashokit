package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name = "CUSTOMER_INFO")
public class Customer {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Integer id;
	
	@Column(name ="FIRST_NAME")
	private String firstName; 
	
	@Column(name ="LAST_NAME")
	private String lastName;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name ="COMPANY")
	private String Company;
	
	@Column(name ="CITY")
	private String city;
	
	@Column(name ="COUNTRY")
	private String Country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public Customer(Integer id, String firstName, String lastName, String email, String company, String city,
			String country) {
		
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Company = company;
		this.city = city;
		Country = country;
	}

	public Customer() {
		super();
		
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", Company=" + Company + ", city=" + city + ", Country=" + Country + "]";
	}
	
	
	
}
