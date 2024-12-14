class Main {
  public static void main(String[] args) {
    int [] array = {1, 3, 4, 5, 6};
    int [] array2 = {3, 4, 5, 1, 7};
    Node<Integer> node = new Node<Integer>(0);
    Node<Integer> list = Main.ex1(array);
    Node<Integer> list2 = Main.ex1(array2);
    System.out.println(list);
    Main.ex2(list);
    Main.ex2recursion(list);
    Main.ex2reverse(list);
    Main.ex4(list);
    System.out.println(Main.ex5(list, 4));
    System.out.println(Main.ex5recursionT(list, 4));
    System.out.println("ex6");
    System.out.println(Main.ex6(list, 2));
    boolean answer = Main.ex8(list, list2);
    System.out.println("ex8: " + answer);

    System.out.println("ex10: " + Main.ex10(list, list2));
    System.out.println("ex11: " + Main.ex11(list, list2));
  }

  public static Node<Integer> ex1(int[] array) {
    Node<Integer> list = new Node<>(0);
    Node<Integer> listnext = list;
    for (int i = 0; i < array.length; i++) {
        listnext.setNext(new Node<>(array[i]));
        listnext = listnext.getNext();
    }
    return list.getNext();
}

  public static void ex2(Node<Integer> list1) {
    while (list1 != null) {
        System.out.println(list1.getValue()); 
        list1 = list1.getNext(); 
    }
  }

  public static void ex2recursion(Node<Integer> list1) {
    if (list1 != null) {
      System.out.println(list1.getValue()); 
      ex2recursion(list1.getNext());
    }
  }

  public static void ex2reverse(Node<Integer> list1) {
    if (list1 != null) {
      ex2reverse(list1.getNext()); 
      System.out.println(list1.getValue());
    }
  }

  public static void ex4(Node<Integer> list1) {
    while (list1 != null) {
      if (list1.getValue()%2==0) {
        System.out.println("ex4 " + list1.getValue());
      }
      list1 = list1.getNext();
    }
  }

  public static boolean ex5(Node<Integer> list1, int num) {
    while (list1 != null) {
      if (list1.getValue()==num) {
        return true;
      }
      list1 = list1.getNext();
    }
    return false;
  }

  public static boolean ex5recursionT(Node<Integer> list1, int num) {
    if (list1==null) {
      return false;
    }
    if (list1.getValue()==num) {
      return true;
    }
    return ex5recursionT(list1.getNext(), num);
  }

  public static Node<Integer> ex6(Node<Integer> list1, int num) {
    Node<Integer> p = new Node<Integer>(-1, list1);
    list1 = p;
    while (p.hasNext()) {
      Node<Integer> t;
      if (p.getNext().getValue()==num) {
        t = p.getNext();
        p.setNext(p.getNext().getNext());
        t.setNext(null);
        return list1.getNext();
      }
      p = p.getNext();
    }
    return list1.getNext();
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
      p2.setNext(p2.getNext().getNext());
    }
    if (count==0) {
      return false;
    }
    return ex8(list1.getNext(), list2);
  }

  public static Node<Integer> ex9(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> p1 = new Node<Integer>(-1, list1);
    Node<Integer> p2 = new Node<Integer>(-1, list2);
    int count = 0;
    if (p1.getNext()==null) {
      return null;
    }
    while (p2.hasNext()) {
      if (p1.getNext().getValue()==p2.getNext().getValue()) {
        count++;
      }
      p2 = p2.getNext();
    }
    if (count>0) {
      System.out.println(p1.getNext());
    }
    return ex9(list1.getNext(), list2);
  }

  public static Node<Integer> ex10(Node<Integer> list1, Node<Integer> list2) {
    Node<Integer> p1 = new Node<Integer>(-1, list1); 
    Node<Integer> p2; 
    Node<Integer> p3 = new Node<Integer>(-1, null); 
    Node<Integer> tail = p3;

    while (p1.hasNext()) {
        p2 = new Node<Integer>(-1, list2);
        int count = 0;
        while (p2.hasNext()) {
            if (p1.getNext().getValue().equals(p2.getNext().getValue())) {
                count++;
            }
            p2 = p2.getNext();
        }
        if (count > 0) {
            tail.setNext(new Node<Integer>(p1.getNext().getValue(), null));
            tail = tail.getNext();
        }
        p1 = p1.getNext();
    }
    return p3.getNext();
}

public static Node<Integer> ex11(Node<Integer> list1, Node<Integer> list2) {
  Node<Integer> p1 = new Node<Integer>(-1, list1);
  Node<Integer> p2 = new Node<Integer>(-1, list2);
  while (p1.hasNext()) {
    while (p2.hasNext()) {
      if (p1.getValue().equals(p2.getValue())) {
          p1.setNext(p1.getNext().getNext());
      }
      p2 = p2.getNext();
    }
    p1 = p1.getNext();
  }
  return p1;
}


  
  
}
