package com.example.doanbanquanao.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Staff {

	@Id
	@Column(name = "staff_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long staffID;
	@Column(name = "full_name", columnDefinition = "nvarchar(255)", nullable = false)
	private String fullName;
	@Enumerated(EnumType.ORDINAL)
	private Gender gender;
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id", referencedColumnName = "staff_id")
    private Staff managerID;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_name", referencedColumnName = "user_name")
	private Account account;

	public Staff(long staffID, String fullName, Gender gender, Contact contact, Address address) {
		super();
		this.staffID = staffID;
		this.fullName = fullName;
		this.gender = gender;
		this.contact = contact;
		this.address = address;
	}

}
