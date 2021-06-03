package com.bring.sacco.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanApplicationId;
    private Long loanTypeId;
    private Long accountId;
    private Long loanStatusId;
    private Date applicationDate;
    private Long applicationAmount;
    private Integer approvedAmount;
    private Date approvalDate;
    private int minimumAmountPayed;
    private String repaymentPeriod;
    private Long balance;

    @CreationTimestamp
    private Date createdAt;
    @CreationTimestamp
    private Date updatedAt;


}
