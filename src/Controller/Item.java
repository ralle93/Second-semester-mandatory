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
   public Item(){}

   public Item(int quantity, String name, String description){
      this.quantity=quantity;
      this.name=name;
      this.description=description;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}