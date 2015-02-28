import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

interface ListFilter<Integer> {
	boolean filterCallback(Integer element, int index, List<Integer> list);
}

interface ListMap<Integer> {
	Integer mapCallback(Integer element, int index, List<Integer> list);
}

class IntegerFilter implements ListFilter<Integer> {

	public boolean filterCallback (Integer element, int index, List<Integer> list){
		return (element.intValue()) > 1;
	}

}

class IntegerMap implements ListMap<Integer> {

	public Integer mapCallback (Integer element, int index, List<Integer> list){
		return element.intValue() + 1;
	}

}

public class CollectionUtilsTest {

	@Test
	public void add_1_and_2_gives_3 () {
		assertEquals(1 + 2, 3);
	}

	@Test
	public void filter_should_return_2_for_1_and_2 () {
		ListFilter integerFilter = new IntegerFilter();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		
		List<Integer> expected = new ArrayList<Integer>();
		expected.add(2);
		
		List<Integer> newList = CollectionUtils.filter(list, integerFilter);
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
		
		List<Integer> newList = CollectionUtils.map(list, integerMap);
		assertEquals(newList.get(0), expected.get(0));
	}
}