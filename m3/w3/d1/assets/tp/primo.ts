var estratto: number;
var giocatore1: number;
var giocatore2: number;

function estrazione() {
    giocatore1 = Math.floor((Math.random() * 100) + 1);
    giocatore2 = Math.floor((Math.random() * 100) + 1);

    console.log(`Numero giocatore 1: ${giocatore1}`);
    console.log(`Numero giocatore 2: ${giocatore2}`);

    generazione();

}

function generazione() {
    estratto = Math.floor((Math.random() * 100) + 1);
    console.log(`Numero estratto: ${estratto}`);
    confronto();
}

function confronto() {
    if (giocatore1 == estratto) {
        console.log('Il Giocatore 1 ha indovinato');
    } else if (giocatore2 == estratto) {
        console.log('Il Giocatore 2 ha indovinato');
    } else if ((Math.abs(estratto - giocatore1)) < (Math.abs(estratto - giocatore2))) {
        console.log('Nessuno ha indovinato, ma il Giocatore 1 si è avvicinato di più');
    } else {
        console.log('Nessuno ha indovinato, ma il Giocatore 2 si è avvicinato di più');
    }
}