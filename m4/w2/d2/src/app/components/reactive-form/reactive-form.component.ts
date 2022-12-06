import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, ValidationErrors, Validators } from '@angular/forms'

@Component({
    selector: 'app-reactive-form',
    templateUrl: './reactive-form.component.html',
    styleUrls: ['./reactive-form.component.scss']
})
export class ReactiveFormComponent implements OnInit {

    heroForm!: FormGroup;

    constructor(private fb: FormBuilder) { }

    ngOnInit(): void {
        this.heroForm = this.fb.group({
            heroInfo: this.fb.group({
                name: this.fb.control(null),
                alterego: this.fb.control(null),
                nemico: this.fb.control(null),
                power: this.fb.array([])
            })
        })

        this.heroForm.valueChanges.subscribe(value => {
            console.log(value);
        });
    }

    getFormC(name: string) {
        return this.heroForm.get(name);
    }


    getPowersF() {
        return (this.heroForm.get('heroInfo.power') as FormArray).controls;
    }

    addPower() {
        const control = this.fb.control(null);
        (this.heroForm.get('heroInfo.power') as FormArray).push(control);
    }

    submit() {
        console.log(this.heroForm);
        console.log('Form correttamente inviato');
        this.heroForm.reset();
    }

}
