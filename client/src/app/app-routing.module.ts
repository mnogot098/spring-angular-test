import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { ArticleDetailsComponent } from './article-details/article-details.component';
import { ArticlesListComponent } from './articles-list/articles-list.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { HomeComponentComponent } from './home-component/home-component.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { OrderListComponent } from './order-list/order-list.component';

const routes: Routes = [
  {path:'',
  component:AppLayoutComponent,
children:
[
  {path:"articles",component:ArticlesListComponent},
  {path:"add-article",component:CreateArticleComponent},
  {path:"articles/:id",component:ArticleDetailsComponent},
  {path:"orders",component:OrderListComponent},
  {path:"orders/:id",component:OrderDetailsComponent},
  {path:"",component:HomeComponentComponent}
]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
