package com.api_vendas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_vendas.Entity.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

}
