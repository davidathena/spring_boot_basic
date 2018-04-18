package com.richway.basic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(nullable = false)
	private String roleName;
	
	@Column(nullable = false)
	private Integer sortId;

	public Role(){}
	
	public Role(String roleName, Integer sortId) {
		super();
		this.roleName = roleName;
		this.sortId = sortId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getSortId() {
		return sortId;
	}

	public void setSortId(Integer sortId) {
		this.sortId = sortId;
	}

}
