/*
 * Users.java
 * 
 * Created on Jul 1, 2007, 7:11:48 PM
 * 
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.abbh.authenticator.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author intesar
 */
@Entity
@Table(name = "users")
@NamedQueries({@NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username"), @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"), @NamedQuery(name = "Users.findByPasswordStrength", query = "SELECT u FROM Users u WHERE u.passwordStrength = :passwordStrength"), @NamedQuery(name = "Users.findByEncryptionKey", query = "SELECT u FROM Users u WHERE u.encryptionKey = :encryptionKey"), @NamedQuery(name = "Users.findByIsEncrypted", query = "SELECT u FROM Users u WHERE u.isEncrypted = :isEncrypted"), @NamedQuery(name = "Users.findByPasswordExpirationDate", query = "SELECT u FROM Users u WHERE u.passwordExpirationDate = :passwordExpirationDate"), @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"), @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"), @NamedQuery(name = "Users.findByMiddleName", query = "SELECT u FROM Users u WHERE u.middleName = :middleName"), @NamedQuery(name = "Users.findBySecondaryEmail", query = "SELECT u FROM Users u WHERE u.secondaryEmail = :secondaryEmail"), @NamedQuery(name = "Users.findByTitle", query = "SELECT u FROM Users u WHERE u.title = :title"), @NamedQuery(name = "Users.findByCompany", query = "SELECT u FROM Users u WHERE u.company = :company"), @NamedQuery(name = "Users.findByLastLoginIp", query = "SELECT u FROM Users u WHERE u.lastLoginIp = :lastLoginIp"), @NamedQuery(name = "Users.findByEnabled", query = "SELECT u FROM Users u WHERE u.enabled = :enabled"), @NamedQuery(name = "Users.findByLockReason", query = "SELECT u FROM Users u WHERE u.lockReason = :lockReason"), @NamedQuery(name = "Users.findBySecretQuestion", query = "SELECT u FROM Users u WHERE u.secretQuestion = :secretQuestion"), @NamedQuery(name = "Users.findBySecretAnswer", query = "SELECT u FROM Users u WHERE u.secretAnswer = :secretAnswer"), @NamedQuery(name = "Users.findByCreationDate", query = "SELECT u FROM Users u WHERE u.creationDate = :creationDate"), @NamedQuery(name = "Users.findByLastModifiedDate", query = "SELECT u FROM Users u WHERE u.lastModifiedDate = :lastModifiedDate"), @NamedQuery(name = "Users.findByIsDeleted", query = "SELECT u FROM Users u WHERE u.isDeleted = :isDeleted")})
public class Users implements Serializable {

    @Id
    @Column(name = " username", nullable = false)
    private String username;

    @Column(name = " password", nullable = false)
    private String password;

    @Column(name = "password_strength")
    private String passwordStrength;

    @Column(name = "encryption_key")
    private String encryptionKey;

    @Column(name = "is_encrypted")
    private Boolean isEncrypted;

    @Column(name = "password_expiration_date")
    @Temporal(TemporalType.DATE)
    private Date passwordExpirationDate;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "secondary_email")
    private String secondaryEmail;

    @Column(name = "title")
    private String title;

    @Column(name = "company")
    private String company;

    @Lob
    @Column(name = "summary")
    private String summary;

    @Column(name = "last_login_ip")
    private String lastLoginIp;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "lock_reason")
    private String lockReason;

    @Column(name = "secret_question")
    private String secretQuestion;

    @Column(name = "secret_answer")
    private String secretAnswer;

    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Column(name = "last_modified_date")
    @Temporal(TemporalType.DATE)
    private Date lastModifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserRoles> userRolesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserAddress> userAddressCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserCommunity> userCommunityCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<UserPhone> userPhoneCollection;

    public Users() {
    }

    public Users(String username) {
        this.username = username;
    }

    public Users(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordStrength() {
        return passwordStrength;
    }

    public void setPasswordStrength(String passwordStrength) {
        this.passwordStrength = passwordStrength;
    }

    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public Boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(Boolean isEncrypted) {
        this.isEncrypted = isEncrypted;
    }

    public Date getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    public void setPasswordExpirationDate(Date passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getLockReason() {
        return lockReason;
    }

    public void setLockReason(String lockReason) {
        this.lockReason = lockReason;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Collection<UserRoles> getUserRolesCollection() {
        return userRolesCollection;
    }

    public void setUserRolesCollection(Collection<UserRoles> userRolesCollection) {
        this.userRolesCollection = userRolesCollection;
    }

    public Collection<UserAddress> getUserAddressCollection() {
        return userAddressCollection;
    }

    public void setUserAddressCollection(Collection<UserAddress> userAddressCollection) {
        this.userAddressCollection = userAddressCollection;
    }

    public Collection<UserCommunity> getUserCommunityCollection() {
        return userCommunityCollection;
    }

    public void setUserCommunityCollection(Collection<UserCommunity> userCommunityCollection) {
        this.userCommunityCollection = userCommunityCollection;
    }

    public Collection<UserPhone> getUserPhoneCollection() {
        return userPhoneCollection;
    }

    public void setUserPhoneCollection(Collection<UserPhone> userPhoneCollection) {
        this.userPhoneCollection = userPhoneCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if (this.username != other.username && (this.username == null || !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.abbh.authenticator.entity.Users[username=" + username + "]";
    }

}
