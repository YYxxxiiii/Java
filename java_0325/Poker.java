package java15_0325;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 这是一张牌
class Card {
    private String rank;  // 点数
    private String suit;  // 花色

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
//        return "Card{" +
//                "rank='" + rank + '\'' +
//                ", suit='" + suit + '\'' +
//                '}';
        return "[" + this.suit + this.rank + "]";
    }
}

public class Poker {
    public static void main(String[] args) {
        // 1. 创建一副牌
        List<Card> poker = buyPoker();
        // 2. 洗牌, 最简单的办法, 可以直接使用 Collections.shuffle 方法
        //    把 List 中的元素随机打乱顺序
        //    shuffle 如果想自己实现, 也可以. 办法有很多.
        //    一种简单的办法: 从后往前遍历 List, 取出当前元素, 再生成一个随机位置.
        //    把当前元素和随机位置的元素交换即可
        Collections.shuffle(poker);
        // 3. 发牌. 假设有三个玩家, 每人发五张牌(梭哈)
        //    每个玩家就是一个 List, 就可以把每个人的手牌放到这个 List 中.
        //    可以把这多个玩家的信息再放到一个 List 中
        //    players 这就表示所有的玩家手牌.
        //    每个元素就是一个玩家的所有手牌(也是一个 List)
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        // 给三个玩家发牌, 没人发五张牌
        // i 表示牌的编号, j 表示玩家编号
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                List<Card> player = players.get(j);
                // remove 表示删除 List 中指定下标的元素
                // remove 返回值表示删除的这个元素是啥
                Card card = poker.remove(0);
                player.add(card);
            }
        }
        // 到这一步, 玩家发牌结束, 可以查看玩家的手牌了
        for (int i = 0; i < 3; i++) {
            System.out.println("玩家" + i + ": " + players.get(i));
        }
    }

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();

        // 红桃, 黑桃, 梅花, 方片
        String[] suits = {"♥", "♠", "♣", "♦"};

        for (int i = 0; i < 4; i++) {
            // 这个循环来处理四种花色
            // 每种花色又有十三张牌
            for (int j = 2; j <= 10; j++) {
                // j 表示点数. int => String
                // "" + j
                // String.valueOf(j)
                poker.add(new Card("" + j, suits[i]));
            }
            poker.add(new Card("J", suits[i]));
            poker.add(new Card("Q", suits[i]));
            poker.add(new Card("K", suits[i]));
            poker.add(new Card("A", suits[i]));
        }
        return poker;
    }
}
