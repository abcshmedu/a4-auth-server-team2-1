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
            out += (char)(r.nextInt()%255);
        }
        return out;
    }

    static boolean isAccesGranded(String token){
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
    static public boolean deleteToken(User user){
        boolean succes = false;
        Iterator<User> i = mapUserToken.keySet().iterator();
        while(i.hasNext()){
            User u = i.next();
            if(u.equals(user)) {
                if (mapUserToken.containsKey(u)) {
                    mapUserToken.remove(u);
                    break;
                }
            }
        }
        return succes;
    }

    public String getToken(){
        return tokn;
    }

}
