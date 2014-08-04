import java.util.Collections;
import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Shelver;


public class GreedyShelver implements Shelver
{
	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {
		int j=0;
		
		MergeSorter ms=new MergeSorter();
		ms.sort(books);
		
		Collections.reverse(books);
		
		for(int i=0; j<books.size() && i<bookcase.getNumberOfShelves(); i++)
		{
			while(j<books.size() && bookcase.getBookshelf(i).getSpaceLeft()>=books.get(j).getWidth())
			{
				bookcase.addBook(i, books.get(j++));
			}
		}
	}
}
