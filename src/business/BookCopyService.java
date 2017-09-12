package business;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

import java.util.HashMap;

public class BookCopyService{
    public void AddBookCopy(String isbn) throws LibrarySystemException {
        if(isbn == null || isbn.trim().equals("")){
            throw new LibrarySystemException("isbn can not be empty!");
        }
        DataAccess da = new DataAccessFacade();

        Book book = da.findBookByIsbn(isbn);

        if(book == null){
            throw new LibrarySystemException("The book whose isbn is "+isbn+" doesn't exist!");
        }

        book.addCopy();

        da.saveBook(book);
    }
}
