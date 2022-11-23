package com.example.skytel_mobileapp.Models;

public class CustomerQuery {

    private String Name;
    private String ProblemDescriptionQuestion;
    private String ContactDetails;
    private String Other;

    public CustomerQuery(String customerName, String customerQuery, String customerContactDetails, String customerOther) {
        this.Name = customerName;
        this.ProblemDescriptionQuestion = customerQuery;
        this.ContactDetails = customerContactDetails;
        this.Other = customerOther;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getProblemDescriptionQuestion() {
        return ProblemDescriptionQuestion;
    }

    public void setProblemDescriptionQuestion(String problemDescriptionQuestion) {
        this.ProblemDescriptionQuestion = problemDescriptionQuestion;
    }

    public String getContactDetails() {
        return ContactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.ContactDetails = contactDetails;
    }

    public String getOther() {
        return Other;
    }

    public void setOther(String other) {
        this.Other = other;
    }
}
