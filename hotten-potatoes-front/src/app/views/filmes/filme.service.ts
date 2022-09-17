import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HeaderService } from 'src/app/components/templates/header/header.service';
import { Filme } from 'src/app/models/filme.model';

@Injectable({
    providedIn: 'root'
})
export class FilmeService {

    baseUrl = 'http://localhost:8080/api/filme'

    constructor(private http: HttpClient, private headerService: HeaderService) {
        this.headerService.headerData = {
            title: 'Filme',
            icon: 'filme',
            routeUrl: '/filme'
        }
    }

    findById(id: string): Observable<Filme> {
        return this.http.get<Filme>(`${this.baseUrl}/${id}`)
    }

    getAll(): Observable<Filme[]>{
        console.log("oi")
        return this.http.get<Filme[]>(this.baseUrl)
    }

    create(filme: Filme): Observable<Filme> {
        return this.http.post<Filme>(this.baseUrl, filme);
    }

    updateFilme(filme: Filme): Observable<Filme> {
        const url = `${this.baseUrl}/${filme.id}`
        return this.http.put<Filme>(url, filme);
    }

    deleteById(id: number): Observable<Filme> {
        const url = `${this.baseUrl}/${id}`;
        return this.http.delete<Filme>(url);
    }
}
