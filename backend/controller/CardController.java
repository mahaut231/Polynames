package controller;

import dao.CardDAO;

import java.util.ArrayList;



import models.Card;

import webserver.WebServerContext;
import webserver.WebServerResponse;

public class CardController {
    
    public CardController(){}   //Constructeur

    public static ArrayList<Card> getAllCard(WebServerContext context) {    //Méthode de récupération de toutes les cartes
        ArrayList<Card> cardList = new ArrayList<>();
        try {
            CardDAO cardDAO = new CardDAO();
            cardList = cardDAO.getAllCard();
            WebServerResponse response = context.getResponse();
            response.json((cardList));
            response.ok("Print cards");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (cardList);
    }

    public static Card getCard(WebServerContext context) {      //Méthode de récupération d'une carte par son ID
        Card card = new Card(0, null, false, 0);
        try {
            CardDAO cardDAO = new CardDAO();
            String cardId = context.getRequest().getParam("cardId");
            int intcardId = Integer.parseInt(cardId);
            card = cardDAO.getCard(intcardId);

            WebServerResponse response = context.getResponse();
            response.json((card));

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        return (card);
    }

    public static void revealCard(WebServerContext context) {   //Méthode de changement détat d'une carte : caché ==> dévoilée
        try {
            CardDAO cardDAO = new CardDAO();
            String cardId = context.getRequest().getParam("cardId");
            int intcardId = Integer.parseInt(cardId);
            cardDAO.revealCard(intcardId);

            WebServerResponse response = context.getResponse();
            response.ok("reveal card");
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public static void colorCard(WebServerContext context) {    //Méthode de changement de couleur de carte
        try {
            CardDAO cardDAO = new CardDAO();
            int cardId = Integer.parseInt(context.getRequest().getParam("cardId"));
            int cardColor = Integer.parseInt(context.getRequest().getParam("cardColor"));
            cardDAO.colorCard(cardId, cardColor);

            WebServerResponse response = context.getResponse();
            response.ok("color card");

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }
}
