package com.example.doanbanquanao.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Contact {
	
	private String phoneNumber;
	private String email;

}
