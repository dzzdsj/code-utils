package com.dzzdsj.demo.codeutils.DesignPattern.FactoryPattern;

/**
 * 抽象类：定义工厂
 */
public abstract class Factory {
    /**
     * 生成产品实例
     *
     * @param owner
     * @return
     */
    public final Product create(String owner) {
        Product product = createProduct(owner);
        registerProduct(product);
        return product;
    }

    /**
     * 生成产品
     *
     * @param owner
     * @return
     */
    protected abstract Product createProduct(String owner);

    /**
     * 注册产品
     *
     * @param product
     */
    protected abstract void registerProduct(Product product);
}
