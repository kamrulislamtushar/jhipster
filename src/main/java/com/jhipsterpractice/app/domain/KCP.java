package com.jhipsterpractice.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A KCP.
 */
@Entity
@DiscriminatorValue("KCP")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class KCP extends User {

//    private static final long serialVersionUID = 1L;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "login")
//    private String login;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "first_name")
//    private String firstName;
//
//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "activated")
//    private Boolean activated;
//
//    @Column(name = "lang_key")
//    private String langKey;
//
//    @Column(name = "image_url")
//    private String imageUrl;
//
//    @Column(name = "activation_key")
//    private String activationKey;
//
//    @Column(name = "reset_key")
//    private String resetKey;
//
//    @Column(name = "reset_date")
//    private LocalDate resetDate;

    @Column(name = "designation")
    private String designation;

    @Column(name = "nid")
    private String nid;

    @Column(name = "company")
    private String company;

    // jhipster-needle-entity-add-field - JHipster will add fields here
//    public Long getId() {
//        return this.id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public KCP login(String login) {
//        this.login = login;
//        return this;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public KCP password(String password) {
//        this.password = password;
//        return this;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public KCP firstName(String firstName) {
//        this.firstName = firstName;
//        return this;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public KCP lastName(String lastName) {
//        this.lastName = lastName;
//        return this;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public KCP email(String email) {
//        this.email = email;
//        return this;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Boolean isActivated() {
//        return activated;
//    }
//
//    public KCP activated(Boolean activated) {
//        this.activated = activated;
//        return this;
//    }
//
//    public void setActivated(Boolean activated) {
//        this.activated = activated;
//    }
//
//    public String getLangKey() {
//        return langKey;
//    }
//
//    public KCP langKey(String langKey) {
//        this.langKey = langKey;
//        return this;
//    }
//
//    public void setLangKey(String langKey) {
//        this.langKey = langKey;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public KCP imageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//        return this;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getActivationKey() {
//        return activationKey;
//    }
//
//    public KCP activationKey(String activationKey) {
//        this.activationKey = activationKey;
//        return this;
//    }
//
//    public void setActivationKey(String activationKey) {
//        this.activationKey = activationKey;
//    }
//
//    public String getResetKey() {
//        return resetKey;
//    }
//
//    public KCP resetKey(String resetKey) {
//        this.resetKey = resetKey;
//        return this;
//    }
//
//    public void setResetKey(String resetKey) {
//        this.resetKey = resetKey;
//    }
//
//    public LocalDate getResetDate() {
//        return resetDate;
//    }
//
//    public KCP resetDate(LocalDate resetDate) {
//        this.resetDate = resetDate;
//        return this;
//    }
//
//    public void setResetDate(LocalDate resetDate) {
//        this.resetDate = resetDate;
//    }

    public String getDesignation() {
        return designation;
    }

    public KCP designation(String designation) {
        this.designation = designation;
        return this;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getNid() {
        return nid;
    }

    public KCP nid(String nid) {
        this.nid = nid;
        return this;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getCompany() {
        return company;
    }

    public KCP company(String company) {
        this.company = company;
        return this;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (!(o instanceof KCP)) {
//            return false;
//        }
//        return id != null && id.equals(((KCP) o).id);
//    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "KCP{" +
            "id=" + getId() +
            ", login='" + getLogin() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
//            ", activated='" + isActivated() + "'" +
            ", langKey='" + getLangKey() + "'" +
            ", imageUrl='" + getImageUrl() + "'" +
            ", activationKey='" + getActivationKey() + "'" +
            ", resetKey='" + getResetKey() + "'" +
            ", resetDate='" + getResetDate() + "'" +
            ", designation='" + getDesignation() + "'" +
            ", nid='" + getNid() + "'" +
            ", company='" + getCompany() + "'" +
            "}";
    }
}
