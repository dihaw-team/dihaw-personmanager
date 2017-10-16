package com.demo.personmanager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.demo.personmanager.IConstante;

/**
 * @author Wahid Gazzah
 * @since 24/03/2016
 *
 */

@Entity
@Table(name = IConstante.TABLE_USER)
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 8569950194372525609L;

	@Id
	/*@SequenceGenerator(name = "CONTROLE_ID_GENERATOR", sequenceName = IConstante.SEQUENCE_USER, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTROLE_ID_GENERATOR")*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@Column(name = "ZIP_CODE")
	private String zipCode;
	
	@Column(name = "STATE")
	private String state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
}
