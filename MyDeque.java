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

  //need to resize
  public void addFirst(E element){
    if (start == 0) {
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
    data[end+1] = element;
    end++;
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
    MyDeque<Integer> A = new MyDeque(10);
    A.addFirst(1);
    System.out.println(A);
  }
  /*

  public E removeFirst(){ }
  public E removeLast(){ }
  public E getFirst(){ }
  public E getLast(){ }
  */
}
