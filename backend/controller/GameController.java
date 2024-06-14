package controller;

import java.util.ArrayList;

import dao.GameDAO;
import models.Game;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class GameController {

    public GameController(){} //Constructeur

    public static ArrayList<Game> getAllGame(WebServerContext context){
        ArrayList<Game> gameList = new ArrayList<>();

        try{
            GameDAO gameDAO = new GameDAO();
            gameList = gameDAO.getAllgame();
            WebServerResponse response = context.getResponse();
            response.json(gameList);
            response.ok("Print games");
        
        } catch (Exception e){
            System.out.println("Error : " + e);
        }
    return(gameList);
    }


    public static Game getGame(WebServerContext context){
        Game game = new Game(0, 0, false);
        try {
            GameDAO gameDAO = new GameDAO();
            int gameId = Integer.parseInt(context.getRequest().getParam("gameId"));
            game = gameDAO.getGame(gameId);

            WebServerResponse response = context.getResponse();
            response.ok("get game");
        } catch (Exception e){
            System.out.println("Error : "  + e);
        }
        return(game);
    }

}
