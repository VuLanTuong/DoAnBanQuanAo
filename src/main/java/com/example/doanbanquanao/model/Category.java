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
public class Category {

	@Id
	@Column(name = "category_id", columnDefinition = "varchar(55)")
	private String categoryID;
	@Column(name = "category_name", columnDefinition = "nvarchar(255)")
	private String categoryName;

}
