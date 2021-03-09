package com.zhang.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.pojo
 * @date:2020/12/18
 */
@Data
public class Cart {
    /**
     * key:是商品编号
     * value:是商品信息
     */
    private  Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    //添加商品：
    public  void addItems(CartItem cartItem){

        CartItem item = items.get(cartItem.getId());
        if(null == item){
           items.put(cartItem.getId(),cartItem);

        }else {
            item.setCount(item.getCount()+1);

            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
            items.put(cartItem.getId(),item);

        }

    }

    //删除商品
    public void deleteItems(Integer id){
        items.remove(id);
    }

    //清空购物车
    public void emptyItems(){
        items.clear();
    }

    //修改商品数量

    public void updateItemsCount(Integer id,Integer count)
    {

        CartItem item = items.get(id);
        if(null != item) {
            item.setCount(count);
            items.put(id,item);
        }else {
            return;
        }

    }

    //获取总数量
    public Integer totalCount(){
        Integer sum=0;
        for (CartItem value : items.values()) {
            sum+=value.getCount();
        }

        return sum;
    }

    //获取总价格
    public BigDecimal totalPrice(){
        BigDecimal decimal = new BigDecimal(0);
        for (CartItem value : items.values()) {
            decimal=decimal.add(value.getTotalPrice());
        }


        return decimal;


    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
