package homework26.model;

import java.util.Arrays;

public class StringListImpl implements StringList {

    public static final int SOFT_MAX_ARRAY_LENGTH = Integer.MAX_VALUE - 8;

    private static final String[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private String[] elementData;
    private int size;

    public StringListImpl() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public String add(String item) {
        if (size == elementData.length) {
            elementData = grow();
        }
        elementData[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elementData.length) {
            elementData = grow();
        }
        System.arraycopy(elementData, index,
                         elementData, index + 1,
                         size - index);
        elementData[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        elementData[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        String[] es = elementData;
        int i = indexOf(item);
        if (i == -1) {
            throw new RuntimeException();
        }
        int newSize = size - 1;
        if (newSize > i) {
            System.arraycopy(es, i + 1, es, i, newSize - i);
        }
        es[size = newSize] = null;
        return item;
    }

    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        String[] es = elementData;
        String oldValue = es[index];
        int newSize = size - 1;
        if (newSize > index) {
            System.arraycopy(es, index + 1, es, index, newSize - index);
        }
        es[size = newSize] = null;
        return oldValue;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) >= 0;
    }

    @Override
    public int indexOf(String item) {
        Object[] es = elementData;
        int i = 0;
        if (item == null) {
            for (; i < size; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (; i < size; i++) {
                if (item.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        String[] es = elementData;
        int start = 0;
        if (item == null) {
            for (int i = size - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= start; i--) {
                if (item.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elementData[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StringListImpl that)) {
            return false;
        }
        return size == that.size && deepEquals(elementData, that.elementData);
    }

    private boolean deepEquals(String[] a, String[] b) {
        for (int i = 0; i < size; i++) {
            String e1 = a[i];
            String e2 = b[i];
            if (!e1.equals(e2)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] copy = new String[size];
        System.arraycopy(elementData, 0, copy, 0, size);
        return copy;
    }

    private String[] grow() {
        int minCapacity = size + 1;
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = newLength(oldCapacity,
                                        minCapacity - oldCapacity, /* minimum growth */
                                        oldCapacity >> 1           /* preferred growth */);
            String[] copy = new String[newCapacity];
            System.arraycopy(elementData, 0, copy, 0,
                             Math.min(elementData.length, newCapacity));
            return elementData = copy;
        } else {
            return elementData = new String[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

    private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (prefLength > 0 && prefLength <= SOFT_MAX_ARRAY_LENGTH) {
            return prefLength;
        } else {
            return hugeLength(oldLength, minGrowth);
        }
    }

    private static int hugeLength(int oldLength, int minGrowth) {
        int minLength = oldLength + minGrowth;
        if (minLength < 0) {
            throw new OutOfMemoryError(
                    "Required array length " + oldLength + " + " + minGrowth + " is too large");
        } else if (minLength <= SOFT_MAX_ARRAY_LENGTH) {
            return SOFT_MAX_ARRAY_LENGTH;
        } else {
            return minLength;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (!(i == size - 1)) {
                sb.append(',').append(' ');
            }
        }
        return sb.append(']').toString();
    }
}