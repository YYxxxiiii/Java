package java_0415;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//这是一张牌
class Card {
    private String rank;//点数
    private String suit;//花色

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}

public class Poker {
    public static void main(String[] args) {
        List<Card> poker = buyPoker();
    }

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();

        String[] suits = {"♥","♠","♣","♦"};

        for (int i = 0;i < 4;i++) {
            for (int j = 2; j <= 10; j++) {
                poker.add(new Card("" + j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
            poker.add(new Card("A",suits[i]));
        }
        return poker;
    }
}
