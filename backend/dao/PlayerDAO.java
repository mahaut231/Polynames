package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolynamesDatabase;
import models.Player;

public class PlayerDAO {

    public PlayerDAO() {
    }

    public ArrayList<Player> getAllPlayer() {       //Méthode de récupération de tout les joueurs
        ArrayList<Player> playerList = new ArrayList<>();

        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "Select * from `player`";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultsSQL = prepRequestSQL.executeQuery();

            while (resultsSQL.next()) {
                int playerId = resultsSQL.getInt("playerId");
                String playerName = resultsSQL.getString("playerName");
                Player player = new Player(playerId, playerName);
                playerList.add(player);
            }

        } catch (Exception e) {
            System.out.println("Error :" + e);
        }

        return (playerList);
    }

    public Player getPlayer(int ind) {      //Méthode de récupération d'un joueur par son ID
        String playerName = null;
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "SELECT * FROM `player` WHERE playerId = ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, ind);
            playerName = prepRequestSQL.executeQuery().getString("playerName");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        Player player = new Player(0, playerName);
        return (player);
    }

    public void addPlayer(String playerName) {      // Méthode d'ajout d'un joueur
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "INSERT INTO player (playerName) VALUES (?);";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setString(1, playerName);
            prepRequestSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void deletePlayer(int ind) { //Méthode de suppression d'un joueur 
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "DELETE FROM player WHERE playerId == ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, ind);
            prepRequestSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : e");
        }
    }

}
