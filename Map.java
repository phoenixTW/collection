import java.util.List;
import java.util.ArrayList;

interface ListMap<E,K> {
	K mapCallback(E element, int index, List<E> list);
}

class IntegerMapTwo implements ListMap<Integer, String> {

	public String mapCallback (Integer element, int index, List<Integer> list){
		return element.toString();
	}

}

class IntegerMap implements ListMap<Integer, Integer> {

	public Integer mapCallback (Integer element, int index, List<Integer> list){
		return element.intValue() + 1;
	}

}

class FloatMap implements ListMap<Float, Float> {

	public Float mapCallback (Float element, int index, List<Float> list){
		return element.floatValue() + 1.3f;
	}

}

class CharMap implements ListMap<Character, Character> {

	public Character mapCallback (Character element, int index, List<Character> list){
		return element.charValue();
	}

}
