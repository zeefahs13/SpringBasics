package com.springbasics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


/******************HIBERNATE NOTES OF ANNOTATIONS**************
 * Annotations can be either on getters or fields.
 * If annotations are on getters, it will get value from getter instead of field we can customize values from getter
 * If annotation are on fields, it will take field value and no customized/filtered value will be taken for hibernate object save
 * 
 * 
 * @basic: Treat it as field which has to be persisted and creates columns. If we need to configure fetch and optional properties
 * 
 * @Transient: If you dont want the field to be saved in database mark it as static or transient
 * 
 * @Temporal: Will select date/time/data time for a particular field like audit;
 * 
 * @Lob: Lob is basically a large object which contains large amount of text. There are 2 types of Lobs
 * 
 * character Lob @clob
 * Bytestream lob @blob
 * 
 * If @Lob is on top of string field hibernate chooses @clob or if the @Lob is top of byte[] field it chooses @blob
 * 
 * 
 * @GeneratedValue: With this annotation on the field hibernate will generate the surrogate key for us. With this hibernate will
 * get nextVal of hibernate_sequence and will generate next value for the field based on the data type of the field
 * 
 * The GeneratedValues will have strategy AUTO,IDENTITY, SEQUENCE and TABLE
 * 
 * AUTO: Hibernate will take care of the strategy to generate unique keys
 * IDENTITY: Few databases provide the feasibility to generate Identity values. Hibernate will use that feature provided by database inorder to come up with
 * 			 unique key generation. (MySQL provides this feature)
 * SEQUENCE: It follows a sequence it checks the last sequence value and generates the next value in the sequence(PostGres)
 * 
 * TABLE: Uses the last generated primary key and generates value based on it.
 * 
 * 
 * 
 * 
 * @author hshaik
 *
 */


//@Entity tells hibernate that its needs to save this object to a table
//@Id will tell hibernate that it is a primary key for this object
@Entity
@Table(name = "customer",uniqueConstraints={@UniqueConstraint(columnNames={"customerId"})})
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId", updatable = false, nullable = false)
	private int customerId;
	
	@Transient
	private String testval;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="company")
	private String company;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="country")
	private String country;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(name="create_date")
//	private Date create_date;

	public String getTestval() {
		return testval;
	}

	public void setTestval(String testval) {
		this.testval = testval;
	}


	@OneToOne(mappedBy = "customer")
	private Order order;
	


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", company=" + company
				+ ", address=" + address + ", city=" + city + ", country=" + country + ", email=" + email + ", mobile="
				+ mobile + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

}
