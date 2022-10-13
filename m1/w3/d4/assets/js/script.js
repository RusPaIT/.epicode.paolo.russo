//Primo Step!
var frase = "Sto imparando JavaScript";

document.getElementById("maiuscola").innerHTML = frase.toUpperCase();
document.getElementById("minuscola").innerHTML = frase.toLowerCase();
document.getElementById("strArray").innerHTML = frase.split("");
document.getElementById("estraiCaratteri").innerHTML = frase.substr(2);
document.getElementById("concatena").innerHTML = frase.concat(" JS");
document.getElementById("estraiStringa").innerHTML = frase.slice(-19,9);




//Secondo Step!
const gruppo = ["Giovanni","Carla","Piero","Mirtilla"] 

document.getElementById("array").innerHTML = gruppo;
document.getElementById("lunghezza").innerHTML = gruppo.length;
document.getElementById("elemento").innerHTML = gruppo[2];
document.getElementById("ultimo").innerHTML = gruppo[3];
gruppo.splice(2,1,"Massimo");
document.getElementById("modificato").innerHTML = gruppo;

//Terzo Step!
const calcolaAnni = function(compleanno){
    return 2022 - compleanno
}

const anni =[2001, 1990, 1987, 2018, 2010];
const eta1 = calcolaAnni(anni[0]);
const eta2 = calcolaAnni(anni[1]);
const eta3 = calcolaAnni(anni[2]);
const eta4 = calcolaAnni(anni[3]);
const eta5 = calcolaAnni(anni[4]);

document.getElementById("eta1").innerHTML += eta1 +" anni";
document.getElementById("eta2").innerHTML += eta2 +" anni";
document.getElementById("eta3").innerHTML += eta3 +" anni";
document.getElementById("eta4").innerHTML += eta4 +" anni";
document.getElementById("eta5").innerHTML += eta5 +" anni";
document.getElementById("arrayEta").innerHTML += `${eta1},${eta2},${eta3},${eta4},${eta5}`;

//Quarto Step!
const animali = ["coniglio", "cane", "gatto", "criceto"];

document.getElementById("intero").innerHTML = animali;
animali.push("leone");
document.getElementById("aggiunto").innerHTML = animali;
animali.pop(4);
document.getElementById("estratto").innerHTML = animali;
document.getElementById("verifica1").innerHTML = animali.includes("coniglio");
document.getElementById("verifica2").innerHTML = animali.includes("armadillo");



