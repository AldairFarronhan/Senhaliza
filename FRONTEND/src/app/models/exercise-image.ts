import { Exercise } from "./exercise";
import { Image } from "./image";

export interface ExerciseImage{
    id: number;
    correctOption: boolean;
    correctAnswer: string;
    exercise: Exercise; // FK
    image: Image;       //FK
}