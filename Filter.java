import java.util.List;
import java.util.ArrayList;

interface ListFilter<E> {
	boolean filterCallback(E element, int index, List<E> list);
}

class IntegerFilter implements ListFilter<Integer> {

	public boolean filterCallback (Integer element, int index, List<Integer> list){
		return (element.intValue()) > 1;
	}

}

class FloatFilter implements ListFilter<Float> {

	public boolean filterCallback (Float element, int index, List<Float> list){
		return (element.intValue()) > 1.2;
	}

}

