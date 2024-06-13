

export class Card {

    #value;

    constructor(val){
        this.#value = val;
    }

    get value(){ return this.#value};

}