import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './components/books/books.component';
import { MaterialModule } from '../core/material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';

const MODULES = [MaterialModule, RouterModule, FlexLayoutModule];

const routes: Routes = [
  {
    path: '',
    component: BooksComponent,
    data: { title: 'Books' },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [MODULES],
})
export class BooksRoutingModule {}
