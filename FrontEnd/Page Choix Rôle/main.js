
document.addEventListener("DOMContentLoaded", function(){

    const btnMaitreMots = document.getElementById("btn-mot");
    const btnMaitreIntuition = document.getElementById("btn-intuition");
    if (btnMaitreMots){
        btnMaitreMots.addEventListener("click", function(){
            window.location.href = "../Page%20jeu%20mots/indexMdM.html";
        })
    }
    if (btnMaitreIntuition){
        btnMaitreIntuition.addEventListener("click", function(){
            window.location.href = "../Page%20jeu%20sans%20couleurs/indexMdI.html";
        })
    }

});