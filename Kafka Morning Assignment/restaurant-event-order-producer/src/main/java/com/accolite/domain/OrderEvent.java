package com.accolite.domain;

public class OrderEvent {
	private Integer OrderEventId;
	private Order order;
	public Integer getOrderEventId() {
		return this.OrderEventId;
	}
	public void setOrderEventId(Integer OrderEventId) {
		this.OrderEventId = OrderEventId;
	}
	public Order getOrder() {
		return this.order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
