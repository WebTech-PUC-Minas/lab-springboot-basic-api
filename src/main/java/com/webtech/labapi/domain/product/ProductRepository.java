package com.webtech.labapi.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//repository - conexão, consultas no banco de dados

//interface - contrato com declarações
//JpaRepository<Product, String>   <entidade que está manipulando, Tipo da primarykey da entidade>
//Jpa - *manipulação* de dados do banco. Não cria tabelas.
public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
}

//por enquanto utilizaremos os métodos padrões já existentes
