
document.addEventListener("DOMContentLoaded", function(){

    const boutonCreer = document.getElementById("btn-creer");
    const boutonRejoindre = document.getElementById("btn-rejoindre");
    if (boutonCreer){
        boutonCreer.addEventListener("click", function(){
            window.location.href = "../Page%20Choix%20R%C3%B4le/indexChoix.html";
        })
    }
    if (boutonRejoindre){
        boutonRejoindre.addEventListener("click", function(){
            window.location.href = "../Page%20Rejoindre/indexRejoindre.html";
        })
    }
    

});
