import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from '../article';
import { ArticleService } from '../services/article-service.service';


@Component({
  selector: 'app-articles-list',
  templateUrl: './articles-list.component.html',
  styleUrls: ['./articles-list.component.css']
})
export class ArticlesListComponent implements OnInit {

  articles :Article[];

  constructor(private service:ArticleService,private router:Router) { }

  ngOnInit(): void {
    this.service.fetchArticleList().subscribe(
      data =>{
        console.log(data),
        this.articles = data
      }
    )
  }

  getArticleDetails(id:number)
  {
    this.router.navigate(['articles',id]);
  }

}
