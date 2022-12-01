import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { PostAttiviComponent } from './components/post-attivi/post-attivi.component';
import { PostNonAttiviComponent } from './components/post-non-attivi/post-non-attivi.component';
import { HomeComponent } from './components/home/home/home.component';
import { CardComponent } from './components/card/card.component';
import { CardSingolaComponent } from './components/card-singola/card-singola.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PostAttiviComponent,
    PostNonAttiviComponent,
    HomeComponent,
    CardComponent,
    CardSingolaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
