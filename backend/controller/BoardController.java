package controller;

import dao.BoardDAO;
import java.util.ArrayList;
import models.Board;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class BoardController {

    public BoardController(){}  //Constructeur

    public static ArrayList<Board> getAllBoard(WebServerContext context) {      //Méthode récupération de tout les plateaux
        ArrayList<Board> boardList = new ArrayList<>();

        try {
            BoardDAO boardDAO = new BoardDAO();
            boardList = boardDAO.getAllBoard();
            WebServerResponse response = context.getResponse();
            response.json(boardList);
            response.ok("Print boards");

        } catch (Exception e) {
            System.out.println("Error : " + e);

        }
        return(boardList);
    }

    public static int getScoreBoard(WebServerContext context) {     //Méthode de récupération du score
        int score = -1;
        try {
            BoardDAO boardDAO = new BoardDAO();
            int boardId = Integer.parseInt(context.getRequest().getParam("boardId"));
            score = boardDAO.getScoreBoard(boardId);

            WebServerResponse response = context.getResponse();
            response.ok("score board");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (score);
    }
}
