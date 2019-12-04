package com.intelizest.projectiz.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="country")
public class Country implements Serializable {
    @Id
    @Column(name = "code")
    private String code;

    @Column(name="description")
    private String description;

}
