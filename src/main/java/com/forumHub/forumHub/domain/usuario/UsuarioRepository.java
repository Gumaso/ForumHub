package com.forumHub.forumHub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioBD, Long> {
    UserDetails findByLogin(String login);
}
