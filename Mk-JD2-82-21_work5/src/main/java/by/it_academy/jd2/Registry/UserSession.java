package by.it_academy.jd2.Registry;

import java.util.HashSet;
import java.util.Set;

public class UserSession {
    private static UserSession instance;

    private String userName;
    private Set<String>privileges;
    protected UserSession(String userName, Set<String> privileges){
        this.userName=userName;
        this.privileges=privileges;
    }



    private static UserSession getInstance(String userName,Set<String>privileges){
        if (instance==null){
            instance = new UserSession(userName,privileges);
        }
        return  instance;

    }
    public String getUserName(){
        return userName;
    }
    public Set<String> getPrivileges(){
        return privileges;
    }
    public void cleanUserSession(){
        userName = "";
        privileges = new HashSet<>();
    }

    public String toString() {
        return "UserSession{" + "userName='"+userName+'\''+"privileges="+privileges+'}';
    }
}
