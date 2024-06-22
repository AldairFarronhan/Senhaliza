import { Component } from '@angular/core';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  logeado: boolean = false;
  title = 'senhaliza';

  isSideNavCollapsed = false;
  screenWidth = 0;

  ngOnInit(){
    if(typeof localStorage !== 'undefined') {
      // localStorage.clear();
      // localStorage.setItem("id","0");
      // localStorage.setItem("authorities","ROLE_STUDENT");
    }
    if(typeof localStorage !== 'undefined'){
      if(localStorage.getItem("id") !== null){
        this.logeado = true;
      }
    }
    
  }

  onToggleSideNav(data: SideNavToggle): void {
    this.screenWidth = data.screenWidth;
    this.isSideNavCollapsed = data.collapsed;
  }

  habilitarContenido(){
    this.logeado = true;
  }

  deshabilitarContenido(){
    this.logeado = false;
  }
}
