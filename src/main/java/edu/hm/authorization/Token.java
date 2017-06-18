package edu.hm.authorization;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by lapi on 23/05/2017.
 */
public class Token {
    static Random r = new Random();
    static private Map<User,Token> mapUserToken = new HashMap<>();
    /**
     * die Tokens aben eine Definierte Länge von 16 chars
     */
    String tokn;
    Token(String token){
        this.tokn = token;
    }


    public static boolean hasUser(User user){
        return mapUserToken.containsKey(user);
    }


    /**
     * generiert. für einen bestimmten User ein Token und Speichert dieses dann ab
     * sollte es bereits einen Token zu diesem User geben wird der bereits existierende Token
     * zurück gegeben
     * @param user  user
     */
    static public Token generateToken(User user){
        Token token;
        if(!mapUserToken.containsKey(user)) {
            token = new Token(generateToken());
            mapUserToken.put(user, token);
        }
        else
            token = mapUserToken.get(user);
        return token;

    }

    /**
     * generiert eine Zufälligen Token.
     * @return
     */
    private static String generateToken(){
        String out = "";
        for(int i = 0; i<16; i++){
            out += "" + (char)((((char)r.nextInt()%26)%26)+97);
        }
        return out;
    }

    public static boolean isAccesGranted(String token){
       boolean tokenIxist = false;
        Iterator<User> i = mapUserToken.keySet().iterator();
        while(i.hasNext()){
            User u = i.next();
            if(mapUserToken.containsKey(u)){
                 if(mapUserToken.get(u).tokn.equals(token)) {
                     tokenIxist = true;
                 break;

            }}
        }
        return tokenIxist;
    }
    public boolean isAccesGranted(){
        return isAccesGranted(this.getToken());
    }

    /**
     * löscht eden Token zu einen Bestimmten User.
     * @param user user to dell token
     * @return del token succes
     */
    static public boolean deleteToken(User user){
        boolean succes = false;
        Iterator<User> i = mapUserToken.keySet().iterator();
        while(i.hasNext()){
            User u = i.next();
            if(u.equals(user)) {
                if (mapUserToken.containsKey(u)) {
                    mapUserToken.remove(u);
                    succes = true;
                    break;
                }
            }
        }
        return succes;
    }

    public String getToken(){
        return tokn;
    }

    @Override public String toString(){
        return tokn;
    }

}
