import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../article';
import { Order } from '../order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private baseUrl = 'http://localhost:8081/orders';

  constructor(private http:HttpClient) { }

  fetchOrderleList():Observable<any>
  {
    return this.http.get<any>(`${this.baseUrl}`)
  }

  getOrder(id:number):Observable<Order>
  {
    return this.http.get<Order>(`${this.baseUrl}/${id}`);
  }

  deleteArticleFromOrder(orderId:number,articleId:number):Observable<any>
  {
    return this.http.delete(`${this.baseUrl}/${orderId}/articles/${articleId}`);
  }
}
