import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from '../order';
import { OrderService } from '../services/order-service.service';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
  styleUrls: ['./order-list.component.css']
})
export class OrderListComponent implements OnInit {

  orders :Order[];

  constructor(private service:OrderService,private router:Router) { }

  ngOnInit(): void {
    this.service.fetchOrderleList().subscribe(
      data =>{
        this.orders = data
      }

    )
  }

  getOrderDetails(id:number)
  {
    this.router.navigate(['orders',id]);
  }

}
