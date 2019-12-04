package com.intelizest.projectiz.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="company")
public class Company {
    @Id
    @Column(name = "company_code")
    private String companyCode;
    @Column(name = "description")
    private String companyName;
    @Column(name = "address1")
    private String address1;
    @Column(name = "address2")
    private String address2;
    @Column(name = "location")
    private String location;
    @Column(name = "country")
    private String country;
    @Column(name = "gst_reg_no")
    private String gstRegNo;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    @Column(name = "last_modified_date")
    private Date lastModifiedDate;



}
