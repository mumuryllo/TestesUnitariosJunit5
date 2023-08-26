package mocks;

import mock.CourseBusiness;
import mock.CourseService;
import mock.CourseServiceStub;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseBussinessMockTest {

@Mock
CourseService mockService;
@InjectMocks
CourseBusiness business;
List<String> cursos;

// Com essas annotation é a mesma coisa q eu instanciar em baixo

    @BeforeEach
    void iniciando(){
//      mockService = mock(CourseService.class);
//      business = new CourseBusiness(mockService);
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


        when(mockService.listarCursos("Leandro"))
                .thenReturn(cursos);

        var filtrarCursos = business.listarCursoEstudante("Leandro");
        assertEquals(4, filtrarCursos.size());
    }
}
