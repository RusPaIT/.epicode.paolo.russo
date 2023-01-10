function showBtn() {
    document.getElementById("myMenu").classList.toggle("show");
  }


function fiveButton1() {
    document.getElementById("titolo").classList.toggle("showBtn1");
}

function fiveButton2() {
  document.getElementById("titolo").classList.toggle("showBtn2");
}

function fiveButton3() {
  document.getElementById("titolo").classList.toggle("showBtn3");
}

function fiveButton4() {
  document.getElementById("titolo").classList.toggle("showBtn4");
}

function fiveButton5() {
  document.getElementById("titolo").classList.toggle("showBtn5");
}

let lista = document.querySelectorAll("li");

for (var i =0; i < lista.length; i++) {
  lista[i].addEventListener("mouseover", function(){
    this.classList.add("colore");
  });
  
  lista[i].addEventListener("mouseout", function(){
    this.classList.remove("colore");
  });
  
  lista[i].addEventListener("click", function(){
    this.classList.toggle("segnato");
  });
  
}