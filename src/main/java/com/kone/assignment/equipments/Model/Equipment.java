package com.kone.assignment.equipments.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id"})
public class Equipment 	{
	
	
	public String getId() {
		return _id;
	}
	
	
	private String _id;
	
	private String equipment_number;
	private String address;
	private String contract_start_date;
	private String contract_end_date;
	private String status;	
	
	
	public String getEquipment_number() {
		return equipment_number;
	}

	public void setEquipment_number(String equipment_number) {
		this.equipment_number = equipment_number;
		this._id=equipment_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContract_start_date() {
		return contract_start_date;
	}

	public void setContract_start_date(String contract_start_date) {
		this.contract_start_date = contract_start_date;
	}

	public String getContract_end_date() {
		return contract_end_date;
	}

	public void setContract_end_date(String contract_end_date) {
		this.contract_end_date = contract_end_date;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
