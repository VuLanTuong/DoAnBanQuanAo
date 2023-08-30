package com.example.doanbanquanao.model;


import jakarta.persistence.*;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long customerID;
	@Column(name = "full_name", columnDefinition = "nvarchar(255)")
	private String fullName;
	@Embedded
	private Address address;
	@Embedded
	private Contact contact;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private Account account;


	private String avatar;

	private boolean gender;
	
	public Customer() {
		super();
	}

	public Customer(long customerID, String fullName, Address address, Contact contact, Account account, boolean gender, String avatar) {
		this.customerID = customerID;
		this.fullName = fullName;
		this.address = address;
		this.contact = contact;
		this.account = account;
		this.gender = gender;
		this.avatar = avatar;
	}

	public long getCustomerID() {
		return customerID;
	}
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", fullName=" + fullName + ", address=" + address + ", contact="
				+ contact + "]";
	}
	
}
