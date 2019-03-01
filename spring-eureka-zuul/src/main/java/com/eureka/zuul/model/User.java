package com.eureka.zuul.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.eureka.zuul.utils.Utils;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "email" }) })
public class User {

    public static final String ERR_INVALID_PASSWORD = "Password can not be null or empty";
    public static final String ERR_INVALID_NAME = "Name can not be null or empty";
    public static final String ERR_INVALID_LAST_NAME = "Last name can not be null or empty";
    public static final String ERR_INVALID_EMAIL = "Email can not be null or empty";
    public static final String ERR_INVALID_ROLES = "Roles can not be null or empty";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Email
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @SuppressWarnings("unused")
    private User() {
    }

    public User(String name, String lastName, String email, String password) {
        setName(name);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
    }

    public User(String name, String lastName, String email, String password,
            Set<Role> roles) {
        setName(name);
        setLastName(lastName);
        setEmail(email);
        setPassword(password);
        setRoles(roles);
    }

    public Long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        Utils.assertArgumentNotEmptyOrNotNull(lastName, ERR_INVALID_LAST_NAME);
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Utils.assertArgumentNotEmptyOrNotNull(name, ERR_INVALID_NAME);
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Utils.assertArgumentNotEmptyOrNotNull(email, ERR_INVALID_EMAIL);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Utils.assertArgumentNotEmptyOrNotNull(password, ERR_INVALID_PASSWORD);
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        Utils.assertArgumentNotEmptyOrNotNull(roles, ERR_INVALID_ROLES);
        this.roles = roles;
    }

    public Set<Role> roles() {

        if (roles == null)
            this.roles = new HashSet<>();

        return Collections.unmodifiableSet(roles);
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
