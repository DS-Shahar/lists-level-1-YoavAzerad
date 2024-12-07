class Main {
  public static void main(String[] args) {
    int [] array = {1, 2, 3, 4, 5};
    int [] array2 = {3, 4, 5, 2, 1, 7};
    IntNode node = new IntNode(0);
    IntNode list = node.ex1(array);
    IntNode list2 = node.ex1(array2);
    System.out.println(list);
    node.ex2(list);
    node.ex2recursion(list);
    node.ex2reverse(list);
    node.ex4(list);
    System.out.println(node.ex5(list, 4));
    System.out.println(node.ex5recursionT(list, 4));
    System.out.println("ex6");
    System.out.println(node.ex6(list, 2));
    boolean answer = node.ex8(list, list2);
    System.out.println("ex8: " + answer);
  }
}
