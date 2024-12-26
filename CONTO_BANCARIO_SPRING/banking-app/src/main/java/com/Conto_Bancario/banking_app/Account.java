package com.Conto_Bancario.banking_app;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double saldo;
}
