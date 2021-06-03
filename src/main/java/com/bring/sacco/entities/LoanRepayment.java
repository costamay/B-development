package com.bring.sacco.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanRepayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanRepaymentId;
    private Long loanTypeId;
    private Long memberId;
    private Long loanApplicationId;
    private Date repaymentDate;
    private Long loanAmount;
    private Long amountPayed;
    private Long loanBalance;


}
