package org.uvportal.model;

public class ResidentialAddress {

	private int AddressID;
	private String IDNumber;
	private String SAPNumber;
	private String AddressLine1;
	private String AddressLine2;
	private String Suburb;
	private String City;
	private String Country;
	private String PostalCode;
	private int AddressTypeID;

	public int getAddressID() {
		return AddressID;
	}

	public void setAddressID(int addressID) {
		AddressID = addressID;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getSAPNumber() {
		return SAPNumber;
	}

	public void setSAPNumber(String sAPNumber) {
		SAPNumber = sAPNumber;
	}

	public String getAddressLine1() {
		return AddressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		AddressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return AddressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		AddressLine2 = addressLine2;
	}

	public String getSuburb() {
		return Suburb;
	}

	public void setSuburb(String suburb) {
		Suburb = suburb;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostalCode() {
		return PostalCode;
	}

	public void setPostalCode(String postalCode) {
		PostalCode = postalCode;
	}

	public int getAddressTypeID() {
		return AddressTypeID;
	}

	public void setAddressTypeID(int addressTypeID) {
		AddressTypeID = addressTypeID;
	}

}
