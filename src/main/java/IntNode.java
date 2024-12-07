public class IntNode {
  private int value;
  private IntNode next;

  public IntNode(int value) {
    this.value = value;
    this.next = null;
  }

  public IntNode(int value, IntNode next) {
    this.value = value;
    this.next = next;
  }

  public int getValue() {
    return value;
  }

  public IntNode getNext() {
    return next;
  }

  public boolean hasNext() {
    return (next != null);
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setNext(IntNode next) {
    this.next = next;
  }

  public String toString() {
    return value + " --> " + next;
  }

  public IntNode ex1(int [] array) {
    IntNode list = new IntNode(0);
    IntNode listnext = list;
    for (int i=0; i<array.length; i++) {
      listnext.next = new IntNode(array[i]);
      listnext = listnext.next;
    }
    return list;

  }

  public void ex2(IntNode list1) {
    while (list1 != null) {
        System.out.println(list1.getValue()); 
        list1 = list1.getNext(); 
    }
  }

  public void ex2recursion(IntNode list1) {
    if (list1 != null) {
      System.out.println(list1.getValue()); 
      ex2recursion(list1.getNext());
    }
  }

  public void ex2reverse(IntNode list1) {
    if (list1 != null) {
      ex2reverse(list1.getNext()); 
      System.out.println(list1.getValue());
    }
  }

  public void ex4(IntNode list1) {
    while (list1 != null) {
      if (list1.getValue()%2==0) {
        System.out.println("ex4 " + list1.getValue());
      }
      list1 = list1.getNext();
    }
  }

  public boolean ex5(IntNode list1, int num) {
    while (list1 != null) {
      if (list1.getValue()==num) {
        return true;
      }
      list1 = list1.getNext();
    }
    return false;
  }

  public boolean ex5recursionT(IntNode list1, int num) {
    if (list1==null) {
      return false;
    }
    if (list1.getValue()==num) {
      return true;
    }
    return ex5recursionT(list1.getNext(), num);
  }

  public IntNode ex6(IntNode list1, int num) {
    IntNode p = new IntNode(-1, list1);
    list1 = p;
    while (p.hasNext()) {
      IntNode t;
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

  public boolean ex8(IntNode list1, IntNode list2) {
    IntNode p1 = new IntNode(-1, list1);
    IntNode p2 = new IntNode(-1, list2);
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




  
}
