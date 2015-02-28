import java.util.List;
import java.util.ArrayList;

interface ListReducer<E,K> {
	K reduceCallback(K previous, E current, int index, List<E> list);
}

class IntListReducer implements ListReducer<Integer, Integer> {
	
	public Integer reduceCallback (Integer previous, Integer current, int index, List<Integer> list){
		return previous.intValue() + current.intValue();
	}	
}

class SumReducer implements ListReducer<Integer,Integer> {
	public Integer reduceCallback (Integer pv, Integer cv , int index, List<Integer> list) {
		return pv.intValue()+cv.intValue();
	}
}