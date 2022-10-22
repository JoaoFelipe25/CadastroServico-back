package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Servico;



public interface ServicoRepository extends JpaRepository<Servico, Long>{

    @Query("select s from Servico s where (s.valorPago is null or s.valorPago = 0) and s.status!='cancelado'")
    List<Servico> buscarServicosPagamentoPendente();

    @Query("select s from Servico s where s.status = 'cancelado'")
    List<Servico> buscarServicosCancelados();
    
}
