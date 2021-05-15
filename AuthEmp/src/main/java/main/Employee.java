package main;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.validation.constraints.NotNull;

import javax.persistence.JoinColumn;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name="EMPID")  
	private int empId;

	@Column(name = "EMPNAME", nullable = false, unique = true)
	@NotNull
	private String empName;

	@NotNull
	private String password;

	public Employee() {}

	public Employee(String empName, String password) {
		super();
		this.empName = empName;
		this.password = password;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "EMP_ROLES",
		joinColumns = @JoinColumn(name = "EMPID"),
		inverseJoinColumns = @JoinColumn(name = "ROLEID")
		)
	
	private Set<Role> roles = new HashSet<>(); 
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public void addRole(Role role) {
		this.roles.add(role);
	}
	public void removeRole(Role role) {
		this.roles.remove(role);
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}