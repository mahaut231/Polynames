package controler;

import java.util.ArrayList;

import dao.PlayerDAO;
import models.Player;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class PlayerController {

    public PlayerController() {
    }

    public ArrayList<Player> getAllPlayer(WebServerContext context) {
        ArrayList<Player> result = new ArrayList<>();

        try {
            PlayerDAO playerDAO = new PlayerDAO();
            result = playerDAO.getAllPlayer();
            WebServerResponse response = context.getResponse();
            response.json((result));

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }

        return (result);
    }

}
