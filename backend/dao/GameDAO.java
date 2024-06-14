package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolynamesDatabase;
import models.Game;

public class GameDAO {

    public GameDAO() {
    }

    public ArrayList<Game> getAllgame() {      //Méthode de récupération de toutes les parties
        ArrayList<Game> gameList = new ArrayList<>();

        try {

            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "Select * from `game`";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultsSQL = prepRequestSQL.executeQuery();

            while (resultsSQL.next()) {
                int gameId = resultsSQL.getInt("gameId");
                int gameActiveBoard = resultsSQL.getInt("gameActiveBoard");
                boolean gameOver = resultsSQL.getBoolean("gameOver");

                Game game = new Game(gameId, gameActiveBoard, gameOver);
                gameList.add(game);
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }

        return (gameList);
    }

    public Game getGame(int ind) {
        try {

            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "SELECT * FROM `game` WHERE `gameId` == ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, ind);
            ResultSet resultSQL = prepRequestSQL.executeQuery();

            int gameId = resultSQL.getInt("gameId");
            int gameActiveBoard = resultSQL.getInt("gameActiveBoard");
            boolean gameOver = resultSQL.getBoolean("gameOver");

            Game game = new Game(gameId, gameActiveBoard, gameOver);
            return(game);
        }catch (Exception e){
            System.out.println("Error :" + e);
            return(null);
        }
    }

}
