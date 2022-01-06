package com.mockpage.schoolwebapp.parentportal.parent.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="parent")
public class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	@Size(min=2)
	private String firstName;
	@NotBlank
	@Size(min=2)
	private String lastName;
	@NotBlank
	@Size(min=2)
	private String studentName;
	@NotNull
	private String studentId;
	@Email
	private String email;
	@NotBlank
	@Size(min=8,max=16, message="password must be 8 to 16 characters length!")
	private String password;
	@AssertFalse
	private boolean checked;

	public Parent() {
	}

	public Parent( String firstName, String lastName, String studentName, String studentId, String email,
			String password, boolean checked) {
		super();
	
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentName = studentName;
		this.studentId = studentId;
		this.email = email;
		this.password = password;
		this.checked = checked;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		return Objects.equals(password, other.password) && Objects.equals(studentId, other.studentId);
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentName="
				+ studentName + ", studentId=" + studentId + ", email=" + email + ", password=" + password + ", checked=" + checked + "]";
	}

	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	
}
