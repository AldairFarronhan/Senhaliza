package GRUPO1.TP.repositories;

import GRUPO1.TP.entities.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    @Query("SELECT e FROM Exercise e WHERE e.lesson.id = :lessonId")
    List<Exercise> findAllByLessonId(@Param("lessonId") Long lessonId);
}
