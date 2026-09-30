import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Letter } from '../../models/Letter';

@Injectable({
  providedIn: 'root'
})
export class PublisherService {

  constructor(private http: HttpClient) {}

  postMessage(letter: Letter): any{
    return this.http.post<any>('http://localhost:8080/api/pub/send', letter)
    .subscribe(response => {
      return response;
    });
  }
}
