package com.bring.sacco.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MemberStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberStatusId;
    private String name;
}
