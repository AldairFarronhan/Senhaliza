package GRUPO1.TP;

import GRUPO1.TP.entities.*;
import GRUPO1.TP.repositories.*;
import GRUPO1.TP.repositories.ExerciseRepository;
import GRUPO1.TP.repositories.LevelRepository;
import GRUPO1.TP.repositories.StudentRepository;
import GRUPO1.TP.repositories.PlanRepository;
import GRUPO1.TP.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TPApplication {

    public static void main(String[] args) {
        SpringApplication.run(TPApplication.class, args);
    }
    @Bean
    public CommandLineRunner mappingDemo(
            UserRepository userRepository,
            LevelRepository levelRepository,
            StudentRepository studentRepository,
            PlanRepository planRepository,
            ExerciseRepository exerciseRepository,
            ExerciseImageRepository exerciseImageRepository,
            LessonRepository lessonRepository,
            LessonStudentRepository lessonStudentRepository,
            AuthorityRepository authorityRepository,
            ImageRepository imageRepository,
            StudentPlanRepository studentPlanRepository,
            StudentExerciseRepository studentExerciseRepository
    ){
        return args -> {
            authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
            authorityRepository.save(new Authority(AuthorityName.ROLE_STUDENT));
            authorityRepository.save(new Authority(AuthorityName.ROLE_PRINCIPAL));

            authorityRepository.saveAll(
                    List.of(
                            new Authority(AuthorityName.READ),
                            new Authority(AuthorityName.WRITE)
                    )
            );
            //REGISTROS



            //USERS
            User user1 =  userRepository.save(new User(Long.valueOf(0),
                            "Aldair", new BCryptPasswordEncoder().encode("123"), true,new Date(),null,
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN)
                            )
                    )
            );
            User user2 =  userRepository.save(new User(Long.valueOf(0),
                            "Salvador", new BCryptPasswordEncoder().encode("123"), true,new Date(),null,
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN)
                            )
                    )
            );
            User user3 =  userRepository.save(new User(Long.valueOf(0),
                            "Niels", new BCryptPasswordEncoder().encode("123"), true,new Date(),null,
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN)
                            )
                    )
            );
            User user4 =  userRepository.save(new User(Long.valueOf(0),
                            "Nemberk", new BCryptPasswordEncoder().encode("123"), true,new Date(),null,
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_ADMIN)
                            )
                    )
            );
            User user5 =  userRepository.save(new User(Long.valueOf(0),
                            "Keo", new BCryptPasswordEncoder().encode("123"), true,new Date(),null,
                            List.of(
                                    authorityRepository.findByName(AuthorityName.ROLE_STUDENT)
                            )
                    )
            );



            Level level1 =  levelRepository.save(new Level(Long.valueOf(0), "Conocedor", "Nivel Conocedor",null));
            Level level2 =  levelRepository.save(new Level(Long.valueOf(0), "Entusiasta", "Nivel Entusiasta",null));
            Level level3 =  levelRepository.save(new Level(Long.valueOf(0), "Principiante", "Nivel Principiante",null));
            Level level4 =  levelRepository.save(new Level(Long.valueOf(0), "Avanzado", "Nivel Avanzado",null));


            Plan plan1 = planRepository.save(new Plan(Long.valueOf(0), "Fremium", "Plan fremium", 10.0, 180L,null ));
            Plan plan2 = planRepository.save(new Plan(Long.valueOf(0), "Estudiante", "Plan estudiante", 150.0, 40L, null ));
            Plan plan3 = planRepository.save(new Plan(Long.valueOf(0), "Premium", "Plan premium", 200.00, 40L,null));

            Lesson lesson1 = lessonRepository.save(new Lesson(Long.valueOf(0),"Animales", "Animales domesticos", null, null,null));
            Lesson lesson2 = lessonRepository.save(new Lesson(Long.valueOf(0), "Cuerpo", "Partes del cuerpo",null,null,null));
            Lesson lesson3 = lessonRepository.save(new Lesson(Long.valueOf(0), "Casa", "Objetos",null ,null ,null));


            Image image1 = imageRepository.save(new Image(Long.valueOf(0),"https://acortar.link/BcoxsV","Casa",null));
            Image image2 = imageRepository.save(new Image(Long.valueOf(0),"https://acortar.link/nSunlz","Boca",null));
            Image image3 = imageRepository.save(new Image(Long.valueOf(0),"https://acortar.link/EkBypY","Perro",null));
            Image image4 = imageRepository.save(new Image(Long.valueOf(0),"https://acortar.link/OvmFvE","Refresco",null));

            Student student1 = studentRepository.save(new Student(0L, "Aldair", "Aldair@upc.edu.pe", "995361755", "https://acortar.link/Fn7l8Y", level1, user1, null, null, null, null));
            Student student2 = studentRepository.save(new Student(0L, "Nemberk", "Nemberk@upc.edu.pe", "987654123", "https://acortar.link/4sUaLT", level2, user4, null, null, null, null));
            Student student3 = studentRepository.save(new Student(0L, "Keo", "keo@upc.edu.pe", "96581234", "https://acortar.link/vIMZMK", level3, user5, null, null, null, null));
            Student student4 = studentRepository.save(new Student(0L, "Salvador", "Salvador@upc.edu.pe", "956321587", "https://acortar.link/ngJ5IM", level4, user2, null, null, null, null));
            Student student5 = studentRepository.save(new Student(0L, "Niels", "Niels@upc.edu.pe", "965812561", "https://acortar.link/MYFB3O", level1, user3, null, null, null, null));

            StudentPlan studentPlan1 = studentPlanRepository.save(new StudentPlan(0L, new Date(), new Date(), student1, plan1));
            StudentPlan studentPlan2 = studentPlanRepository.save(new StudentPlan(0L, new Date(), new Date(), student2, plan2));
            StudentPlan studentPlan3 = studentPlanRepository.save(new StudentPlan(0L, new Date(), new Date(), student3, plan3));
            StudentPlan studentPlan4 = studentPlanRepository.save(new StudentPlan(0L, new Date(), new Date(), student4, plan2));
            StudentPlan studentPlan5 = studentPlanRepository.save(new StudentPlan(0L, new Date(), new Date(), student5, plan2));


            LessonStudent lessonStudent1=lessonStudentRepository.save(new LessonStudent(Long.valueOf(0), "En progreso",lesson2,student3));
            LessonStudent lessonStudent2=lessonStudentRepository.save(new LessonStudent(Long.valueOf(0), "Terminado",lesson1,student1));
            LessonStudent lessonStudent3=lessonStudentRepository.save(new LessonStudent(Long.valueOf(0), "Sin iniciar",lesson3,student1));



            Exercise exercise1=exerciseRepository.save(new Exercise(Long.valueOf(0), "Avanzado", "Abierta", "¿Q1?",
                    "sin comentarios",null,null,lesson1 ));
            Exercise exercise2=exerciseRepository.save(new Exercise(Long.valueOf(0), "Medio", "Directa", "¿Q3?",
                    "sin comentarios",null,null,lesson2 ));
            Exercise exercise3=exerciseRepository.save(new Exercise(Long.valueOf(0), "Basico", "Cerrada", "¿Q3?",
                    "sin comentarios",null,null,lesson3));

            ExerciseImage exerciseImage1=exerciseImageRepository.save(new ExerciseImage(Long.valueOf(0),"Casa",false,image1, exercise2));
            ExerciseImage exerciseImage2=exerciseImageRepository.save(new ExerciseImage(Long.valueOf(0),"Boca",false,image2, exercise1));
            ExerciseImage exerciseImage3=exerciseImageRepository.save(new ExerciseImage(Long.valueOf(0),"Perro",false,image3, exercise3));


            StudentExercise studentExercise1=studentExerciseRepository.save(new StudentExercise(Long.valueOf(0), new Date(), true ,exercise1, student1));
            StudentExercise studentExercise2=studentExerciseRepository.save(new StudentExercise(Long.valueOf(0), new Date(), true ,exercise2, student2));
            StudentExercise studentExercise3=studentExerciseRepository.save(new StudentExercise(Long.valueOf(0), new Date(), true ,exercise3, student1));
            StudentExercise studentExercise4=studentExerciseRepository.save(new StudentExercise(Long.valueOf(0), new Date(), true ,exercise1, student3));


//            System.out.println("\nLista Completa student");
//            List<Student> listFindAll = studentRepository.findAll();
//            for(Student s: listFindAll) {
//                System.out.println(s);
//            }

//            //Plan Repository
//            System.out.println("\nLista por Nombre y Menor precio");
//            List<Plan> planLowerPrice = planRepository.findByNameAndPrice(200.0);
//            for(Plan e: planLowerPrice) {
//                System.out.println(e);
//            }
////
//            System.out.println("\nLista por rango de precios");
//            List<Plan> planRangePrice = planRepository.findByPriceBetween(140.0, 150.0);
//            for(Plan e: planRangePrice) {
//                System.out.println(e);
//            }
//            //Exercise Repository
//            System.out.println("\nLista por nivel");
//            List<Exercise> levelList = exerciseRepository.findByLevel("Avanzado");
//            for(Exercise e: levelList) {
//                System.out.println(e);
//            }
//
//            System.out.println("\nLista por  lesson ");
//            List<Exercise> listLessonTheme = exerciseRepository.findByLesson("lesson");
//            for(Exercise e: listLessonTheme) {
//                System.out.println(e);
//            }
//
//            System.out.println("\nLista por  tipo de pregunta ");
//            List<Exercise> exercisetype_question = exerciseRepository.findByType_question("PreguntaFacil");
//            for(Exercise e:exercisetype_question){
//                System.out.println(e);
//            }System.out.println("\nLista  por tipo de pregunta");
//
//            //Level Repository
//            System.out.println("\nLista por  level ");
//            List<Level> listlevel = levelRepository.findByName("avanzado");
//            for(Level l: listlevel) {
//                System.out.println(l);
//            }
//
//            //Lesson Repository
//            System.out.println("\nLista por  thema ");
//            List<Lesson> listfindByTheme = lessonRepository.findByTheme("avanzado");
//            for(Lesson l: listfindByTheme) {
//                System.out.println(l);
//            }
//
//            System.out.println("\nLista por  level ");
//            List<Lesson> listfindByDescription = lessonRepository.findByDescription("avanzado");
//            for(Lesson l: listfindByDescription) {
//                System.out.println(l);
//            }
//            //ExerciseImage Repository
//            System.out.println("\nLista por  respuesta correcta ");
//            List<ExerciseImage> listLevelExeImage= exerciseImageRepository.ListLevelExeImage("avanzado");
//            for(ExerciseImage ei: listLevelExeImage) {
//                System.out.println(ei);
//            }
//            System.out.println("\nLista por  level ");
//            List<ExerciseImage> listtypeQuestion = exerciseImageRepository.ListBytypeQuestion("Vocales");
//            for(ExerciseImage ei: listtypeQuestion) {
//                System.out.println(ei);
//            }

        };
    }
}
