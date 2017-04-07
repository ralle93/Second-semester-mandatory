package Controller;

/**
 * Mikkel is primary contributor for this class
 */
public class Item {
   private int id;
   private int quantity;
   private String name;
   private String description;

   public Item(int id, int quantity, String name, String description) {
      this.id = id;
      this.quantity = quantity;
      this.name = name;
      this.description = description;
   }

   public Item(int quantity, String name, String description){
      this.quantity=quantity;
      this.name=name;
      this.description=description;
   }

   public int getId() {
      return id;
   }

   public int getQuantity() {
      return quantity;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

}