package Controller;

/**
 * Mikkel is primary contributor for this class
 */
public class User {
   private int accessLevel;
   private String username;
   private String password;
   private String email;

   public User(int accessLevel, String username, String password, String email) {
      this.accessLevel = accessLevel;
      this.username = username;
      this.password = password;
      this.email = email;
   }

   public User() {
      this.accessLevel = 3;
      this.username = "temp";
      this.password = "temp";
      this.email = "temp";
   }

   public int getAccessLevel() {
      return accessLevel;
   }

   public void setAccessLevel(int accessLevel) {
      this.accessLevel = accessLevel;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }
}