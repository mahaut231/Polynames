import { Observer } from "../patterns/observer.js";

export class ViewMemory extends Observer
{
    #controllerMemory;
    #tabMots = ["alizee", "coeur", "bache", "tache", "ecole", 
        "point", "neutre", "mime", "mort", "maman", "moulin", "developper",
        "alice", "merveille", "chapeau", "amant", "truc", "muche", "jeu", "plus",
        "idee", "manger", "alcool", "lutte", "cheval", "islande", "bidule", "narbule",
        "bagnole", "histoire", "archeologie", "trousse", "baton", "neige", "abaque",
        "hortensia", "panneau", "ballon", "poignet", "poignée", "parapluie", "ombrelle", 
        "abajour", "parlementer", "machin", "chose", "boite", "tasse", "outil", "chat",
        "mince", "pince", "rince"
    ];
    #motsSelects = [];    

    constructor(controllerMemory)
    {
        super();

        this.#controllerMemory = controllerMemory;
        this.#controllerMemory.addObserver(this);
        for (let i = 0 ; i < 25; i++){
            let indexRandom = Math.floor(Math.random()*this.#tabMots.length);
            this.#motsSelects.push(this.#tabMots[indexRandom]);
            this.#tabMots.splice(indexRandom, 1);

        }
    }

    notify()
    {
        this.displayCard();
        this.initialiser();
    }

    displayCard(){
        for (let i = 0; i < 25; i++){
        let element = document.createElement("button");
        element.classList.add("card");
        element.id = "btn" + i ;
        element.innerHTML = this.#motsSelects[i];
        document.querySelector(".cards").append(element);
        }
        return this.#motsSelects;
    }


    initialiser(){const btn0 = document.getElementById("btn0");
        const btn2 = document.getElementById("btn2");
        const btn8 = document.getElementById("btn8");
        const btn21 = document.getElementById("btn21");
        const btn14 = document.getElementById("btn14");
        const btn15 = document.getElementById("btn15");
        const btn17 = document.getElementById("btn17");
        const btn24 = document.getElementById("btn24");
        const btn5 = document.getElementById("btn5");
    
        if (btn0){
            btn0.addEventListener("click", function(){
                console.log("btn0 clicked");
                btn0.classList.replace("card", "cardRed")
            });
        };
        if (btn2){
            btn2.addEventListener("click", function(){
                console.log("btn2 clicked");
                btn2.classList.replace("card", "cardGreen")
            });
        };
        if (btn8){
            btn8.addEventListener("click", function(){
                console.log("btn8 clicked");
                btn8.classList.replace("card", "cardGreen")
            });
        };
        if (btn21){
            btn21.addEventListener("click", function(){
                console.log("btn21 clicked");
                btn21.classList.replace("card", "cardGreen")
            });
        };
        if (btn14){
            btn14.addEventListener("click", function(){
                console.log("btn14 clicked");
                btn14.classList.replace("card", "cardGreen")
            });
        };
        if (btn15){
            btn15.addEventListener("click", function(){
                console.log("btn15 clicked");
                btn15.classList.replace("card", "cardGreen")
            });
        };
        if (btn17){
            btn17.addEventListener("click", function(){
                console.log("btn17 clicked");
                btn17.classList.replace("card", "cardGreen")
            });
        };
        if (btn5){
            btn5.addEventListener("click", function(){
                console.log("btn5 clicked");
                btn5.classList.replace("card", "cardGreen")
            });
        };
        if (btn24){
            btn24.addEventListener("click", function(){
                console.log("btn24 clicked");
                btn24.classList.replace("card", "cardGreen")
            });
        }
    
    };
    
    }
