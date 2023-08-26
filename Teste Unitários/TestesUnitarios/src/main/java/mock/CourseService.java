package mock;

import java.util.List;

public interface CourseService {

    public List<String> listarCursos(String estudante);

    public List<String> doSomething(String student);
    public void deleteCourse(String curso);

}
