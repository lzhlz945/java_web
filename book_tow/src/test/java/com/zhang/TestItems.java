package com.zhang;

import com.zhang.pojo.Cart;
import com.zhang.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/18
 */
public class TestItems {
    private Cart cart=new Cart();

    @Test
    public void selectMap(){
        Map<Integer, CartItem> items = cart.getItems();
        for (Map.Entry<Integer, CartItem> integerCartItemEntry : items.entrySet()) {


            System.out.println(integerCartItemEntry.getKey()+": "+integerCartItemEntry.getValue());
        }


    }
    @Test
    public void testAdd(){

        cart.addItems(  new CartItem(2,"vivo手机",1,new BigDecimal(4000),new BigDecimal(4000)));
        cart.addItems(  new CartItem(3,"vivo手机",1,new BigDecimal(4000),new BigDecimal(4000)));
        cart.addItems(  new CartItem(4,"vivo手机",1,new BigDecimal(4000),new BigDecimal(4000)));

        Integer integer = cart.totalCount();
        BigDecimal bigDecimal = cart.totalPrice();
        System.out.println(bigDecimal);
        System.out.println(integer);
        System.out.println(cart);



    }
    @Test
    public void testDelete(){

        Integer id=1;
       cart.deleteItems(id);
        Map<Integer, CartItem> items = cart.getItems();

    }
}
