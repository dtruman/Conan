import java.util.Collections;
import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Shelver;


public class DynamicShelver implements Shelver
{
	@Override
	public void shelveBooks(Bookcase bookcase, List<Book> books) {
		MergeSorter ms=new MergeSorter();
		ms.sort(books);
		
		Collections.reverse(books);
		
		bookWrap(books, bookcase, books.size(), bookcase.getShelfWidth());
	}
	
	public void bookWrap(List<Book> books, Bookcase bc, int size, int shelfSize)
	{
		int[][] extraSpace=new int[size+1][size+1];
		int[][] spaceCost=new int[size+1][size+1];
		int[] opt=new int[size+1];
		int[] solution=new int[size+1];
		
		for(int i=1; i<=size; i++)
		{
			extraSpace[i][i]=shelfSize-books.get(i-1).getWidth();
			for(int j=i+1; j<=size; j++)
				extraSpace[i][j]=extraSpace[i][j-1]-books.get(j-1).getWidth();
		}
		
		for(int i=1; i<=size; i++)
		{
			for(int j=i; j<=size; j++)
			{
				if(extraSpace[i][j]<0)
					spaceCost[i][j]=Integer.MAX_VALUE;
				else
					spaceCost[i][j]=extraSpace[i][j]*extraSpace[i][j];
			}
		}
		
		opt[0]=0;
		
		for(int j=1; j<=size; j++)
		{
			opt[j]=Integer.MAX_VALUE;
			for(int i=1; i<=j; i++)
			{
				if(opt[i-1]!=Integer.MAX_VALUE && spaceCost[i][j]!=Integer.MAX_VALUE && (opt[i-1] + spaceCost[i][j]<opt[j]))
				{
					opt[j]=opt[i-1]+spaceCost[i][j];
					solution[j]=i;
				}
			}
		}
		
		solution(solution, size, bc, books);
	}
	
	public int solution(int solution[], int size, Bookcase bc, List<Book> books)
	{
		int k;
		if(solution[size]==1)
			k=1;
		else
			k=solution(solution, solution[size]-1, bc, books)+1;

		for(int i=solution[size]; i<=size; i++)
		{
			bc.addBook(k-1, books.get(i-1));
		}

		return k;
	}
}
