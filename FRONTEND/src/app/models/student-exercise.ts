import { Exercise } from "./exercise";
import { Student } from "./student";

export interface StudentExercise{
    id: number;
    answerDate: string;
    correct: boolean;
    exercise: Exercise; // FK
    student: Student;   //FK
}