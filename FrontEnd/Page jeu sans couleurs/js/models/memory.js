import { Card } from "../models/card.js";


export class Memory {

    #cards;
    #tabMots = ["alizee", "coeur", "bache", "tache", "ecole", 
        "point", "neutre", "mime", "mort", "maman", "moulin", "developpement",
        "alice", "merveille", "chapeau", "amant", "truc", "muche", "jeu", "plus",
        "idee", "manger", "alcool", "lutte", "cheval", "islande", "bidule", "narbule"
    ];

    constructor(){
        this.#cards = [];
    }

    newGame(){
        for (let i = 0; i < 25; i++){
            this.#cards.push(new Card(this.#tabMots[i]));
        }
    }

    getCard(index){ return this.#cards[index];}


}