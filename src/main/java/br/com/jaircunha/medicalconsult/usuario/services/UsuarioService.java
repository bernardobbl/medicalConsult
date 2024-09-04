package br.com.jaircunha.medicalconsult.usuario.services;

import br.com.jaircunha.medicalconsult.usuario.domain.Usuario;
import br.com.jaircunha.medicalconsult.usuario.repositories.UsuarioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado: ", id));
    }

    public Usuario deletarUsuario(Long id){
        usuarioRepository.deleteById(id);
        return null;
    }

    public Usuario atualizarUsuario(Long id, Usuario usuario){
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isEmpty()){
            throw new RuntimeException("Id de usuário não encontrado");
        }

        Usuario user = optionalUsuario.get();

        user.setNomeUsuario(usuario.getNomeUsuario());
        user.setEmail(usuario.getEmail());
        user.setDataNascimento(usuario.getDataNascimento());
        user.setTelefone(usuario.getTelefone());

        return usuarioRepository.save(user);
    }
}
