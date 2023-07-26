package insta.model;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
	private UUID accountNumber;
	private String accountName;
	private String name;
	private ArrayList<Account> followers; 
	
	public Account(String pAccountName, String pName) {
		this.accountName = pAccountName;
		this.name = pName;
		accountNumber = java.util.UUID.randomUUID();
		followers = new ArrayList<Account>();
	}

	public UUID getAccountNumber() {
		return accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addFollower(Account pFollower) {
		this.followers.add(pFollower);
	}
	
	public ArrayList<Account> getFollowers() {
		return this.followers;
	}
}
