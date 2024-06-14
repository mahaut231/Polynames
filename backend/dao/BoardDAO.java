package dao;

import database.PolynamesDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Board;

public class BoardDAO {

    public BoardDAO(){}

    public ArrayList<Board> getAllBoard() {         //Méthode de récupération de tout les plateaux
        ArrayList<Board> boardList = new ArrayList<>();
        try {

            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();    //Instance de la base utilisé
            String requestSQL = "SELECT * FROM board";  //requête SQL
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);   //format de requête empêchant le détournement des méthodes
            ResultSet resultsSQL = prepRequestSQL.executeQuery();   //exécution de la requête avec executeQuery() (car on à un SELECT)

            while (resultsSQL.next()) {
                int boardId = resultsSQL.getInt("boardId");     //Récupération de l'entier dans la colonne boardId
                int boardScore = resultsSQL.getInt("boardScore");
                int boardActiveTeam = resultsSQL.getInt("boardActiveTeam");
                Board Board = new Board(boardId, boardScore, boardActiveTeam);  //instance de Board
                boardList.add(Board);   //ajout de l'instance dans la liste des board
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }
        return (boardList);
    }

    public int getScoreBoard(int ind) {
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "SELECT boardScore FROM board where boardId == ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, ind);  //Remplacement du 1er "?" par ind
            ResultSet resultsSQL = prepRequestSQL.executeQuery();

            return (resultsSQL.getInt("boardScore"));
        } catch (Exception e) {
            System.out.println("Error : " + e);
            return (-1);
        }
    }

}
