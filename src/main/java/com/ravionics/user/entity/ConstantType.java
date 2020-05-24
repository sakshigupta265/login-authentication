package com.ravionics.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="constanttype")
public class ConstantType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="allowedconstantid")
	private int allowedConstantId;
	@Column(name="allowedconstanttype")
	private String allowedConstantType;
	
		
	public ConstantType(int allowedConstantId, String allowedConstantType) {
		super();
		this.allowedConstantId = allowedConstantId;
		this.allowedConstantType = allowedConstantType;
	}
	
	public int getAllowedConstantId() {
		return allowedConstantId;
	}
	public void setAllowedConstantId(int allowedConstantId) {
		this.allowedConstantId = allowedConstantId;
	}
	public String getAllowedConstantType() {
		return allowedConstantType;
	}
	public void setAllowedConstantType(String allowedConstantType) {
		this.allowedConstantType = allowedConstantType;
	}
	
	
	

}
