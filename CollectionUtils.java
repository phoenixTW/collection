import java.util.List;
import java.util.ArrayList;

class CollectionUtils {
	public static List<Integer> filter (List<Integer> list, ListFilter callback) {
		List<Integer> newList = new ArrayList<Integer>();
		
		for (int counter = 0; counter < list.size(); counter++) {
			if(callback.filterCallback(list.get(counter), counter, list)){
				newList.add(list.get(counter));	
			}			
		}

		return newList;
	}

	public static List<Integer> map (List<Integer> list, ListMap callback) {
		List<Integer> newList = new ArrayList<Integer>();
		int counter = -1;

		for (Integer value : list) {
			Integer result = (Integer)callback.mapCallback(value, ++counter, list);
			newList.add(result);
		}

		return newList;
	}
}
