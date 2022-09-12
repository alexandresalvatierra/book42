import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Books } from '../models/books.model';

export type BooksParams = {
  title: string;
  author: string;
};

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  private apiUrl = `${environment.baseUrl}/books`;

  constructor(private http: HttpClient) {}

  create(params: BooksParams): Observable<Books> {
    return this.http.post<Books>(this.apiUrl, params);
  }

  get(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }

  update(id: string, params: BooksParams): Observable<Books> {
    return this.http.put<Books>(`${this.apiUrl}/${id}`, params);
  }

  delete(book: Books): Observable<any> {
    const headers = new HttpHeaders().set(
      'Content-Type',
      'text/plain; charset=utf-8'
    );
    const requestOptions: Object = {
      headers: headers,
      responseType: 'text',
    };
    return this.http.delete<string>(
      `${this.apiUrl}/${book.id}`,
      requestOptions
    );
  }
}
