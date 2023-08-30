package com.example.doanbanquanao.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productID;
	@Column(name = "product_name", columnDefinition = "nvarchar(255)", nullable = false)
	private String productName;
	@Column(name = "product_type", columnDefinition = "nvarchar(255)")
	private String productType;
	private double price;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private Size size;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "product_color", joinColumns = { @JoinColumn(name = "product_id")})
	@Column(name = "color", nullable = false)
	private Set<String> color;
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "product_image", joinColumns = { @JoinColumn(name = "product_id")})
	@Column(name = "image", nullable = false)
	private Set<String> image;
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	@OneToMany(mappedBy ="product")
	private Set<OrderItem> orderItemList = new HashSet<>();

	public Product(long productID, String productName, String productType, double price, int quantity,Size size, Set<String> color, Set<String> image, Category category) {
		this.productID = productID;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.quantity = quantity;
		this.size = size;
		this.color = color;
		this.image = image;
		this.category = category;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Product product)) return false;
		return productID == product.productID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productID);
	}
}
