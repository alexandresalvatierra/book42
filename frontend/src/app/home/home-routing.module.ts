import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { MaterialModule } from '../core/material/material.module';
import { FlexLayoutModule } from '@angular/flex-layout';

const MODULES = [MaterialModule, RouterModule, FlexLayoutModule];

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    data: { title: 'Página Inicial' },
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [MODULES],
})
export class HomeRoutingModule {}
