package com.bring.sacco.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShareCapital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shareCapitalId;
    private Long memberId;
    private Long accountId;
    private Long amountReceived;
    private Date dateCreated;

}
