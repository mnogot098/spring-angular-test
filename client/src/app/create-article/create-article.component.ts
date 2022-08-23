import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from '../article';
import { ArticleService } from '../services/article-service.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {

  article:Article = new Article();

  constructor(private service:ArticleService,private router:Router) { }

  ngOnInit(): void {
  }

  saveArticle()
  {
    this.service.addArticle(this.article).subscribe(data=>{
      console.log(data);
    }
    )
    this.goToArticlesList();
  }

  goToArticlesList()
  {
    this.router.navigate(['articles'])
  }

  onSubmit(){
    this.saveArticle();
  }

}
