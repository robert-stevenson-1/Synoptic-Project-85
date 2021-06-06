/**
 * Class: DataStorage
 * Author: Robert Stevenson
 * Contributing Author(s):
 *
 * Date Created: 06/06/2021
 *
 * Description:
 *
 */
package WaterDistibution;

import WaterDistibution.Exceptions.InvalidPasswordException;
import WaterDistibution.Exceptions.NoSuchUsernameExists;
import WaterDistibution.Model.User;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Hashtable;

public abstract class DataStorage implements Serializable {

   private static Hashtable<String, User> users = new Hashtable<String, User>();
   //user is currently logged into the system
   private static User CurrentUser = new User();

   //-------------
   //---SETTERS---
   //-------------

   public static void setCurrentUser(User currentUser) {
      CurrentUser = currentUser;
   }

   //-------------
   //---GETTERS---
   //-------------

   public static boolean userExists(String username){
      return users.containsKey(username);
   }

   public static User getUser(String username, String password) throws NoSuchUsernameExists, InvalidPasswordException {
      //check if a user with that username exists
      if (userExists(username)){
         //user found, check to see if the password entered is correct
         User user = users.get(username);
         if(hashPassword(user.getPassword()) == hashPassword(password)){
            //password matches return the user
            return user;
         }else {
            return throw new InvalidPasswordException();
         }
      }else{
         return throw new NoSuchUsernameExists();
      }
   }


   //-----------
   //--UTILITY--
   //-----------

   /**
    * Hash Passwords for security when saving login account information
    * about a users using SHA-512 with some 'salt' to improve the security
    *
    * Link reference:
    * https://howtodoinjava.com/java/java-security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
    *
    * @param rawPassword the raw unencrypted password that is to be hashed
    * @return return a hashed and encrypted version of the 'rawPassword'
    */
   private static String hashPassword(String rawPassword){

      String hashPassword = null;

      try {
         //create a MessageDigest instance for SHA-512
         MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");

         //add salt to the password bytes to digest
         messageDigest.update(getSalt());

         //get the decimal formatted hash's bytes
         byte[] hashBytes = messageDigest.digest(rawPassword.getBytes());

         //convert bytes from DEC to HEX format
         StringBuilder stringBuilder = new StringBuilder();
         for (int i = 0; i < hashBytes.length; i++) {
            stringBuilder.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
         }

         //get a completed hashed password in HEX
         hashPassword = stringBuilder.toString();

      } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
         e.printStackTrace();
      }

      //return the hashed password
      return hashPassword;
   }

   private byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
      // 'SHA1PRNG' is the pseudo-random number generation algorithm  based on the
      // SHA-1 message digest algorithm and supplied by the provider 'SUN'
      SecureRandom secRand = SecureRandom.getInstance("SHA1PRNG", "SUN");

      //salt array
      byte[] salt = new byte[16];
      //create the random salt
      secRand.nextBytes(salt);

      //return the salt
      return salt;
   }


}
