package com.chinawyny.designpattern.face;


import java.util.Random;

/**
 * 用户要购买一件商品，系统首先会判断库存，
 * 然后要计算费用（商品价格，邮费和优惠等），
 * 最后才会生成一个订单。
 * <p>
 * 这其中就包含几个子系统，库存管理子系统和计费子系统，
 * 而计费子系统又分更小的子系统（此处两处使用到外观模式）。
 */

//获取商品价格
class ProductPrice {
    
    int getPrice(String product) {
        return Math.abs(product.hashCode());//模拟获取商品价格
    }
    
}

//计算邮费
class Postage {
    int getPostage(String addr) {
        return Math.abs(addr.hashCode()) % 20 + 6;//模拟邮费计算
    }
}

//计算优惠
class Discount {
    int getDiscount(String discountCode) {
        return Math.abs(discountCode.hashCode()) % 3;
    }
}

/**
 * 外观模式
 * <p>
 * 外观模式可以让一个系统更加容易使用
 * <p>
 * 我们提供给用户的某个功能，可能是包含很多个步骤的，
 * 但我们可以把这些步骤封装到一个统一的接口中，让用户感觉仅仅就是一个单一的操作，使用起来也就更加简单。
 */

/**
 * 计算最终价格的子系统，同时他也是一个外观，因为它含有以上三个子系统的引用
 * <p>
 * 计费子系统
 */
public class FinalPrice {
    
    ProductPrice productPrice;
    
    Postage postage;
    
    Discount discount;
    
    public FinalPrice() {
        
        productPrice = new ProductPrice();
        postage = new Postage();
        discount = new Discount();
        
    }
    
    int getFinalPrice(String product, String addr, String discountCode) {
        return productPrice.getPrice(product) + postage.getPostage(addr) - discount.getDiscount(discountCode);
    }
    
    public static void main(String[] args) {
    
    }
}

//库存子系统
class Stock {
    boolean hasStock(String product) {
        return new Random().nextInt(Math.abs(product.hashCode())) > 0;//模拟是否还有库存
    }
}

// 面向用户的购买接口，在这里也是一个外观，同时，这里使用了枚举实现的单例模式：
enum ProductSalesman {
    
    instance;
    Stock stock = new Stock();
    FinalPrice finalPrice = new FinalPrice();
    
    Object buySomething(String product, String addr, String discountCode) {
        if (!stock.hasStock(product))
            return "库存不足";
        int price = finalPrice.getFinalPrice(product, addr, discountCode);
        return "订单信息:" + product + "-" + addr + "-" + discountCode + "-" + price;
    }
}








