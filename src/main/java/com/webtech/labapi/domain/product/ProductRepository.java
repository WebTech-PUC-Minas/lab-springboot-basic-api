package com.webtech.labapi.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;

//repository - conexão, consultas no banco de dados

//interface - contrato com declarações
//JpaRepository<Product, String>   <entidade que está manipulando, Tipo da primarykey da entidade>
public interface ProductRepository extends JpaRepository<Product, String> {
}

//por enquanto utilizaremos os métodos padrões já existentes
