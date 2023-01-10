import { Directive, ElementRef, Input, HostBinding } from '@angular/core';

@Directive({
    selector: '[appEvidenzia]'
})
export class EvidenziaDirective {

    @Input() defaultColor: string = 'yellow';

    @HostBinding('style.backgroundColor') backgroundColor: string = 'transparent';

    constructor(private ref: ElementRef) { }

    ngOnInit(): void {
        this.backgroundColor = this.defaultColor
    }

}
