package fr.epsi;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "person")
@XmlRootElement(name="person")
public class Person {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Basic
	@Column(length = 30, nullable = false)
	private String firstname;

	@Basic
	@Column(length = 30, nullable = false)
	private String lastname;

	@Column(length = 3, nullable = false)
	private Integer age;

	public Long getId() {
		return id;
	}

	public String getPrenom() {
		return lastname;
	}

	public String getNom() {
		return firstname;
	}

	public int getAge() {
		return age;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrenom(String lastname) {
		this.lastname = lastname;
	}

	public void setNom(String firstname) {
		this.firstname = firstname;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
