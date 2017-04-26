package edu.hm.shareit.resources;

/**
 * Created by MatHe on 26.04.2017.
 */
public class Copy {
    private Medium medium;
    private String owner;

    public Copy(String owner,Medium medium) {
        this.medium = medium;
        this.owner = owner;
    }

    public Medium getMedium() {
        return medium;
    }

    public String getOwner() {
        return owner;
    }




    /*
    Create app (Browser)
    changed pom.xml from
    <appName>guarded-earth-88409</appName>
    to
    <appName>matthiastestapp</appName>

    cmd: mvn heroku:deploy-war
    sollte unter https://matthiastestapp.herokuapp.com/



     */
}
