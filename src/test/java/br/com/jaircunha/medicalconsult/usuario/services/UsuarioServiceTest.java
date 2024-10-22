package br.com.jaircunha.medicalconsult.usuario.services;

import br.com.jaircunha.medicalconsult.usuario.domain.Usuario;
import br.com.jaircunha.medicalconsult.usuario.repositories.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {
    @InjectMocks // Usado para separa a classe que se deseja fazer os testes
    private UsuarioService usuarioService;

    @Mock // Usado para que não seja realmente salvo os dados que foram usados aqui
    private UsuarioRepository usuarioRepository;

    @Test
    void cadastrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario("Jair");

        // Config do comportamento do MOCK
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

        // Exec do metodo a ser testado
        var result = usuarioService.cadastrarUsuario(usuario);

        // Validation
        assertNotNull(usuario);
        assertEquals("Arroba", result.getNomeUsuario());

        verify(usuarioRepository, times(1)).save(usuario);
    }

    @Test
    void listarUsuarios(){
        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Aarys");
        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Edgar");

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);

        // Config do comportamento do MOCK
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // Exec do metodo a ser testado
        var resulta = usuarioService.listarUsuarios();

        // Validation
        assertAll(
                () -> assertNotNull(resulta),
                () -> assertEquals(2, resulta.size()),
                () -> assertEquals("Diego", resulta.get(0).getNomeUsuario()),
                () -> assertEquals("Viego", resulta.get(1).getNomeUsuario())
        );
    }

    // Testes semi-funcionando

//    @Test
//    void buscarUsuario(){
//        Usuario user = new Usuario();
//        user.setNomeUsuario("Luis");
//
//        // Config do comportamento do MOCK
//        when(usuarioRepository.findById(user.getIdUsuario())).thenReturn(user);
//
//        // Exec do metodo a ser testado
//        var resultad = usuarioService.buscarUsuario(user.getIdUsuario());
//
//        // Validation
//        assertAll(
//                () -> assertNotNull(resultad),
//                () -> assertEquals("Jair", resultad.getNomeUsuario())
//        );
//
//    }

//    @Test
//    void deletarUsuario(){
//        Usuario usuar = new Usuario();
//        usuar.setNomeUsuario("Fabio");
//
//        // Config do comportamento do MOCK
//        when(usuarioRepository.deleteById(usuar.getIdUsuario())).thenReturn(usuar);
//
//        // Exec do metodo a ser testado
//        var resul = usuarioService.deletarUsuario(usuar.getIdUsuario());
//
//        // Validation
//        assertAll(
//                () -> assertNotNull(resul),
//                () -> assertEquals("Diego", resul.getNomeUsuario())
//        );
//
//    }
}
