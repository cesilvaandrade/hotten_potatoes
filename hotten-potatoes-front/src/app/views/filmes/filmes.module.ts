import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FilmesEdicaoComponent } from './filmes-edicao/filmes-edicao.component';
import {MatButtonModule} from "@angular/material/button";
import {MatTableModule} from "@angular/material/table";
import { FilmesConsultaComponent } from './filmes-consulta/filmes-consulta.component';
import {FormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatSelectModule} from "@angular/material/select";
import {FlexModule} from "@angular/flex-layout";
import {RouterModule} from "@angular/router";



@NgModule({
  declarations: [FilmesEdicaoComponent, FilmesConsultaComponent],
    imports: [
        CommonModule,
        MatButtonModule,
        MatTableModule,
        FormsModule,
        MatInputModule,
        MatSelectModule,
        FlexModule,
        RouterModule
    ]
})
export class FilmesModule { }
