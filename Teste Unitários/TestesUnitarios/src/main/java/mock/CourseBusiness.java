package mock;

import java.util.ArrayList;
import java.util.List;

public class CourseBusiness {

    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> listarCursoEstudante(String estudante){

        ArrayList<String> filtrarCursos = new ArrayList<>();
        if ("Foo Bar".equals(estudante)) return  filtrarCursos;
        var todosCursos = service.listarCursos(estudante);

        for (String curso:todosCursos
             ) {
             if (curso.contains("Spring")){
                 filtrarCursos.add(curso);
             }
        }

        return  filtrarCursos;

    }

    public void deletarCursoEstudante(String estudante){

        var todosCursos = service.listarCursos(estudante);

        for (String curso:todosCursos
        ) {
            if (!curso.contains("Spring")){
              service.deleteCourse(curso);
            }
        }

    }

}
