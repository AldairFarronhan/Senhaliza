import { Component, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatSnackBar } from '@angular/material/snack-bar';
import { HttpErrorResponse } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmComponent } from '../../confirm/confirm.component';
import { Image } from '../../../models/image';
import { ImageService } from '../../../services/image.service';
import { AddComponent } from '../../add/add.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-image-list',
  templateUrl: './image-list.component.html',
  styleUrl: './image-list.component.css'
})
export class ImageListComponent {
  displayedColumns: string[] = ['id', 'link','imagen', 'meaning', 'acciones'];
  dsList = new MatTableDataSource<Image>();

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(
    private imageService: ImageService,
    private snackBar: MatSnackBar,
    private dialog: MatDialog,
    private enrutador: Router
  ) {}

  ngOnInit() {
    this.cargarLista();
    this.dsList.paginator = this.paginator;
    this.dsList.sort = this.sort;
  }

  ngAfterViewInit() {
    this.dsList.paginator = this.paginator;
    this.dsList.sort = this.sort;
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dsList.filter = filterValue.trim().toLowerCase();

    if (this.dsList.paginator) {
      this.dsList.paginator.firstPage();
    }
  }

  cargarLista() {
    this.imageService.listarImagenes().subscribe({
      next: (data: Image[]) => {
        this.dsList = new MatTableDataSource(data);
        this.dsList.paginator = this.paginator;
      },
      error: (err) => {
        console.log(err);
      },
    });
  }

  eliminarImagen(id: number) {
    let confimarEliminacion = this.dialog.open(ConfirmComponent);
    confimarEliminacion.afterClosed().subscribe((result) => {
      if (result) {
        this.imageService.eliminarImagen(id).subscribe({
          next: () => { this.cargarLista(); },
          error: (err: HttpErrorResponse) => { 
            if (err.error.status == 500) { 
              this.snackBar.open('Existen entidades que dependen de la Imagen','Ok');
            }
          },
        });
      }
    });
  }

  agregarImagen(){
    this.dialog.open(AddComponent, {data: {id: 0, option:"imagen"}});
  }
    
  actualizarImagen(id: string){
    const dialogRef = this.dialog.open(AddComponent, {data: { id: id, option:"imagen"}});
      dialogRef.afterClosed().subscribe(result =>{ if(!result) this.enrutador.navigate(['/lista-imagenes'])})  
  };
}
