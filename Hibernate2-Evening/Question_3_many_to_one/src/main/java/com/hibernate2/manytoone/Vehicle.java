package com.hibernate2.HibernateManyToOneDemo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Vehicle_Id")
	private int vehicleId;

	@Column(name="Vehicle_Name")
	private String vehicleName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="User_Id")
	private UserDetails user;

	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}