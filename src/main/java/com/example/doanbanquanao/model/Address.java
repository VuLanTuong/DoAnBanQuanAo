package com.example.doanbanquanao.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
	private String street;
	private String homeNumber;
	private String ward;
	private String district;
	private String city;
}
