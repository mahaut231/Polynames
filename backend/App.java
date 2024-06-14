import controller.BoardController;
import controller.CardController;
import controller.GameController;
import controller.PlayerController;
import controller.TeamController;
import java.io.IOException;
import java.sql.SQLException;

import webserver.WebServer;
import webserver.WebServerContext;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        WebServer webserver = new WebServer();

        webserver.listen(8080);

        // Méthodes de Board :

        /*
         * Gestion des routes de l'API, lien d'un contrôleur à une route : chemin & méthode voulue
         */


        webserver.getRouter().get(  
                "/get/allboard",    //route
                (WebServerContext context) -> {
                    BoardController.getAllBoard(context);   //appelle de la méthode 
                });

        webserver.getRouter().get(
                "/get/boardScore/:boardId",
                (WebServerContext context) -> {
                    BoardController.getScoreBoard(context);
                });

        // Méthodes de Card :

        webserver.getRouter().get(
                "/get/allCard",
                (WebServerContext context) -> {
                    CardController.getAllCard(context);
                });

        webserver.getRouter().get(
                "/get/card/:cardId",
                (WebServerContext context) -> {
                    CardController.getCard(context);
                });

        webserver.getRouter().get(
                "/reveal/card/:cardId",
                (WebServerContext context) -> {
                    CardController.revealCard(context);
                });

        webserver.getRouter().put(
                "/color/card/:cardId/:cardColor",       // ???????????
                (WebServerContext context) -> {
                    CardController.colorCard(context);
                });

        // Méthode de Game :

        webserver.getRouter().put(
            "/get/allGame",
            (WebServerContext context) -> {
                GameController.getAllGame(context);
             });

        webserver.getRouter().put(
                "/get/allGame/:gameId",
                (WebServerContext context) -> {
                    GameController.getAllGame(context);
                });

        // Méthode de Player :

        webserver.getRouter().get(
                "/get/allPlayer",
                (WebServerContext context) -> {
                    PlayerController.getAllPlayer(context);
                });

        webserver.getRouter().get(
                "/get/player/:playerId",
                (WebServerContext context) -> {
                    PlayerController.getPlayer(context);
                });

        webserver.getRouter().post(
                "/add/player/:playerName",          // ???????????
                (WebServerContext context) -> {
                    PlayerController.addPlayer(context);
                });

        webserver.getRouter().delete(
                "/delete/player/:playerId",     // ???????????
                (WebServerContext context) -> {
                    PlayerController.deletePlayer(context);
                });

        // Méthodes de Team :

        webserver.getRouter().get(
                "/get/allTeam",
                (WebServerContext context) -> {
                    TeamController.getAllTeam(context);
                });

        webserver.getRouter().get(
                "/get/team/:teamId",
                (WebServerContext context) -> {
                    TeamController.getTeam(context);
                });

        webserver.getRouter().post(
                "/create/team/:player1/:player2",       // ????????????
                (WebServerContext context) -> {
                    TeamController.createTeam(context);
                });

        webserver.getRouter().delete(
                "/delete/team/:player1/:player2",       // ????????????
                (WebServerContext context) -> {
                    TeamController.deleteTeam(context);
                });

        


        System.out.println("End of App");       //Affichage de vérification d'atteinte de la fin du programme
    }
}
