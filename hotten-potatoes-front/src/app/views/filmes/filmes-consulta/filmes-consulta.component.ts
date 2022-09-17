import { Component, OnInit } from '@angular/core';
import {Category} from "../../../models/category.model";
import {CategoryService} from "../../category/category.service";
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Filme} from "../../../models/filme.model";
import {FilmeService} from "../filme.service";

@Component({
  selector: 'app-filmes-consulta',
  templateUrl: './filmes-consulta.component.html',
  styleUrls: ['./filmes-consulta.component.css']
})
export class FilmesConsultaComponent implements OnInit {

  filmes: Filme[] = []
   filme: Filme = {
     anoEstreia: 0,
     bilheteria: "",
     classificacao: "",
     diretor: {},
     duracao: 0,
     estudio: {},
     paisDeOrigem: "",
     sinopse: "",
     titulo: ""

   }

  displayedColumns = ['id',
    'titulo',
    'estudio',
    'diretor' ,
    'action'];

  constructor(
      private service: FilmeService,
      private router: Router,
      private _snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.findAllCategoires();
  }

  findAllCategoires(): void {
    this.service.getAll().subscribe((response) => {
      this.filmes = response;
    })
  }

  navigateToCategoryCreate(): void {
    this.router.navigate(["filmes/edicao"])
  }

  edit(id: number){
    this.router.navigate(["filmes/edicao/"+id])
  }

  remove(id: number){
    this.service.deleteById(id).subscribe(x => {
      this.router.navigate([""])
    })
  }
}
