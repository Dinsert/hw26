package homework26.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class StringListTest {

    private final StringList out = new StringListImpl();
    private final int index = 0;
    private final int indexOne = 1;
    private final int indexMinusOne = -1;
    private final String one = "1";
    private final String two = "2";

    @Test
    void add() {
        StringList actual = out;
        actual.add(one);
        StringList expected = new StringListImpl();
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnElementStringAtAdd() {
        String actual = out.add(one);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void addAtElevenElementsString() {
        StringList actual = out;
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        StringList expected = new StringListImpl();
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void addAtSeventeensElementsString() {
        StringList actual = out;
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        actual.add(one);
        StringList expected = new StringListImpl();
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void checkSizeAtAdd() {
        out.add(one);
        int actual = out.size();
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void addElementByIndex() {
        StringList actual = out;
        actual.add(index, one);
        StringList expected = new StringListImpl();
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnElementStringAtAddByIndex() {
        String actual = out.add(index, one);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIndexOutOfBoundsExceptionAtAddElementByIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(indexOne, one));
        assertThrows(IndexOutOfBoundsException.class, () -> out.add(indexMinusOne, one));
    }

    @Test
    void addElevenElementsByIndex() {
        StringList actual = out;
        actual.add(0, one);
        actual.add(1, one);
        actual.add(2, one);
        actual.add(3, one);
        actual.add(4, one);
        actual.add(5, one);
        actual.add(6, one);
        actual.add(7, one);
        actual.add(8, one);
        actual.add(9, one);
        actual.add(10, one);
        StringList expected = new StringListImpl();
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void checkSizeAtAddElementByIndex() {
        out.add(index, one);
        int actual = out.size();
        int expected = indexOne;
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeMovedToRightElementsAtAddElementByIndex() {
        StringList actual = out;
        actual.add(one);
        actual.add(index, two);
        StringList expected = new StringListImpl();
        expected.add(two);
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void set() {
        StringList actual = out;
        actual.add(one);
        actual.add(one);
        actual.set(index, two);
        StringList expected = new StringListImpl();
        expected.add(two);
        expected.add(one);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIndexOutOfBoundsExceptionAtSetElementByIndex() {
        out.add(one);
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(indexOne, one));
        assertThrows(IndexOutOfBoundsException.class, () -> out.set(indexMinusOne, one));
    }

    @Test
    void shouldReturnElementStringAtSetByIndex() {
        out.add(two);
        String actual = out.set(index, one);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void remove() {
        out.add(one);
        StringList actual = out;
        actual.remove(one);
        StringList expected = new StringListImpl();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowRuntimeExceptionAtRemove() {
        out.add(one);
        assertThrows(RuntimeException.class, () -> out.remove(two));
    }

    @Test
    void checkSizeAtRemoveElement() {
        out.add(one);
        out.remove(one);
        int actual = out.size();
        int expected = index;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnElementStringAtRemove() {
        out.add(one);
        String actual = out.remove(one);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void RemoveElementByIndex() {
        out.add(one);
        StringList actual = out;
        actual.remove(index);
        StringList expected = new StringListImpl();
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIndexOutOfBoundsExceptionAtRemoveElementByIndex() {
        out.add(one);
        assertThrows(RuntimeException.class, () -> out.remove(indexOne));
        assertThrows(RuntimeException.class, () -> out.remove(indexMinusOne));
    }

    @Test
    void checkSizeAtRemoveElementByIndex() {
        out.add(one);
        out.remove(index);
        int actual = out.size();
        int expected = index;
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnElementStringAtRemoveElementByIndex() {
        out.add(one);
        String actual = out.remove(index);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void containsTrue() {
        out.add(one);
        boolean actual = out.contains(one);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void containsFalse() {
        out.add(one);
        boolean actual = out.contains(two);
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void indexOfIsPresentElement() {
        out.add(one);
        int actual = out.indexOf(one);
        int expected = index;
        assertEquals(expected, actual);
    }

    @Test
    void indexOfIsPresentNull() {
        out.add(null);
        int actual = out.indexOf(null);
        int expected = index;
        assertEquals(expected, actual);
    }

    @Test
    void indexOfIsAbsent() {
        out.add(one);
        int actual = out.indexOf(two);
        int expected = indexMinusOne;
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOfIsPresentElement() {
        out.add(one);
        out.add(two);
        int actual = out.lastIndexOf(two);
        int expected = indexOne;
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOfIsPresentNull() {
        out.add(one);
        out.add(null);
        int actual = out.lastIndexOf(null);
        int expected = indexOne;
        assertEquals(expected, actual);
    }

    @Test
    void lastIndexOfIsAbsent() {
        out.add(one);
        int actual = out.lastIndexOf(two);
        int expected = indexMinusOne;
        assertEquals(expected, actual);
    }

    @Test
    void get() {
        out.add(one);
        String actual = out.get(index);
        String expected = one;
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowIndexOutOfBoundsExceptionAtGetElementByIndex() {
        out.add(one);
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(indexOne));
        assertThrows(IndexOutOfBoundsException.class, () -> out.get(indexMinusOne));
    }

    @Test
    void sizeIsEmpty() {
        int actual = out.size();
        int expected = index;
        assertEquals(expected, actual);
    }

    @Test
    void sizeIsPresentAnyElement() {
        out.add(one);
        int actual = out.size();
        int expected = indexOne;
        assertEquals(expected, actual);
    }

    @Test
    void equalsIsTrueAtThisObject() {
        StringList stringList = out;
        boolean actual = out.equals(stringList);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowRuntimeExceptionAtTransferNullInMethodEquals() {
        assertThrows(RuntimeException.class, () -> out.equals(null));
    }

    @Test
    void equalsEmpty() {
        StringList stringList = new StringListImpl();
        boolean actual = out.equals(stringList);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void equals() {
        out.add(one);
        StringList stringList = new StringListImpl();
        stringList.add(one);
        boolean actual = out.equals(stringList);
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void isEmpty() {
        boolean actual = out.isEmpty();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void isNotEmpty() {
        out.add(one);
        boolean actual = out.isEmpty();
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void clear() {
        StringList actual = out;
        actual.add(one);
        actual.add(two);
        actual.clear();
        StringList expected = new StringListImpl();
        assertEquals(expected, actual);
    }

    @Test
    void checkSizeAfterClear() {
        out.add(one);
        out.add(two);
        out.clear();
        int actual = out.size();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void toArrayEmpty() {
        String[] actual = out.toArray();
        String[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void toArrayPresentAnyElement() {
        out.add(one);
        String[] actual = out.toArray();
        String[] expected = {one};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testEquals() {
        String[] actualArray = out.toArray();
        String[] expectedArray = {};
        boolean actual = Arrays.equals(actualArray, expectedArray);
        boolean expected = true;
        assertEquals(expected, actual);
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.equals("");
    }
}