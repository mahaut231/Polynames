package models;

/*
 * Les cartes ont un mot et une couleur, elles ne peuvent être présente qu'une fois dans un plateau
 * 
 * 
 */


public record Card(     //Colonnes de cartes
                int cardId,
                String cardWord,
                boolean cardState,
                int cardColor) {
}
