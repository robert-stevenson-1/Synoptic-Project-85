package WaterDistibution.Exceptions;

public class NoSuchUsernameExists extends Exception{
   public NoSuchUsernameExists() {
      super("No such User exists with that username");
   }
}
