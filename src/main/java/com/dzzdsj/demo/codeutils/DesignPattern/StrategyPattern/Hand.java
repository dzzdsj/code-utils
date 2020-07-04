package com.dzzdsj.demo.codeutils.DesignPattern.StrategyPattern;

/**
 * 扮演手势的类,它不属于策略模式的角色
 */
public class Hand {
    //石头
    public static final int HANDVALUE_GUU = 0;
    //剪刀
    public static final int HANDVALUE_CHO = 1;
    //布
    public static final int HANDVALUE_PAA = 2;

    private int handValue;

    //对外隐藏构造函数
    private Hand(int handValue) {
        this.handValue = handValue;
    }

    /**
     * 生成三种手势的单例放入数组
     */
    public static final Hand[] hands = {
            new Hand(HANDVALUE_GUU),
            new Hand(HANDVALUE_CHO),
            new Hand(HANDVALUE_PAA)
    };
    public static final String[] names = {
            "石头",
            "剪刀",
            "布"
    };

    public static Hand getHand(int handValue) {
        return hands[handValue];
    }

    public boolean isStrongerThen(Hand hand) {
        return fight(hand) == 1;
    }

    public boolean isWeakerThen(Hand hand) {
        return fight(hand) == -1;
    }

    /**
     * 猜拳比大小
     *
     * @param hand
     * @return
     */
    private int fight(Hand hand) {
        //平局
        if (this == hand) {
            return 0;
        }
        //胜利
        if ((this.handValue + 1) % 3 == hand.handValue) {
            return 1;
        }
        //输了
        return -1;
    }

    //输出对应手势的中文字符串
    @Override
    public String toString() {
        return names[handValue];
    }
}
