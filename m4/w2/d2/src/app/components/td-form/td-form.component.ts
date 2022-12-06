import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-td-form',
  templateUrl: './td-form.component.html',
  styleUrls: ['./td-form.component.scss']
})
export class TdFormComponent implements OnInit {

  @ViewChild('form', { static: true }) form! : NgForm;

  heroForm = {
    name: " ",
    alterego: " ",
    super: " ",
    nemico: " ",
    pianeta: " ",
    debolezza: " ",
  }

  hero: any = {}

  constructor() { }

  ngOnInit(): void {
    this.form.statusChanges?.subscribe(status => {
      console.log("Stato del form: ", status)
    })
  }

  submit() {
    console.log("Form inviato : ", this.form);
    this.hero.name = this.form.value.heroInfo.name;
    this.hero.alterego = this.form.value.heroInfo.alterego;
    this.hero.super = this.form.value.heroInfo.super;
    this.hero.nemico = this.form.value.heroInfo.nemico;
    this.hero.pianeta = this.form.value.heroInfo.pianeta;
    this.hero.debolezza = this.form.value.heroInfo.debolezza;

    this.form.reset();
  }

}
