import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Letter } from '../../models/Letter';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  apiBase: string = 'http://localhost:8080/api/pub';

  constructor(private http: HttpClient) {}

  postMessage(letter: Letter): Observable<any>{
    return this.http.post<any>(`${this.apiBase}/send`, letter);
  }

  getAuthors(): Observable<any>{
    return this.http.get<any>(`${this.apiBase}/authors`);
  }

  getFilesByAuthor(author:string): Observable<any>{
    return this.http.get<any>(`${this.apiBase}/files?author=${author}`);
  }

  getContentFile(author: string, fileName: string) : Observable<any>{
    return this.http.get<any>(`${this.apiBase}/read?author=${author}&fileName=${fileName}`);
  }

}
