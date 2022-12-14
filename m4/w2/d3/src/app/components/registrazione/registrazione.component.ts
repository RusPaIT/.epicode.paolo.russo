import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {
  homeform!: FormGroup

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {

    this.homeform = this.fb.group({
      homeform: this.fb.group({
        email: this.fb.control(""),
        password: this.fb.control(""),
        indirizzo: this.fb.control(""),
        citta: this.fb.control("")
      })
    })

    this.homeform.setValue({
      email:"test"
    })


    this.homeform.valueChanges.subscribe(value => {
      console.log(value);
  })

  }

  submit() {
    console.log(this.homeform);
    console.log('Form correttamente inviato');
    this.homeform.reset();
}

getEmail() {
  return this.homeform.get('email') as FormControl;
}

}

