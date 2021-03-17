package com.faraby_lab.task3.restapivue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "cards_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;


    @Column(name = "name")
    String name;

    @Column(name = "addedDate")
    Date addedDate;
}
