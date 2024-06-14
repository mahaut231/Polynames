package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolynamesDatabase;
import models.Card;

public class CardDAO {

    public CardDAO() {
    }

    public ArrayList<Card> getAllCard() {       //Méthode de récupération de toute les cartes
        ArrayList<Card> CardList = new ArrayList<>();
        try {

            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "SELECT * FROM card;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultsSQL = prepRequestSQL.executeQuery();

            while (resultsSQL.next()) {
                int cardId = resultsSQL.getInt("cardId");
                String cardWord = resultsSQL.getString("cardWord");
                boolean cardState = resultsSQL.getBoolean("cardState");
                Card Card = new Card(cardId, cardWord, cardState, 0);
                CardList.add(Card);
            }

        } catch (Exception e) {     //gestion des exceptions 
            System.out.println("Error :" + e);
        }

        return (CardList);
    }

    public Card getCard(int i) {        //méthode de récupération d'une carte par son ID
        String cardWord = "Undefined";
        Boolean cardState = false;
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "SELECT * FROM card;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            ResultSet resultSQL = prepRequestSQL.executeQuery();
            while (resultSQL.next()) {
                int cardId = resultSQL.getInt("cardId");
                cardWord = resultSQL.getString("cardWord");
                cardState = resultSQL.getBoolean("cardState");
                if (cardId == i) {      //si on tombe sur la carte recherché alors ...
                    Card card = new Card(cardId, cardWord, cardState, 0);
                    return (card);
                }
            }

        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
        Card card = new Card(i, cardWord, cardState, 0);
        return (card);
    }

    public void revealCard(int i) {     //Méthode pour changer l'état de la carte : caché ==> dévoilée
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "UPDATE card SET cardState = true WHERE cardId = ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, i);
            prepRequestSQL.executeUpdate();     //exécution de la requête SQL avec executeUpdate() (car on utilise UPDATE)
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

    public void colorCard(int ind, int col) {       //Méthode d'attribution de couleur à une carte
        try {
            PolynamesDatabase PolyNamesGR = new PolynamesDatabase();
            String requestSQL = "UPDATE card SET cardColor = ? WHERE cardId = ?;";
            PreparedStatement prepRequestSQL = PolyNamesGR.prepareStatement(requestSQL);
            prepRequestSQL.setInt(1, col);
            prepRequestSQL.setInt(2, ind);
            prepRequestSQL.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error : " + e);
        }
    }

}
