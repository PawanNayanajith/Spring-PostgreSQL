package com.sgic.myleave.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "leave", name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6037643998340730223L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String telephone;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<LeaveRequest> leaveRequest;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	@JsonIgnore
	public List<LeaveRequest> getLeaveRequest() {
		return leaveRequest;
	}

/*	public void setLeaveRequest(List<LeaveRequest> leaveRequest) {
		this.leaveRequest = leaveRequest;
	}
*/
}
