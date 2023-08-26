package mocks;

import mock.CourseBusiness;
import mock.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseBussinessMockTestBDD {
    @Mock
    CourseService mockService;

@InjectMocks
CourseBusiness business;
List<String> cursos;

@Captor
ArgumentCaptor<String> argumentCaptor;


    @BeforeEach
    void iniciando(){

      cursos = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void CursoSpringTest(){
        
        given(mockService.listarCursos("Leandro"))
                .willReturn(cursos);

        var filtrarCursos = business.listarCursoEstudante("Leandro");
        assertThat(filtrarCursos.size(),is(4));
    }

    @Test
    void deleteCursoEstudante(){
        // verify serve para testar métodos void
        // posso fazer mais de uma verificação

        given(mockService.listarCursos("Leandro"))
                .willReturn(cursos);

        business.deletarCursoEstudante("Leandro");

        // vai chamar pelo menos uma vez e se executar o delete de novo da ruim
        verify(mockService,times(1)).deleteCourse("Agile Desmistificado com Scrum, XP, Kanban e Trello");
        verify(mockService).deleteCourse("Spotify Engineering Culture Desmistificado");
        verify(mockService,never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");

    }

    @Test
    void deleteCursoEstudanteArgumentos(){

        given(mockService.listarCursos("Leandro"))
                .willReturn(cursos);

        business.deletarCursoEstudante("Leandro");

        // outra forma de verify
        then(mockService).should(times(7))
                .deleteCourse(argumentCaptor.capture());

        // 7 argumentos não contem Spring no nome e são deletáveis
        assertThat(argumentCaptor.getAllValues().size(),is(7));

    }
}
