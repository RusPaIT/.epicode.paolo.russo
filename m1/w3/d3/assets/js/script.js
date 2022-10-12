//Primo Step!
function frutta(mele, arance){
    const succo = `succo con ${mele} mele e ${arance} arance`;
   return succo;
    }
   document.getElementById("corretta").innerHTML = frutta(5, 6);
   document.getElementById("sbagliata").innerHTML = frutta(5, );

//Secondo Step!
eta();
function eta(compleanno) {
    return 2022 - compleanno;
}
document.getElementById("eta").innerHTML += `${eta(1991)} anni`;

//Terzo Step!
calcoloAnno = (val1, val2) => {
    return val1 - val2;
}

document.getElementById("persona1").innerHTML =`L' anno di nascita di Anna è il ${calcoloAnno(2022, 30)}`;
document.getElementById("persona2").innerHTML =`L' anno di nascita di Maria è il ${calcoloAnno(2022, 24)}`;

//Quarto Step!
function torta1() {
    function torta2() {
        document.getElementById("torta").innerText = `torta con ${9} fette di mela e ${15} fette di arancia`;
    }
    return torta2();
}
torta1();

//Form!
var btn = document.getElementById("calcola");

btn.addEventListener("click",function(){
    var cibo = Number (document.getElementById("cibo").value);
    var detersivi = Number (document.getElementById("detersivi").value);
    var abiti = Number (document.getElementById("abiti").value);
    var somma =  Number (cibo + detersivi + abiti);
    totale(somma);
})

function totale(somma) {
    document.getElementById("totale").innerHTML += somma;
}