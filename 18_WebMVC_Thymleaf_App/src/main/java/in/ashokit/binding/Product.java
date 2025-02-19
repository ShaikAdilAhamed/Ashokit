package in.ashokit.binding;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {

	@NotNull(message = "ID is required")
	private Integer pid;
	@NotNull(message = "Name is required")
	@Size(min = 3, max = 8)
	private String pname;
	@NotNull(message = "Price is required")
	private Double price;
	public Integer getPid() {
		return pid;
	}
	public String getPname() {
		return pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + "]";
	}
	
	
}
