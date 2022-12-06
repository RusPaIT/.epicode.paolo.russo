import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardSingolaComponent } from './components/card-singola/card-singola.component';
import { HomeComponent } from './components/home/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PostAttiviComponent } from './components/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './components/post-non-attivi/post-non-attivi.component';
import { UsersDetailsComponent } from './components/users-details/users-details.component';
import { UsersComponent } from './components/users/users.component';

const routes: Routes = [
    {
      path: "",
      component: HomeComponent
    },
    {
      path: "active",
      component: PostAttiviComponent,
      children: [{
        path:"card-singola",
        component: CardSingolaComponent
      }]
    },
    {
      path: "no-active",
      component: PostNonAttiviComponent
    },
    {
      path: "users",
      component: UsersComponent,
      children: [{
        path: ":id",
        component: UsersDetailsComponent
      }]
    }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
