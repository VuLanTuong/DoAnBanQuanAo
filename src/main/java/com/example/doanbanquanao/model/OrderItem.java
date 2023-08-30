package com.example.doanbanquanao.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderItem {
	@EmbeddedId
	private OrderProductId orderItemId;
	private int quantity;
	private double price;
	private double discount;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("orderId")
	@JoinColumn(name = "order_id", referencedColumnName = "order_id")
	private Order order;
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	@JoinColumn(name = "product_id", referencedColumnName = "product_id")
	private Product product;

	public OrderItem(int quantity, double price, double discount) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof OrderItem orderItem)) return false;
		return Objects.equals(orderItemId, orderItem.orderItemId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderItemId);
	}
}
