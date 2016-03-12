
package com.veridu.sdk;

import java.util.ArrayList;
import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class List {

    private java.util.List<FirstName> firstName = new ArrayList<FirstName>();
    private java.util.List<LastName> lastName = new ArrayList<LastName>();
    private java.util.List<ProfilePicture> profilePicture = new ArrayList<ProfilePicture>();
    private java.util.List<MismatchedProfile> MismatchedProfiles = new ArrayList<MismatchedProfile>();
    private java.util.List<Gender> gender = new ArrayList<Gender>();
    private java.util.List<Overall> overall = new ArrayList<Overall>();
    private java.util.List<com.veridu.sdk.Student> Student = new ArrayList<com.veridu.sdk.Student>();

    /**
     * 
     * @return
     *     The firstName
     */
    public java.util.List<FirstName> getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The firstName
     */
    public void setFirstName(java.util.List<FirstName> firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public java.util.List<LastName> getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The lastName
     */
    public void setLastName(java.util.List<LastName> lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The profilePicture
     */
    public java.util.List<ProfilePicture> getProfilePicture() {
        return profilePicture;
    }

    /**
     * 
     * @param profilePicture
     *     The profilePicture
     */
    public void setProfilePicture(java.util.List<ProfilePicture> profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * 
     * @return
     *     The MismatchedProfiles
     */
    public java.util.List<MismatchedProfile> getMismatchedProfiles() {
        return MismatchedProfiles;
    }

    /**
     * 
     * @param MismatchedProfiles
     *     The Mismatched Profiles
     */
    public void setMismatchedProfiles(java.util.List<MismatchedProfile> MismatchedProfiles) {
        this.MismatchedProfiles = MismatchedProfiles;
    }

    /**
     * 
     * @return
     *     The gender
     */
    public java.util.List<Gender> getGender() {
        return gender;
    }

    /**
     * 
     * @param gender
     *     The gender
     */
    public void setGender(java.util.List<Gender> gender) {
        this.gender = gender;
    }

    /**
     * 
     * @return
     *     The overall
     */
    public java.util.List<Overall> getOverall() {
        return overall;
    }

    /**
     * 
     * @param overall
     *     The overall
     */
    public void setOverall(java.util.List<Overall> overall) {
        this.overall = overall;
    }

    /**
     * 
     * @return
     *     The Student
     */
    public java.util.List<com.veridu.sdk.Student> getStudent() {
        return Student;
    }

    /**
     * 
     * @param Student
     *     The Student
     */
    public void setStudent(java.util.List<com.veridu.sdk.Student> Student) {
        this.Student = Student;
    }

}
