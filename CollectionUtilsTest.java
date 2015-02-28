import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class CollectionUtilsTest {

	@Test
	public void filter_should_return_2_for_1_and_2 () {
		ListFilter integerFilter = new IntegerFilter();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		
		List<Integer> newList = CollectionUtils.<Integer>filter(list, integerFilter);
		assertEquals(newList.get(0), expected.get(0));
	}

	@Test
	public void filter_should_return_2_2_for_1_1_and_2_1 () {
		ListFilter floatFilter = new FloatFilter();
		List<Float> list = new ArrayList<Float>();
		list.add(1.1f);
		list.add(2.2f);
		
		List<Float> expected = new ArrayList<Float>();
		expected.add(2.2f);
		
		List<Float> newList = CollectionUtils.<Float>filter(list, floatFilter);
		assertEquals(newList.get(0), expected.get(0));
	}

	@Test
	public void map_should_return_2_3_for_1_and_2 () {
		ListMap integerMap = new IntegerMap();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		expected.add(3);
		
		List<Integer> newList = CollectionUtils.<Integer, Integer>map(list, integerMap);
		assertEquals(newList.get(0), expected.get(0));
		assertEquals(newList.get(1), expected.get(1));
	}

	@Test
	public void map_should_return_2_3_and_3_3_for_1_0_and_2_0 () {
		ListMap floatMap = new FloatMap();
		List<Float> list = new ArrayList<Float>();
		list.add(1.0f);
		list.add(2.0f);
		
		List<Float> expected = new ArrayList<Float>();
		expected.add(2.3f);
		expected.add(3.3f);
		
		List<Float> newList = CollectionUtils.<Float, Float>map(list, floatMap);
		assertEquals(newList.get(0), expected.get(0));
		assertEquals(newList.get(1), expected.get(1));
	}

	@Test
	public void map_should_return_c_d__for_a_b () {
		ListMap charMap = new CharMap();
		List<Character> list = new ArrayList<Character>();
		list.add('a');
		list.add('b');
		
		List<Character> expected = new ArrayList<Character>();
		expected.add('a');
		expected.add('b');
		
		List<Character> newList = CollectionUtils.<Character, Character>map(list, charMap);
		assertEquals(newList.get(0), expected.get(0));
		assertEquals(newList.get(1), expected.get(1));
	}

	@Test
	public void map_should_return_string_representation_of_numbers () {
		ListMap<Integer, String> intMap = new IntegerMapTwo();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		List<String> expected = new ArrayList<String>();
		expected.add("1");
		expected.add("2");
		
		List<String> newList = CollectionUtils.<Integer, String>map(list, intMap);
		assertEquals(newList.get(0), expected.get(0));
		assertEquals(newList.get(1), expected.get(1));
	}

	@Test
	public void reduce_should_return_3_for_1_and_2 () {
		ListReducer<Integer, Integer> intReduce = new IntListReducer();
		List<Integer> list = new ArrayList<Integer>();
		Integer initial = new Integer(0);
		Integer expected = new Integer(3);

		list.add(1);
		list.add(2);
		
		Integer newList = CollectionUtils.<Integer, Integer>reduce(list, intReduce, initial);
		assertEquals(newList.intValue(), expected.intValue());
	}

	@Test
	public void reduce_returns_the_sum_of_all_numbers (){
		ListReducer<Integer,Integer> listReducer = new SumReducer();
		List<Integer> numbers = new ArrayList<Integer>();
		Integer initial = new Integer(0);
		Integer expected = new Integer(6);

		numbers.add(1);
		numbers.add(2);
		numbers.add(3);

		Integer sum = CollectionUtils.<Integer,Integer>reduce(numbers,listReducer,initial);
		assertEquals(expected,sum);
	}

	@Test
	public void reduce_should_return_3_3_for_1_1_and_2_2 () {
		ListReducer<Float, Float> floatReduce = new FloatListReducer();
		List<Float> list = new ArrayList<Float>();
		Float initial = new Float(0.0f);
		Float expected = new Float(3.3f);

		list.add(1.1f);
		list.add(2.2f);
		
		Float newList = CollectionUtils.<Float, Float>reduce(list, floatReduce, initial);
		assertEquals(newList.intValue(), expected.intValue());
	}
}