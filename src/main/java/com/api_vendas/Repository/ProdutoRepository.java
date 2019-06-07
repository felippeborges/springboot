package com.api_vendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_vendas.Entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{

}
