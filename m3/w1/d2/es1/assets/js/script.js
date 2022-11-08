class Person {
    constructor(_nome, _eta) {
        this.nome = _nome;
        this.eta = _eta;
    }

    confronto(persona1) {
        if(this.eta > persona1.eta) {
            console.log(`${this.nome} è più vecchio di ${persona1.nome}`);
        } else if(this.eta == persona1.eta) {
            console.log(`${this.nome} e ${persona1.nome} hanno la stessa età`);
        } else {
            console.log(`${this.nome} è più giovane di ${persona1.nome}`);
        }
    }
}

var p1 = new Person ("Luca", 31);
var p2 = new Person ("Paolo", 31);
var p3 = new Person ("AntonGesualdo", 89);

p1.confronto(p2);
p2.confronto(p3);
p3.confronto(p1);