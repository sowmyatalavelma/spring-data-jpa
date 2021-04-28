package com.cg.homeloan.entities;

/**
 * 
 * @author VINAYA SREE
 *
 */

import javax.persistence.CascadeType;

//import java.util.HashSet;
//import java.util.Set;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.homeloan.dto.FinanceVerificationDetails;

@Entity
@Table(name = "financeofficer_details")
public class FinanceVerificationOfficer {

	@Id
	@GeneratedValue

	private int userId;
	private String finOfficerName;
	private String finOfficerContact;
//	
//	@OneToMany(targetEntity = User.class, mappedBy="officer",cascade = CascadeType.ALL)
//	private Set<User> users=new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fofficeruser_id")
	private User user;

	public FinanceVerificationOfficer() {
	}

	public FinanceVerificationOfficer(String finOfficerName, String finOfficerContact) {
		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
	}

	public FinanceVerificationOfficer(String finOfficerName, String finOfficerContact, User user) {

		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
		this.user = user;
	}

	public FinanceVerificationOfficer(int userId, String finOfficerName, String finOfficerContact, User user) {
		super();
		this.userId = userId;
		this.finOfficerName = finOfficerName;
		this.finOfficerContact = finOfficerContact;
		this.user = user;
	}

	public FinanceVerificationOfficer(FinanceVerificationDetails fd) {
		this.userId = fd.getUserId();
		this.finOfficerName = fd.getFinOfficerName();
		this.finOfficerContact = fd.getFinOfficerContact();

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// public void addUsers(User user)
//	{
//		user.setOfficer(this);
//		users.add(user);
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFinOfficerName() {
		return finOfficerName;
	}

	public void setFinOfficerName(String finOfficerName) {
		this.finOfficerName = finOfficerName;
	}

	public String getFinOfficerContact() {
		return finOfficerContact;
	}

	public void setFinOfficerContact(String finOfficerContact) {
		this.finOfficerContact = finOfficerContact;
	}

//	public Set<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}

	@Override
	public String toString() {
		return "FinanceVerificationOfficer [userId=" + userId + ", finOfficerName=" + finOfficerName
				+ ", finOfficerContact=" + finOfficerContact + ", users=" + user + "]";
	}

}
