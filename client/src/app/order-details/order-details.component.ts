import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Article } from '../article';
import { Order } from '../order';
import { OrderService } from '../services/order-service.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {

  id:number;
  deletedArticle:Article;
  order:Order = new Order();
  constructor(private service:OrderService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.service.getOrder(this.id).subscribe(data =>{
      this.order = data
    }

  )}

  deleteArticleFromOrder(orderId:number,articleId:number):any {
    this.service.deleteArticleFromOrder(orderId,articleId).subscribe(data =>{
      console.log(data);
    })
  }

}
