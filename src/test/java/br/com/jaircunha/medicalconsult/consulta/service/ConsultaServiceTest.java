package br.com.jaircunha.medicalconsult.consulta.service;

import br.com.jaircunha.medicalconsult.consulta.domain.Consulta;
import br.com.jaircunha.medicalconsult.consulta.repository.ConsultaRepository;
import br.com.jaircunha.medicalconsult.usuario.domain.Usuario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultaServiceTest {
    @InjectMocks
    private ConsultaService consultaService;

    @Mock
    private ConsultaRepository consultaRepository;

    @Test
    void cadastrarConsulta(){
        Consulta consulta = new Consulta();
        consulta.setProfissional("Dr.Lionel");

        // Config do comportamento do MOCK
        when(consultaRepository.save(any(Consulta.class))).thenReturn(consulta);

        // Exec do metodo a ser testado
        var resultado = consultaService.cadastrarConsulta(consulta);

        // Validation
        assertAll(
                () -> assertNotNull(resultado),
                () -> assertEquals("Alessandro", resultado.getProfissional())
        );

    }
}