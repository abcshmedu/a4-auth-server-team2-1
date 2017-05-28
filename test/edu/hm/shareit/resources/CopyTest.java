package edu.hm.shareit.resources;

import edu.hm.authorization.User;
import org.junit.Test;

/**
 * Created by MatHe on 28.05.2017.
 */
public class CopyTest {

    @Test
    public void firstBlancTest(){
        Book book = new Book();
        Copy copy = new Copy("user123",book);
        copy.getMedium();
        copy.getOwner();
    }
}
