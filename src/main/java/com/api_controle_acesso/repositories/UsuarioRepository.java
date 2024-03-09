package com.api_controle_acesso.repositories;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.api_controle_acesso.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
    @Query("""
            select u from Usuario u
            where u.cpf = :cpf
            """)
    Optional<Boolean> verificarCpfExistente(String cpf);
}
