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


    get mots(){ return this.#motsSelects};


    notify()
    {
        this.displayCard();
    }


    displayCard(){
        let elementR = document.createElement("button");
        elementR.classList.add("cardRed");
        elementR.innerHTML = this.#motsSelects[0];
        document.querySelector(".cards").append(elementR);
        let elementV1 = document.createElement("button");
        elementV1.classList.add("cardGreen");
        elementV1.innerHTML = this.#motsSelects[1];;
        document.querySelector(".cards").append(elementV1);
        for (let i = 2; i < 24; i++){
        let element = document.createElement("button");
        element.classList.add("card");
        element.innerHTML = this.#motsSelects[i];
        document.querySelector(".cards").append(element);
        }
        let elementV2 = document.createElement("button");
        elementV2.classList.add("cardGreen");
        elementV2.innerHTML = this.#motsSelects[24];;
        document.querySelector(".cards").append(elementV2);
        return this.#motsSelects;
    }

   
    

}