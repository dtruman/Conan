import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableColumn;

import edu.neumont.csc250.lab4.Sorter;


public class MergeSorter<T extends Comparable<T>> implements Sorter<T>
{
	@Override
	public void sort(List<T> unsorted) {
		mergeSort(unsorted, 0, unsorted.size());
	}
	
	public void mergeSort(List<T> toBeSorted, int low, int high)
	{
		int N=high-low;
		if(N<=1)
		{
			return;
		}
		
		int mid=low+N/2;
		
		mergeSort(toBeSorted, low, mid);
		mergeSort(toBeSorted, mid, high);
		
		List<T> temp=new ArrayList<T>();
		
		int i=low, j=mid;
		
		for(int k=0; k<N; k++)
		{
			if(i==mid)
				temp.add(toBeSorted.get(j++));
			else if(j==high)
				temp.add(toBeSorted.get(i++));
			else if(toBeSorted.get(j).compareTo(toBeSorted.get(i))<0)
				temp.add(toBeSorted.get(j++));
			else
				temp.add(toBeSorted.get(i++));
		}
		
		for(int k=0; k<N; k++)
		{
			toBeSorted.set(low+k, temp.get(k));
		}
	}
}
