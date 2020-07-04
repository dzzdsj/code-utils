package com.dzzdsj.demo.codeutils.DesignPattern.StrategyPattern;

/**
 * 猜拳的策略
 */
public interface Strategy {
    /**
     * 下一次出拳
     *
     * @return
     */
    Hand nextHand();

    /**
     * 根据上一次出拳的胜负结果调整出拳的策略
     *
     * @param win
     */
    void study(boolean win);
}
