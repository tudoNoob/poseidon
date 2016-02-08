package com.poseidon.dao;

import com.poseidon.model.Consulta;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
@Qualifier()
public interface ConsultaDao extends CrudRepository<Consulta, Integer> {
    
}
