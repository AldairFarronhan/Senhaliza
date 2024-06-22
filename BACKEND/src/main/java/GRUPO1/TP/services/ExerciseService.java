package GRUPO1.TP.services;
import GRUPO1.TP.dto.DTOExercise;
import GRUPO1.TP.entities.Exercise;
import java.util.List;

public interface ExerciseService {
    List<Exercise> listAll();
    Exercise findById(Long id);
    Exercise save(Exercise exercise);
    void delete(Long id);

    List<Exercise> findAllByLessonId(Long lessonId);

    // Métodos adicionales
    DTOExercise getExerciseSummary(Long exerciseId);
    void validateExercise(Long studentId, Long exerciseId, boolean correct);
    Long getNextExerciseId(Long studentId, Long lessonId);
}
