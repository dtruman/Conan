import java.util.List;

import edu.neumont.csc250.lab4.Sorter;


public class SelectionSorter<T extends Comparable<T>> implements Sorter<T>
{
	@Override
	public void sort(List<T> toBeSorted) {
		for (int i=0; i<toBeSorted.size()-1; i++) {
	        for (int j=i+1; j<toBeSorted.size(); j++) {
	            if (toBeSorted.get(i).compareTo(toBeSorted.get(j))>0) {
	                T temp = toBeSorted.get(i);
	                toBeSorted.set(i, toBeSorted.get(j));
	                toBeSorted.set(j, temp);
	            }
	        }
	    }
	}
}
