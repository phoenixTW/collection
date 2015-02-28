import java.util.List;
import java.util.ArrayList;

class CollectionUtils {
	public static<E> List<E> filter (List<E> list, ListFilter callback) {
		List<E> newList = new ArrayList<E>();
		
		for (int counter = 0; counter < list.size(); counter++) {
			if(callback.filterCallback(list.get(counter), counter, list)){
				newList.add(list.get(counter));	
			}			
		}

		return newList;
	}

	public static<E,K> List<K> map (List<E> list, ListMap<E,K> callback) {
		List<K> newList = new ArrayList<K>();
		int counter = -1;

		for (E value : list) {
			K result = callback.mapCallback(value, ++counter, list);
			newList.add(result);
		}

		return newList;
	}

	public static<E,K> K reduce (List<E> list, ListReducer<E,K> callback, K initial) {
		int counter = -1;

		for (E value : list) {
			initial = callback.reduceCallback(initial, value, ++counter, list);
		}

		return initial;
	} 
}
