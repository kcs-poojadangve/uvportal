package org.uvportal.model;

public class Profile {

	private String SAPNumber;
	private String FirstName;
	private String Surname;
	private String IDNumber;
	private boolean IsRetired;
	private int YearsOfService;
	private String RetirementDate;
	private ResidentialAddress ResidentialAddress;
	private PostalAddress PostalAddress;
	private String EmailAddress;
	private String AlternativeEmailAddress;
	private String ContactNumber;
	private String AlternativeContactNumber;
	private int PreferedCommunicationMethod;

	public String getSAPNumber() {
		return SAPNumber;
	}

	public void setSAPNumber(String sAPNumber) {
		SAPNumber = sAPNumber;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public Object isIsRetired() {
		return IsRetired;
	}

	public void setIsRetired(boolean isRetired) {
		IsRetired = isRetired;
	}

	public int getYearsOfService() {
		return YearsOfService;
	}

	public void setYearsOfService(int yearsOfService) {
		YearsOfService = yearsOfService;
	}

	public String getRetirementDate() {
		return RetirementDate;
	}

	public void setRetirementDate(String retirementDate) {
		RetirementDate = retirementDate;
	}

	public ResidentialAddress getResidentialAddress() {
		return ResidentialAddress;
	}

	public void setResidentialAddress(ResidentialAddress residentialAddress) {
		ResidentialAddress = residentialAddress;
	}

	public PostalAddress getPostalAddress() {
		return PostalAddress;
	}

	public void setPostalAddress(PostalAddress postalAddress) {
		PostalAddress = postalAddress;
	}

	public String getEmailAddress() {
		return EmailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	public String getAlternativeEmailAddress() {
		return AlternativeEmailAddress;
	}

	public void setAlternativeEmailAddress(String alternativeEmailAddress) {
		AlternativeEmailAddress = alternativeEmailAddress;
	}

	public String getContactNumber() {
		return ContactNumber;
	}

	public void setContactNumber(String contactNumber) {
		ContactNumber = contactNumber;
	}

	public String getAlternativeContactNumber() {
		return AlternativeContactNumber;
	}

	public void setAlternativeContactNumber(String alternativeContactNumber) {
		AlternativeContactNumber = alternativeContactNumber;
	}

	public int getPreferedCommunicationMethod() {
		return PreferedCommunicationMethod;
	}

	public void setPreferedCommunicationMethod(int preferedCommunicationMethod) {
		PreferedCommunicationMethod = preferedCommunicationMethod;
	}

}
