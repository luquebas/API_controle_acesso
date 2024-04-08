package com.api_controle_acesso.repositories;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api_controle_acesso.models.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, UUID> {

    
} 
