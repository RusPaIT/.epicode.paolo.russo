var Utente = /** @class */ (function () {
    function Utente(_credito, _numeroChiamate) {
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }
    Utente.prototype.ricarica = function (ric) {
        this.credito += ric;
    };
    Utente.prototype.chiamata = function (minuti) {
        this.credito -= (minuti * 0.2);
        this.numeroChiamate++;
    };
    Utente.prototype.numero404 = function () {
        return this.credito;
    };
    Utente.prototype.getNumeroChiamate = function () {
        return this.numeroChiamate;
    };
    Utente.prototype.azzeraChiamate = function () {
        this.numeroChiamate = 0;
    };
    return Utente;
}());
var utente1 = new Utente(300, 0);
var utente2 = new Utente(50, 0);
var utente3 = new Utente(5, 0);
console.log("Primo Utente");
console.log("-----------");
console.log("Credito iniziale: " + utente1.credito);
utente1.ricarica(50);
console.log("Credito dopo ricarica: " + utente1.numero404());
utente1.chiamata(21);
console.log("Chiamate ricevute: " + utente1.getNumeroChiamate());
utente1.azzeraChiamate();
console.log("Chiamate dopo azzeramento: " + utente1.getNumeroChiamate());
console.log("Credito residuo dopo chiamate: " + utente1.numero404());
console.log("");
console.log("Secondo Utente");
console.log("-----------");
console.log("Credito iniziale: " + utente2.credito);
utente2.ricarica(20);
console.log("Credito dopo ricarica: " + utente2.numero404());
utente2.chiamata(36);
console.log("Chiamate ricevute: " + utente2.getNumeroChiamate());
utente2.azzeraChiamate();
console.log("Chiamate dopo azzeramento: " + utente2.getNumeroChiamate());
console.log("Credito residuo dopo chiamate: " + utente2.numero404());
console.log("");
console.log("Terzo Utente");
console.log("-----------");
console.log("Credito iniziale: " + utente3.credito);
utente3.ricarica(100);
console.log("Credito dopo ricarica: " + utente3.numero404());
utente3.chiamata(52);
console.log("Chiamate ricevute: " + utente3.getNumeroChiamate());
utente3.azzeraChiamate();
console.log("Chiamate dopo azzeramento: " + utente3.getNumeroChiamate());
console.log("Credito residuo dopo chiamate: " + utente3.numero404());