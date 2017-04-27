package edu.hm.shareit.resources;

import org.json.JSONObject;

import javax.ws.rs.core.Response;
import java.util.*;

/**
 * Created by MatHe on 26.04.2017.
 */
public class MediaServiceImpl implements MediaService {

    static Set<Book> bookList = new HashSet<>();


    @Override
    public MediaServiceResult addBook(Book book) {
        MediaServiceResult out = MediaServiceResult.OK;
        if(Book.isValid(book)) {
            if (!MediaServiceImpl.existBook(book))
                bookList.add(book);
            else
                out = MediaServiceResult.CONFLICT;
        }
        else
            out = MediaServiceResult.BAD_REQUEST;
        return out;

    }

    @Override
    public MediaServiceResult addDisk(Disc disc) {
        return null;
    }

    @Override
    public Medium[] getBooks() {
        ArrayList<Medium> out = new ArrayList<>();
        Iterator<Book> i = bookList.iterator();
        while(i.hasNext())
            out.add(i.next());

        return (Medium[]) out.toArray();
    }

    @Override
    public Medium[] getDiscs() {
        return new Medium[0];
    }

    @Override
    public MediaServiceResult updateBook(Book book) {
        return null;
    }

    @Override
    public MediaServiceResult updateDisc(Disc disc) {
        return null;
    }


    static public  boolean existBook(Book that){
        boolean exist = false;
        Iterator<SharItBook> it = SharItBook.getAllBooks();
        while(it.hasNext()){
            SharItBook n = it.next();
            // System.out.println("is " +that +" eq to " + n);
            if(n.equals(that)) {
                // System.out.println("is Eq");
                exist = true;
                break;
            }
        }
        return exist;
    }
}
