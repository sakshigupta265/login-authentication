package com.ravionics.user.entity;

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
@Table(name="constant")

public class Constant {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="constantid")
	private int constantId;
	@Column(name="constantname")
	private String constantName;
/*	@Column(name="allowedconstantid")
	private int allowedConstantId;*/
	@Column(name="statusy")
	private byte statusId;
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "allowedconstantid")
	  private ConstantType ConstantType;
	
	public Constant(int constantId, String constnatName, int allowedConstantId, byte statusId) {
		super();
		this.constantId = constantId;
		this.constantName = constnatName;
//		this.allowedConstantId = allowedConstantId;
		this.statusId = statusId;
	}
	public int getConstantId() {
		return constantId;
	}
	public void setConstantId(int constantId) {
		this.constantId = constantId;
	}
	public String getConstnatName() {
		return constantName;
	}
	public void setConstnatName(String constnatName) {
		this.constantName = constnatName;
	}
/*	public int getAllowedConstantId() {
		return allowedConstantId;
	}
	public void setAllowedConstantId(int allowedConstantId) {
		this.allowedConstantId = allowedConstantId;
	}*/
	
	

}
