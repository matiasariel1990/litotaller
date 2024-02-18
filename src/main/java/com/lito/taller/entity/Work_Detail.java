package com.lito.taller.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Work_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date date;

    @Column(nullable = false, length = 500)
    String summary;

    @Column(nullable = false)
    float amount;

    @Column(nullable = false)
    boolean debit;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = true,
            updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_DETAIL_CATEGORY_ID"))
    Category category;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="work_id", nullable = false,
            updatable = false, foreignKey = @ForeignKey(name = "FK_WORK_DETAIL_WORK_ID"))
    Work work;

}
