package com.flex.neoflex.models;

import jakarta.persistence.*;

@Entity
@Table(name="usr")
public class User {
	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer bank_id;
	private String lastname;
	private String name;
	private String patronymic;
	private Integer birth;
	private String passport;
	private String city;
	private String phone_number;
	private String email;
	private String address_reg;
	private String address_fact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getBank_id() {
		return bank_id;
	}

	public void setBank_id(Integer bank_id) {
		this.bank_id = bank_id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public Integer getBirth() {
		return birth;
	}

	public void setBirth(Integer birth) {
		this.birth = birth;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress_reg() {
		return address_reg;
	}

	public void setAddress_reg(String address_reg) {
		this.address_reg = address_reg;
	}

	public String getAddress_fact() {
		return address_fact;
	}

	public void setAddress_fact(String address_fact) {
		this.address_fact = address_fact;
	}
}
