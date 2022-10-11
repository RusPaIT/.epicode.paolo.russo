var nome = "Aldo";
let ruolo = "Cliente";
const numero = 3.14;

document.getElementById("concatena").innerHTML = nome + ', ' + ruolo + ', ' + numero;

var frase = nome + ', ' + ruolo + ', ' + numero;

document.getElementById("concatena2").innerHTML = frase;

var nome = "Mario";

document.getElementById("var").innerHTML = nome;

{
    let nome = "Carla";
    document.getElementById("let").innerHTML = nome;
}

document.getElementById("final").innerHTML = nome;

document.getElementById("let2").innerHTML = nome;

{
    let nome = "Carla";
    document.getElementById("let3").innerHTML = nome;
    document.getElementById("final2").innerHTML = nome;
}

var num = 15;

document.getElementById("iniziale").innerHTML += num;

{
    var somma = num + num;
    document.getElementById("valore1").innerHTML += somma + ',' + (somma + 1); 
}

{
    var sottrazione = num - 10;
    document.getElementById("valore2").innerHTML += sottrazione + ',' + (sottrazione - 1);
}

{
    var per = num * 3;
    document.getElementById("valore3").innerHTML += per;
}

{
    var divisione = num / 3;
    document.getElementById("valore4").innerHTML += divisione;
}

{
    var concatenazione = num + "" + somma + "" + sottrazione + "" + per + "" + divisione;
    document.getElementById("valore5").innerHTML += concatenazione;
}



