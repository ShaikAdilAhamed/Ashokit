package in.ashokit.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Account {

	private String holderName;
	private String branch;
	
	@EmbeddedId   //more than one primary key then we use this @Embeded id 
	              //"else" we use @Id annotation for one prmary key
	private AccountPK accountPK;

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public AccountPK getAccountPK() {
		return accountPK;
	}

	public void setAccountPK(AccountPK accountPK) {
		this.accountPK = accountPK;
	}

	@Override
	public String toString() {
		return "Account [holderName=" + holderName + ", branch=" + branch + ", accountPK=" + accountPK + "]";
	}
	
	
	
	
}
