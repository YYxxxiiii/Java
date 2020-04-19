package java_0419;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        return "[" + this.suit + this.rank + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        //1.创建一副牌
        List<Card> poker = buyPoker();
        //2.洗牌
        Collections.shuffle(poker);
        //3.发牌,假设三个人,每人发五张牌
        //每个玩家就是一个List,就可以把每个人的牌放到这个List中
        //可以把这多个玩家的信息再放到一个List中
        //players这就表示所有的玩家手牌
        //每个元素就是一个玩家的所有手牌(一个List)
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());

        //i-牌的编号
        //j-玩家编号
        for (int i = 0;i < 5;i++){
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                // remove 表示删除 List 中指定下标的元素
                // remove 返回值表示删除的这个元素是啥
                Card card = poker.remove(0);
                player.add(card);
            }
        }

        //到了这一步,发牌结束,玩家可以查看手牌了
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ":" + players.get(i));
        }
    }

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();

        String[] suits = {"♥","♠","♣","♦"};

        //i-花色
        //j-点数
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10; j++) {
                //"" + j 就得到了一个字符串
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
