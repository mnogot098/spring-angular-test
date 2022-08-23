import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppLayoutComponent } from './app-layout/app-layout.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common'
import { ArticlesListComponent } from './articles-list/articles-list.component';
import { CreateArticleComponent } from './create-article/create-article.component';
import { FormsModule } from '@angular/forms';
import { ArticleDetailsComponent } from './article-details/article-details.component';
import { OrderListComponent } from './order-list/order-list.component';
import { OrderDetailsComponent } from './order-details/order-details.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { HomeComponentComponent } from './home-component/home-component.component';


@NgModule({
  declarations: [
    AppComponent,
    AppLayoutComponent,
    ArticlesListComponent,
    CreateArticleComponent,
    ArticleDetailsComponent,
    OrderListComponent,
    OrderDetailsComponent,
    ErrorPageComponent,
    HomeComponentComponent,
  ],
  imports: [
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
