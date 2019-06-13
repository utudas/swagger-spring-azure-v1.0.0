package io.swagger.model;

import java.util.Arrays;

public enum OrderStatus {
	
  IN_PROGRESS("InProgress"),
  SHIPPED("Shipped"),
  COMPLETED("Completed");
	
	private String value;

	private OrderStatus(String value) {
		this.value = value;
	}

	public static OrderStatus fromValue(String value) {
		for (OrderStatus category : values()) {
			if (category.value.equalsIgnoreCase(value)) {
				return category;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}


}
