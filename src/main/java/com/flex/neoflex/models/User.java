package com.flex.neoflex.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="usr")
public class User {
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

	public User(int id, String name, String lastname, int email) {
	}
}
