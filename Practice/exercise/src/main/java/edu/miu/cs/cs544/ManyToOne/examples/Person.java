package edu.miu.cs.cs544.ManyToOne.examples;

import javax.persistence.*;
import java.util.StringTokenizer;

@Entity
@Table(name="MY_PERSON")
public class Person {
	private long id;
	private String firstname;
	private String lastname;

	public Person() {
	}

	public Person(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return firstname + " " + lastname;
	}

	public void setName(String name) {
		StringTokenizer st = new StringTokenizer(name);
		firstname = st.nextToken();
		lastname = st.nextToken();
	}

	@Transient
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Transient
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Person [" + id + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}
}