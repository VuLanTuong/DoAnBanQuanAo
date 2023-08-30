package com.example.doanbanquanao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Account {

	@Id
	@Column(name = "user_name", columnDefinition = "varchar(55)")
	private String userName;
	@Column(name = "pass_word", columnDefinition = "nvarchar(255)")
	private String passWord;

}
