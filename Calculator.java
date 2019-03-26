public class Calculator{

  public static boolean isOperator(String s){
    return s.equals("+") || s.equals("-") ||
           s.equals("*") || s.equals("/") ||
           s.equals("%");
  }

  public static Double operate(Double f, double s, String operator) {
    if (operator.equals("+")) {
      return f + s;
    }
    if (operator.equals("-")) {
      return f - s;
    }
    if (operator.equals("*")) {
      return f*s;
    }
    if (operator.equals("/")) {
      return f / s;
    }
    else {
      return f % s;
    }
  }


  public static double eval(String s){
    MyDeque<Double> A = new MyDeque(s.length());
    //int size = s.length;
    //int i = 0; //s.length();
    while (s.length() > 0) {
      String[] parts = s.split(" ");
      if (isOperator(parts[0])) {
        Double second = A.removeLast();
        Double first = A.removeLast();
        Double num = operate(first, second, parts[0]);
        A.addLast(num);
      }
      else {
        Double num = Double.parseDouble(parts[0]);
        A.addLast(num);
      }
      s = parts[1];
    }
    return A.getFirst();
  }

  public static void main (String[] args) {
    System.out.println(eval("10 2.0 +")); // is 12.0
    System.out.println(eval("11 3 - 4 + 2.5 *")); // is 30.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); // is 893.
    System.out.println(eval("1 2 3 4 5 + * - -")); // is 26.0
  }
}
