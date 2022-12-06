import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TdFormComponent } from './components/td-form/td-form.component';
import { ReactiveFormComponent } from './components/reactive-form/reactive-form.component';

@NgModule({
  declarations: [
    AppComponent,

    ReactiveFormComponent,
    TdFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
