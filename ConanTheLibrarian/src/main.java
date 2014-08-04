import java.util.ArrayList;
import java.util.List;

import edu.neumont.csc250.lab4.Book;
import edu.neumont.csc250.lab4.Bookcase;
import edu.neumont.csc250.lab4.Sorter;


public class main
{
	public static void main(String[] args) {
		//selection();
		//quick();
		//merge();
		//greedyShelver();
		dynamicShelver();
	}
	
	static public void selection()
	{
		List<Integer> stuff=new ArrayList<Integer>();
		stuff.add(2);
		stuff.add(1);
		stuff.add(9);
		stuff.add(5);
		stuff.add(3);
		stuff.add(2);
		
		SelectionSorter s = new SelectionSorter();
		
		s.sort(stuff);
		
		for(int i=0; i<stuff.size(); i++)
		{
			System.out.println(stuff.get(i));
		}
	}
	
	static public void quick()
	{
		List<Integer> stuff=new ArrayList<Integer>();
		stuff.add(2);
		stuff.add(1);
		stuff.add(9);
		stuff.add(5);
		stuff.add(3);
		stuff.add(2);
		
		QuickSorter qs=new QuickSorter();
		
		qs.sort(stuff);
		
		for(int i=0; i<stuff.size(); i++)
		{
			System.out.println(stuff.get(i));
		}
	}
	
	static public void merge()
	{
		List<Integer> stuff=new ArrayList<Integer>();
		stuff.add(2);
		stuff.add(1);
		stuff.add(9);
		stuff.add(5);
		stuff.add(2);
		stuff.add(3);
		
		MergeSorter ms=new MergeSorter();
		
		ms.sort(stuff);
		
		for(int i=0; i<stuff.size(); i++)
		{
			System.out.println(stuff.get(i));
		}
		
	}
	
	static public void greedyShelver()
	{
		GreedyShelver gs=new GreedyShelver();
		
		List<Book> books=new ArrayList<Book>();
		Book b=new Book("One", 3,4);
		books.add(b);
		Book b2=new Book("Two",2,2);
		books.add(b2);
		Book b3=new Book("One", 5,2);
		books.add(b3);
		Book b4=new Book("Two",6,4);
		books.add(b4);
		Bookcase bc=new Bookcase(3, 8);
		
		gs.shelveBooks(bc, books);
		
		for(int i=0; i<bc.getNumberOfShelves(); i++)
		{
			System.out.println("Number of books " + bc.getBookshelf(i).getBookCount());
			System.out.println("Space Left " + bc.getBookshelf(i).getSpaceLeft());
		}
	}
	
	static public void dynamicShelver()
	{
		DynamicShelver ds=new DynamicShelver();
		
		List<Book> books=new ArrayList<Book>();
		Book b=new Book("One", 3,4);
		books.add(b);
		Book b2=new Book("Two",2,2);
		books.add(b2);
		Book b3=new Book("One", 5,2);
		books.add(b3);
		Book b4=new Book("Two",6,4);
		books.add(b4);
		Bookcase bc=new Bookcase(3, 8);
		
		ds.shelveBooks(bc, books);
		
		System.out.println(bc);
		for(int i=0; i<bc.getNumberOfShelves(); i++)
		{
			System.out.println("Number of books " + bc.getBookshelf(i).getBookCount());
			System.out.println("Space Left " + bc.getBookshelf(i).getSpaceLeft());
		}
	}
}
