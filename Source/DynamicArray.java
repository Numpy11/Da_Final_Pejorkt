// Copyright (C) 2025  CoolCat467
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.

import java.lang.IndexOutOfBoundsException;
import java.lang.reflect.Array;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private T[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public DynamicArray(Class<T> clazz, int initial_size) {
        this.values = (T[]) Array.newInstance(clazz, Math.max(1, initial_size));
        this.size = 0;
    }

    public DynamicArray(Class<T> clazz) {
        this(clazz, 1);
    }

    public DynamicArray(T[] array){
        this.values = array;
        this.size = array.length;
    }

    private static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.values[index];
    }

    public void set(int index, T value) throws IndexOutOfBoundsException {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.values[index] = value;
    }

    public int get_size(){
        return this.size;
    }

    private static void copy_entries(int count, Object[] old, Object[] new_) {
        for (int i = 0; i < count; i++) {
            new_[i] = old[i];
        }
    }

    private T[] new_generic_array(int size){
        @SuppressWarnings("unchecked")
        T[] array = (T[]) Array.newInstance(values.getClass().getComponentType(), size);
        return array;
    }

    private void resize(int new_size) {
        new_size = max(1, new_size);
        T[] new_array = new_generic_array(new_size);
        copy_entries(min(this.values.length, new_size), this.values, new_array);
        this.values = new_array;
    }

    public void append(T value) {
        int index = this.size;
        if (index >= this.values.length) {
            this.resize(this.values.length * 2);
        }
        if (index >= this.size) {
            this.size += 1;
        }
        try {
            this.set(index, value);
        } catch (IndexOutOfBoundsException exc) {
            System.out.println("unexpected exception happened, this shouldn't be able to happen after resize");
            System.out.println(exc);
        }
    }

    public void extend(Iterable<T> iterable){
        for (T item : iterable){
            this.append(item);
        }
    }

    public T pop() throws IndexOutOfBoundsException {
        T value = this.get(this.size - 1);
        this.size--;
        return value;
    }

    public T pop(int index) throws IndexOutOfBoundsException {
        T value = this.get(index);
        for (int i=index; i<this.size-1; i++){
            this.values[index] = this.values[index+1];
        }
        this.size--;
        return value;
    }

    public T[] get_raw() {
        T[] array = new_generic_array(this.size);
        copy_entries(this.size, this.values, array);
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator();
    }

    private class DynamicArrayIterator implements Iterator<T> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new IndexOutOfBoundsException("No more elements to iterate.");
            }
            return values[currentIndex++];
        }
    }
}
