package com.example.doanbanquanao.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderID;
	@Column(name = "order_status", columnDefinition = "nvarchar(255)")
	private String orderStatus;
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name = "shipped_date")
	private LocalDate shippedDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", referencedColumnName = "staff_id")
	private Staff staff;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;
	@OneToMany(mappedBy ="order")
	private Set<OrderItem> orderItemList = new HashSet<>();

	public Order(long orderID, String orderStatus, LocalDate orderDate, LocalDate shippedDate, Staff staff,
			Customer customer) {
		super();
		this.orderID = orderID;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.shippedDate = shippedDate;
		this.staff = staff;
		this.customer = customer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Order order)) return false;
		return orderID == order.orderID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderID);
	}
}
