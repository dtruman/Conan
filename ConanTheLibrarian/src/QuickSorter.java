import java.util.List;

import edu.neumont.csc250.lab4.Sorter;


public class QuickSorter<T extends Comparable<T>> implements Sorter<T>
{
	@Override
	public void sort(List<T> unsorted)
	{
		quickSort(unsorted, 0, unsorted.size()-1);
	}
	
	public int partition(List<T> arr, int left, int right)
	{
	      int i = left, j = right;
	      T tmp;
	      T pivot = arr.get((left + right) / 2);
	     
	      while (i <= j) {
	            while (arr.get(i).compareTo(pivot) < 0)
	                  i++;
	            while (arr.get(j).compareTo(pivot) > 0)
	                  j--;
	            if (i <= j) {
	                  tmp = arr.get(i);
	                  arr.set(i, arr.get(j));
	                  arr.set(j,tmp);
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	public void quickSort(List<T> arr, int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
}
