package gui.Login;

import java.util.HashMap;

public class IDandPasswords {
    //! instead of using a JDBC, we'll just use a hashmap

    HashMap<String,String> loginInfo = new HashMap<>();

    public IDandPasswords(){
        loginInfo.put("a","a");
        loginInfo.put("fadi","a");
        loginInfo.put("aaali","a");
        loginInfo.put("ali","a");
    }

   public HashMap getLoginInfo(){
        return loginInfo;
   }

}
