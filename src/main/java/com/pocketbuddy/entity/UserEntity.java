package com.pocketbuddy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity//for create table
@Table(name = "users")//for set a table name

public class UserEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer userId;
		private String  firstName;
		private String  lastName;
		private String  email;
		private String  password;
		private String  contentNum;
		private String  city;
		private String  bornYear;
		private String  gender;
		private String  role;
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getFirstname() {
			return firstName;
		}
		public void setFirstname(String firstname) {
			this.firstName = firstname;
		}
		public String getLastname() {
			return lastName;
		}
		public void setLastname(String lastname) {
			this.lastName = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getContentnum() {
			return contentNum;
		}
		public void setContentnum(String contentnum) {
			this.contentNum = contentnum;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getBornyear() {
			return bornYear;
		}
		public void setBornyear(String bornyear) {
			this.bornYear = bornyear;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		

}
