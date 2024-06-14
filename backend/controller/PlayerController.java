package controller;

import java.util.ArrayList;

import dao.PlayerDAO;
import models.Player;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class PlayerController {

    public PlayerController(){}     //Constructeur

    public static ArrayList<Player> getAllPlayer(WebServerContext context) {    
        ArrayList<Player> playerList = new ArrayList<>();

        try {
            PlayerDAO playerDAO = new PlayerDAO();
            playerList = playerDAO.getAllPlayer();
            WebServerResponse response = context.getResponse();
            response.json((playerList));
            response.ok("Print players");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return (playerList);
    }

    public static Player getPlayer(WebServerContext context) {      
        Player player = new Player(0, null);
        try {
            PlayerDAO playerDAO = new PlayerDAO();
            int playerId = Integer.parseInt(context.getRequest().getParam("playerId"));
            player = playerDAO.getPlayer(playerId);

            WebServerResponse response = context.getResponse();
            response.json(player);

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (player);
    }

    public static void addPlayer(WebServerContext context) {    
        try {
            PlayerDAO playerDAO = new PlayerDAO();
            String playerName = context.getRequest().getParam("playerName");
            playerDAO.addPlayer(playerName);

            WebServerResponse response = context.getResponse();
            response.ok("player added");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public static void deletePlayer(WebServerContext context) {     

        try {
            PlayerDAO playerDAO = new PlayerDAO();
            int playerId = Integer.parseInt(context.getRequest().getParam("playerId"));
            playerDAO.deletePlayer(playerId);

            WebServerResponse response = context.getResponse();
            response.ok("player deleted");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

}
