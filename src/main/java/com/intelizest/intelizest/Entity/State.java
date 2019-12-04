package com.intelizest.intelizest.Entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name="state")
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="code",nullable = false)
    private String code;


    @Column(name="description")
    private String description;

    @ManyToOne
    @JoinColumn(name="country_code")
    private Country country_code;




}
