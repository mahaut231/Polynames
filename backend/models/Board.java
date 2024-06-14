package models;



/*
 * Un plateau représente l'ensemble des cartes sur lesquels vont se jouer une partie 
 * 
 * 
 */
public record Board(    //Colonnes du plateau
        int boardId,
        int boardScore,
        int boardActiveTeam) {
}
