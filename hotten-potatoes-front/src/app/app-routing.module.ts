import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CategoryDeleteComponent } from './views/category/category-delete/category-delete.component';
import { CategoryReadComponent } from './views/category/category-read/category-read.component';
import { CategoryUpdateComponent } from './views/category/category-update/category-update.component';
import { HomeComponent } from './views/home/home/home.component';
import {FilmesEdicaoComponent} from "./views/filmes/filmes-edicao/filmes-edicao.component";
import {FilmesConsultaComponent} from "./views/filmes/filmes-consulta/filmes-consulta.component";

const routes: Routes = [
  {
    path: '',
    component: FilmesConsultaComponent
  },
  {
    path: 'filmes/edicao',
    component: FilmesEdicaoComponent
  },
  {
    path: 'filmes/edicao/:id',
    component: FilmesEdicaoComponent
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
