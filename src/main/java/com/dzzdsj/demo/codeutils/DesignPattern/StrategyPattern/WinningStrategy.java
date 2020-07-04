package com.dzzdsj.demo.codeutils.DesignPattern.StrategyPattern;

import java.util.Random;

/**
 * 策略一：获胜沿用上次的手势
 */
public class WinningStrategy implements Strategy {
    private Random random;
    private boolean won = false;
    //上次的手势
    private Hand prevHand;

    public WinningStrategy(int seed) {
        random = new Random(seed);
    }

    @Override
    public Hand nextHand() {
        if (!won) {
            prevHand = Hand.getHand(random.nextInt(3));
        }
        return prevHand;
    }

    @Override
    public void study(boolean win) {
        won = win;
    }
}
