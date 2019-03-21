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

  public String toString(){
    String display = "";
    for (int i = start; i < size; i++) {
      if (i == size-1) {
        display += data[i];
        i = 0;
      }
      else {
        display += data[i];
      }
    }
    return display;
  }

  public static void main(String[] args) {
    MyDeque A = new MyDeque(10);
    System.out.println(A);  
  }
  /*
  public void addFirst(E element){ }
  public void addLast(E element){ }
  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
  */
}
