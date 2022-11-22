abstract class Lavoratori {
    codredd: number;
    redditoAnnualeLordo: number;
    tasseInps: number;
    tasseIrpef: number;
    constructor(_codredd: number, _redditoAnnualeLordo: number, _tasseInps: number, _tasseIrpef: number) {
        this.codredd = _codredd;
        this.redditoAnnualeLordo = _redditoAnnualeLordo;
        this.tasseInps = _tasseInps;
        this.tasseIrpef = _tasseIrpef;
    }
    abstract getUtileTasse(): number;
    abstract getTasseInps(): number;
    abstract getTasseIrpef(): number;
    abstract getRedditoAnnuoNetto(): number;
}

class Persona extends Lavoratori {
    constructor(_codredd: number, _redditoAnnualeLordo: number, _tasseInps: number, _tasseIrpef: number) {
        super(_codredd, _redditoAnnualeLordo, _tasseInps, _tasseIrpef)
    }
    getUtileTasse() {
        return this.redditoAnnualeLordo * this.codredd / 100;
    }
    getTasseInps() {
        return this.getUtileTasse() * this.tasseInps / 100;
    }
    getTasseIrpef() {
        return this.getUtileTasse() * this.tasseIrpef / 100;
    }
    getRedditoAnnuoNetto() {
        return this.redditoAnnualeLordo - (this.getTasseInps() + this.getTasseIrpef());
    }
}

var professionista = new Persona(40, 80000, 23, 35);
var artigiano = new Persona(80, 40000, 23, 25);
var commerciante = new Persona(60, 50000, 23, 35);

console.log('Utile tasse professionista: ' + professionista.getUtileTasse());
console.log('Tasse inps professionista: ' + professionista.getTasseInps());
console.log('Tasse Irpef professionista: ' + professionista.getTasseIrpef());
console.log('Reddito annuo netto professionista: ' + professionista.getRedditoAnnuoNetto());

console.log('----------------------------------------------------');

console.log('Utile tasse artigiano: ' + artigiano.getUtileTasse());
console.log('Tasse inps artigiano: ' + artigiano.getTasseInps());
console.log('Tasse Irpef artigiano: ' + artigiano.getTasseIrpef());
console.log('Reddito annuo netto artigiano: ' + artigiano.getRedditoAnnuoNetto());

console.log('----------------------------------------------------');

console.log('Utile tasse commerciante: ' + commerciante.getUtileTasse());
console.log('Tasse inps commerciante: ' + commerciante.getTasseInps());
console.log('Tasse Irpef commerciante: ' + commerciante.getTasseIrpef());
console.log('Reddito annuo netto commerciante: ' + commerciante.getRedditoAnnuoNetto());