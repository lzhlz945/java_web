package pojo;


import java.math.BigDecimal;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: pojo
 * @date:2020/12/11
 */

public class Book {
   private String SN;
   private String name;
   private String author;
   private BigDecimal price;


   public Book() {
   }

   public Book(String SN, String name, String author, BigDecimal price) {
      this.SN = SN;
      this.name = name;
      this.author = author;
      this.price = price;
   }

   @Override
   public String toString() {
      return "Book{" +
              "SN='" + SN + '\'' +
              ", name='" + name + '\'' +
              ", author='" + author + '\'' +
              ", price=" + price +
              '}';
   }
}