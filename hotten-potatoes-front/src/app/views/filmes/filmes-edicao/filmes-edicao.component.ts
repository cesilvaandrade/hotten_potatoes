import { Component, OnInit } from '@angular/core';
import {Category} from "../../../models/category.model";
import {CategoryService} from "../../category/category.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Filme} from "../../../models/filme.model";
import {FilmeService} from "../filme.service";

@Component({
  selector: 'app-filmes-edicao',
  templateUrl: './filmes-edicao.component.html',
  styleUrls: ['./filmes-edicao.component.css']
})
export class FilmesEdicaoComponent implements OnInit {

  filme: Filme = {
    bilheteria: "",
    titulo: "", anoEstreia: 0, classificacao: "", diretor: {}, duracao: 0, estudio: {}, paisDeOrigem: "", sinopse: ""}

  constructor(
      private service: FilmeService,
      private router: Router,
      private activatedRoute: ActivatedRoute,
      private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(qp =>{
      this.service.findById(qp.id).subscribe(response =>{
        this.filme = response
      })
    })
  }

  create(): void {


    if(!this.filme.id){
      this.service.create(this.filme).subscribe(() => {
        this.router.navigate(['/categories'])
        this.openMessageCreateSuccess()
      })
    } else {
      this.service.updateFilme(this.filme).subscribe(() => {
        this.router.navigate(['/categories'])
        this.openMessageCreateSuccess()
      })
    }

        console.error(
      this.router.navigate(['/categories']),
      this.openMessageCreateError()
    );

  }

  cancel(): void {
    this.router.navigate(['/categories'])
  }

  openMessageCreateSuccess(): void {
    this._snackBar.open('Created successful Filme', 'close', {
      duration: 3500,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    })
  }

  openMessageCreateError(): void {
    this._snackBar.open('Something went wrong when creating category', 'close', {
      duration: 3500,
      horizontalPosition: 'right',
      verticalPosition: 'top'
    })
  }

  processFile(imageInput: any) {
    const file: File = imageInput.files[0];
    const reader = new FileReader();

    reader.addEventListener('load', (event: any) => {

      this.filme.capa = event.target.result;

    });

    reader.readAsDataURL(file);
  }

}
