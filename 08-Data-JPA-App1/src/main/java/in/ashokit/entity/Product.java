package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.TableGenerator;

@Entity
public class Product {

	@Id   //it is use to show that this is a primary key
	
	////SEQUENCE type custom generator
	//@SequenceGenerator(name = "pid",sequenceName = "pid_seq")
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pid")

	
	//table type custom generator
//	@TableGenerator(initialValue = 100,name = "pid",table = "pid_seq_tbl")
//	@GeneratedValue(strategy = GenerationType.TABLE,generator = "pid")
	
	//normal way for using in  mysql 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId; //int default value is "0"   , Integer default value is "null"
	private String productName; //String default value is null
	private Double productPrice; //double default value is "0"  , Double  default value is "null"
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}
	public Product() {
		
	}
	public Product(Integer productId, String productName, Double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
	

	
	
	
}
