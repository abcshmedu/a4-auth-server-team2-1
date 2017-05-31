package edu.hm.shareit.resources;

import org.junit.Test;

/**
 * Created by MatHe on 31.05.2017.
 */
public class IsbnTest {
    @Test
    public void firstCheck(){
        Book.checkIsbn("1234567890");
    }
}
