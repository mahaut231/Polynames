import { Card } from "../models/card.js";
//import { Memory } from "../models/memory.js";
import { Notifier } from "../patterns/notifier.js";

export class ControllerMemory extends Notifier
{

    #card ;

    constructor()
    {
        super();
    }

    get card() { return this.#card };

    createCard(){

        this.#card = new Card("test");
        this.notify();
    }

    createCardWhite(){

        this.notify();
    }

}