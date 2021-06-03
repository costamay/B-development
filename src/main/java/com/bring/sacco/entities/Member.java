package com.bring.sacco.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String fname;
    private String lname;
    private String email;
    private String photo;
    private String krapin;
    private Long nationalId;
    private Long phonenumber;
    private Long memberStatusId;

    @CreationTimestamp
    private Date createdAt;
    @CreationTimestamp
    private Date updatedAt;



}
