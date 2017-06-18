package edu.hm.authorization;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by lapi on 23/05/2017.
 */
public class Token {
    private static Random r = new Random();
    private static  Map<User, Token> mapUserToken = new HashMap<>();
    /**
     * die Tokens aben eine Definierte Länge von 16 chars.
     */
    private String tokn;

    /**
     * Token.
     * @param token t
     */
    Token(String token) {
        this.tokn = token;
    }

    /**
     * has User.
     * @param user u
     * @return b
     */
    public static boolean hasUser(User user) {
        return mapUserToken.containsKey(user);
    }


    /**
     * generiert. für einen bestimmten User ein Token und Speichert dieses dann ab
     * sollte es bereits einen Token zu diesem User geben wird der bereits existierende Token
     * zurück gegeben
     * @param user  user
     * @return t
     */
    public static  Token generateToken(User user) {
        Token token;
        if (!mapUserToken.containsKey(user)) {
            token = new Token(generateToken());
            mapUserToken.put(user, token);
        }
        else {
            token = mapUserToken.get(user);
        }
        return token;

    }

    /**
     * m16.
     */
    private static final int M16 = 16;
    private static final int M26 = 26;
    private static final int M97 = 97;
    /**
     * generiert eine Zufälligen Token.
     * @return ds
     */
    private static String generateToken() {
        String out = "";
        for (int i = 0; i < M16; i++) {
            out += "" + (char)((((char)r.nextInt() % M26) % M26) + M97);
        }
        return out;
    }

    /**
     * grand.
     * @param token t
     * @return b
     */
    public static boolean isAccesGranted(String token) {
       boolean tokenIxist = false;
        Iterator<User> i = mapUserToken.keySet().iterator();
        while (i.hasNext()) {
            User u = i.next();
            if (mapUserToken.containsKey(u)) {
                 if (mapUserToken.get(u).tokn.equals(token)) {
                     tokenIxist = true;
                 break;

            } }
        }
        return tokenIxist;
    }

    /**
     * bla.
     * @return b
     */
    public boolean isAccesGranted() {
        return isAccesGranted(this.getToken());
    }

    /**
     * löscht eden Token zu einen Bestimmten User.
     * @param user user to dell token
     * @return del token succes
     */
    static boolean deleteToken(User user) {
        boolean succes = false;
        Iterator<User> i = mapUserToken.keySet().iterator();
        while (i.hasNext()) {
            User u = i.next();
            if (u.equals(user)) {
                if (mapUserToken.containsKey(u)) {
                    mapUserToken.remove(u);
                    succes = true;
                    break;
                }
            }
        }
        return succes;
    }

    /**
     * get.
     * @return token
     */
    public String getToken() {
        return tokn;
    }

    @Override public String toString() {
        return tokn;
    }

}
