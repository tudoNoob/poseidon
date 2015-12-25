package com.poseidon.dao;

import com.poseidon.model.Paciente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier()
public interface PacienteDAO extends CrudRepository<Paciente, Long> {
public Paciente findByUsername(String username);

public interface PacienteDao {
    }
}
