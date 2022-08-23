import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article } from '../article';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private baseUrl = 'http://localhost:8081/articles';
  //private options = { headers: new HttpHeaders().set('Content-Type', 'multipart/form-data') };

  constructor(private http:HttpClient) { }

  fetchArticleList():Observable<any>
  {
    return this.http.get<any>(`${this.baseUrl}`)
  }

  addArticle(article:Article):Observable<any>
  {
    return this.http.post(`${this.baseUrl}`,article);
  }

  getArticle(id:number):Observable<Article>
  {
    return this.http.get<Article>(`${this.baseUrl}/${id}`);
  }
}
