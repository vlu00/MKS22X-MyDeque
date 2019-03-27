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
    MyDeque<Double> A = new MyDeque(s.length()/2+1);
    String[] parts = s.split(" ");
    int i = 0;
    while (i < parts.length) {
      if (isOperator(parts[i])) {
        Double second = A.removeLast();
        Double first = A.removeLast();
        Double num = operate(first, second, parts[i]);
        A.addLast(num);
      }
      else {
        Double num = Double.parseDouble(parts[i]);
        A.addLast(num);
      }
      i++;
    }
    return A.getFirst();
  }

  public static void main (String[] args) {
    String s = "4444444444444444444444444444++++++++++++++++++++++++++";
    System.out.println(s.length()); // is 12.0
  }
}
