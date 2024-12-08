class Main {
  public static void main(String[] args) {
    int [] array = {1, 2, 3, 4, 5};
    int [] array2 = {3, 4, 5, 2, 1, 7};
    Node<Integer> node = new Node<Integer>(0);
    Node<Integer> list = node.ex1(array);
    Node<Integer> list2 = node.ex1(array2);
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
  public static boolean ex8(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> p1 = new Node<Integer>(-1, list1);
    Node<Integer> p2 = new Node<Integer>(-1, list2);
    int count = 0;
    if (p1.getNext()==null) {
      return true;
    }
    while (p2.hasNext()) {
      if (p1.getNext().getValue()==p2.getNext().getValue()) {
        count++;
      }
      p2 = p2.getNext();
    }
    if (count==0) {
      return false;
    }
    return ex8(list1.getNext(), list2);
  }  
}
