import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MaterialModule } from './modules/material/material.module';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { UserNewComponent } from './components/user/user-new/user-new.component';
import { UserListComponent } from './components/user/user-list/user-list.component';
import { LevelListComponent } from './components/level/level-list/level-list.component';
import { LevelNewComponent } from './components/level/level-new/level-new.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';
import { StudentListComponent } from './components/student/student-list/student-list.component';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { BodyComponent } from './components/body/body.component';
import { AuthorityListComponent } from './components/authority/authority-list/authority-list.component';
import { LessonListComponent } from './components/lesson/lesson-list/lesson-list.component';
import { PlanListComponent } from './components/plan/plan-list/plan-list.component';
import { ExerciseListComponent } from './components/exercise/exercise-list/exercise-list.component';
import { ImageListComponent } from './components/image/image-list/image-list.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ConfirmComponent } from './components/confirm/confirm.component';
import { AddComponent } from './components/add/add.component';
import { ImageNewComponent } from './components/image/image-new/image-new.component';
import { QuestionToMarkComponent } from './components/question/question-to-mark/question-to-mark.component';
import { QuestionToCompleteComponent } from './components/question/question-to-complete/question-to-complete.component';
import { LogInComponent } from './components/user/log-in/log-in.component';
import { SignUpComponent } from './components/user/sign-up/sign-up.component';
import { StudentProfileComponent } from './components/student/student-profile/student-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    UserNewComponent,
    UserListComponent,
    LevelListComponent,
    LevelNewComponent,
    StudentListComponent,
    SidenavComponent,
    BodyComponent,
    AuthorityListComponent,
    LessonListComponent,
    PlanListComponent,
    ExerciseListComponent,
    ImageListComponent,
    DashboardComponent,
    ConfirmComponent,
    AddComponent,
    ImageNewComponent,
    QuestionToMarkComponent,
    QuestionToCompleteComponent,
    LogInComponent,
    SignUpComponent,
    StudentProfileComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MaterialModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    MatFormFieldModule, 
    MatInputModule, 
    MatTableModule, 
    MatSortModule, 
    MatPaginatorModule
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
