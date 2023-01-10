function generazione() {
    let budget = 1000;
    let compere = 0;

    while(budget > 0){
         
        let prezzi = Math.floor(Math.random() * 100);
        if(prezzi < budget) {
        compere += 1;
        budget -= prezzi;
        document.getElementById("risultato").innerHTML +='<li> Ammontare della spesa: &euro; ' + prezzi + '<br>Nuovo budget aggiornato: &euro; ' + budget + '</li>';
    }



    if(budget < 200){
        document.getElementById("risultato2").innerHTML = `<p>${"STAI SPENDENDO TROPPO!!! ---- IL BUDGET E' INFERIORE A 200&euro;!!!"}</p>`;
        document.getElementById("finale").innerHTML = "<li> Prodotti aquistati:" + compere + "<br>Budget rimanente: &euro;" + budget + "</li>";
        break;
    }
}
}

function nascondi() {
    document.getElementById("invio").style.visibility = "hidden";
}