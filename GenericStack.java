/* 
Q6. (2) Implement GenericStack.java
*/
import java.util.ArrayList;

public class GenericStack<T> {

    private ArrayList<T> stack = new ArrayList<>();

    // Push element onto stack
    public void push(T element) {
        stack.add(element);
        System.out.println(element + " pushed to stack");
    }

    // Pop element from stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T removed = stack.remove(stack.size() - 1);
        System.out.println(removed + " popped from stack");
        return removed;
    }

    // Peek top element
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.get(stack.size() - 1);
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Get size of stack
    public int size() {
        return stack.size();
    }

    // Display stack
    public void display() {
        System.out.println("Stack (top -> bottom): " + stack.reversed());
    }

    public static void main(String[] args) {

        // Integer Stack
        System.out.println("--- Integer Stack ---");
        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();
        System.out.println("Peek: " + intStack.peek());
        intStack.pop();
        intStack.display();
        System.out.println("Size: " + intStack.size());

        System.out.println();

        // String Stack
        System.out.println("--- String Stack ---");
        GenericStack<String> strStack = new GenericStack<>();
        strStack.push("Java");
        strStack.push("Python");
        strStack.push("C++");
        strStack.display();
        strStack.pop();
        strStack.display();

        System.out.println();

        // Empty stack test
        System.out.println("--- Empty Stack Test ---");
        GenericStack<Double> emptyStack = new GenericStack<>();
        emptyStack.pop();
        emptyStack.peek();
        System.out.println("Is empty: " + emptyStack.isEmpty());
    }
}