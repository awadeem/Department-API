package com.dailycodebuffer.Spring.boot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;


@Entity //it interact dataBase using JPA
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Department {

    @Id // make the primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // generate the key
    private Long departmentId;
    @NotBlank(message = "ADD DEPARTMENT NAME")
//    @Length(max=5, min=1)
//    @Size(max=2,min=1)
//    @Email
//    @Positive
//    @Negative
//    @PositiveOrZero
//    @NegativeOrZero
//    @Future
//    @FutureOrPresent
//    @Past
//    @PastOrPresent
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
