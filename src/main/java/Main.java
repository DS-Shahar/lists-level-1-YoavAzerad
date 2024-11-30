class Main {
  public static void main(String[] args) {
    int [] array = {1, 2, 3, 4, 5};
    IntNode node = new IntNode(0);
    IntNode list = node.ex1(array);
    System.out.println(list);
    node.ex2(list);
    node.ex2recursion(list);
    node.ex2reverse(list);
    node.ex4(list);
    System.out.println(node.ex5(list, 4));
    System.out.println(node.ex5recursionT(list, 4));
    System.out.println("ex6");
    System.out.println(node.ex6(list, 2));
  }
}
