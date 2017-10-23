package com.demo.personmanager.dto;

/**
 * @author Wahid Gazzah
 * @since 30/06/2016
 *
 */
public class SearchUsersElementsResponseDTO implements Comparable<SearchUsersElementsResponseDTO>{

	private Long id;
	private String firstName;
	private String lastName;
	private String adresse;
	private String email;
	private String telephone;
	
	public int compareTo(SearchUsersElementsResponseDTO o) {
		SearchUsersElementsResponseDTO element= (SearchUsersElementsResponseDTO)o;
		return (element.getId().compareTo(id));
	}
	
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
	
}
