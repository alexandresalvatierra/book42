import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BooksRoutingModule } from './books-routing.module';
import { BooksComponent } from './components/books/books.component';

@NgModule({
  declarations: [BooksComponent],
  imports: [CommonModule, BooksRoutingModule],
})
export class BooksModule {}
