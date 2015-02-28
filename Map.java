import java.util.List;
import java.util.ArrayList;

interface ListMap<E> {
	E mapCallback(E element, int index, List<E> list);
}

class IntegerMap implements ListMap<Integer> {

	public Integer mapCallback (Integer element, int index, List<Integer> list){
		return element.intValue() + 1;
	}

}

class FloatMap implements ListMap<Float> {

	public Float mapCallback (Float element, int index, List<Float> list){
		return element.floatValue() + 1.3f;
	}

}

class CharMap implements ListMap<Character> {

	public Character mapCallback (Character element, int index, List<Character> list){
		return element.charValue();
	}

}
