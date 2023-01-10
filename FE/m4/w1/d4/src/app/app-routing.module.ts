import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardSingolaComponent } from './components/card-singola/card-singola.component';
import { HomeComponent } from './components/home/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PostAttiviComponent } from './components/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './components/post-non-attivi/post-non-attivi.component';

const routes: Routes = [
    {
      path: "",
      component: HomeComponent
    },
    {
      path: "active",
      component: PostAttiviComponent,
      children:[ {
        path: ":id",
        component: CardSingolaComponent
      } ]
    },
    {
      path: "no-active",
      component: PostNonAttiviComponent
    }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
