package week10;

public class MyArray<E> {
    int capacity;
    int count;
    E[] arr;

    public MyArray(int capacity) {
        this.capacity = capacity;
        this.arr = (E[]) new Object[capacity];
    }

    public void add(E e) {
        if(this.count < this.capacity) {
            this.arr[count++] = e;
        }
        else {
            System.out.println("공간 부족");
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public E getElement(int index) {
        if(index >= 0 && index <= count) {
            return arr[index];
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for(E e : arr) {
            str += e + "\t";
        }
        str += "\n";
        return str;
    }
}
