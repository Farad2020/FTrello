package com.faraby_lab.task3.restapivue.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "card_tasks_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    Cards card;
    @Column(name = "taskText")
    String taskText;
    @Column(name = "addedDate")
    Date addedDate;
    @Column(name = "done")
    boolean done;

}
