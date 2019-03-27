public class Calculator{

  public static boolean isOperator(String s){ //checks if element is an operator
    return s.equals("+") || s.equals("-") ||
           s.equals("*") || s.equals("/") ||
           s.equals("%");
  }

  public static Double operate(Double f, double s, String operator) {
    if (operator.equals("+")) { //add
      return f + s;
    }
    if (operator.equals("-")) { //subtract
      return f - s;
    }
    if (operator.equals("*")) { //multiply
      return f*s;
    }
    if (operator.equals("/")) { //divide
      return f / s;
    }
    else {
      return f % s; //find remainder
    }
  }

  public static double eval(String s){
    MyDeque<Double> A = new MyDeque(s.length()/4+1); //create stack with size number of numbers in string
    String[] parts = s.split(" "); //split s into parts (taking out spaces)
    int i = 0; //starting with the first part or elelment
    while (i < parts.length) {
      if (isOperator(parts[i])) { //if element is an operator
        Double second = A.removeLast(); //remove the last two numbers
        Double first = A.removeLast();
        Double num = operate(first, second, parts[i]); //operate on those numbers
        A.addLast(num); //add the answer to the stack
      }
      else {
        Double num = Double.parseDouble(parts[i]); //if element is a number
        A.addLast(num); //add to stack
      }
      i++; //move onto next element
    }
    return A.getFirst(); //should be left with one number. Return it 
  }

}
