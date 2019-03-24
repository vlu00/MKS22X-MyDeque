import java.util.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
  }

  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[start];
  }

  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return data[end];
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] ary = (E[])new Object[size * 2 + 1];
    if (start < end) {
      for(int i = 0; i < size; i++) {
        ary[i] = data[i];
      }
    }
    else {
      for (int i = 0; i < end; i++) {
        ary[i] = data[i];
      }
      for (int i = 0; i < data.length-start; i++) {
        ary[data.length-1-i] = data[size-1-i];
      }
    }
    data = ary;
  }

  //need to resize
  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      resize();
    }
    if (start == 0 && size == 0) {
      data[0] = element;
      size++;
    }
    else if (start == 0) {
      data[data.length-1] = element;
      start = data.length-1;
      size++;
    }
    else {
      data[start-1] = element;
      start--;
      size++;
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException();
    }
    if (size == data.length) {
      resize();
    }
    if (end == 0 && size == 0) {
      data[0] = element;
      size++;
    }
    else if (end == data.length-1) {
      data[0] = element;
      end = 0;
      size++;
    }
    else {
      data[end+1] = element;
      end++;
      size++;
    }
  }

  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E old;
    if (size == 1) {
      old = data[start];
      data[start] = null;
      size--;
    }
    else if (start == data.length-1) {
      old = data[start];
      data[start] = null;
      start = 0;
      size--;
    }
    else {
      old = data[start];
      data[start] = null;
      start++;
      size--;
    }
    return old;
  }

  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    E old;
    if (size == 1) {
      old = data[end];
      data[end] = null;
      size--;
    }
    else if (end == 0) {
      old = data[0];
      data[0] = null;
      end = data.length-1;
      size--;
    }
    else {
      old = data[end];
      data[end] = null;
      end--;
      size--;
    }
    return old;
  }

  public String toString(){
    String display = "";
    if (start < end) {
      for (int i = 0; i < size; i++) {
        display = display+ data[i] + " ";
      }
    }
    else {
      for (int i = start; i < data.length; i++) {
        display = display+ data[i] + " ";
      }
      for (int i = 0; i < end+1; i++) {
        display = display+ data[i] + " ";
      }
    }
    return display;
  }

  public static void main(String[] args) {
    MyDeque<Integer> A = new MyDeque(10);
    A.addFirst(1);
    System.out.println(A.removeFirst());

  }
}
