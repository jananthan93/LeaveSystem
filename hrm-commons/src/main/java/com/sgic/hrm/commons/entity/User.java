package com.sgic.hrm.commons.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "user", schema = "employee")
public class User implements Serializable {

	private static final long serialVersionUID = 8918656601415434315L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fullName;
	private String gender;
	private String telephoneNumber;
	private String mobileNumber;
	private String email;
	private String permenentAddress;
	private Date joinDate;
	private Integer servicePeriod;
	private String profilePhoto;
	private String nationality;
	private String nic;
	private String religion;
	private Date dateOfBirth;
	private String residentialAddress;
	private String maritalStatus;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	@UpdateTimestamp
	private Date updateAt;

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getGender() {
		return gender;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getPermenentAddress() {
		return permenentAddress;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public Integer getServicePeriod() {
		return servicePeriod;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public String getNationality() {
		return nationality;
	}

	public String getNic() {
		return nic;
	}

	public String getReligion() {
		return religion;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public Department getDepartment() {
		return department;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPermenentAddress(String permenentAddress) {
		this.permenentAddress = permenentAddress;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public void setServicePeriod(Integer servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
