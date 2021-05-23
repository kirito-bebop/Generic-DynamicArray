package ds;

public class QueueStackDemo {
    public static void main(String[] args) {
        Queue<Integer> q = new Queue<>();

        System.out.println("Insertando datos en la cola:");
        for(Integer i: new int[]{3, 5, 1, 4, 2}) {
            System.out.println("Añadiendo " + i + "...");
            q.enqueue(i);
        }

        System.out.println("cola: " + q);

        System.out.println("Sacando los datos de la cola:");
        while(!q.isEmpty())
            System.out.println("dequeue() --> " + q.dequeue());

        Stack<Integer> s = new Stack<>();

        System.out.println("Insertando datos en la pila:");
        for(Integer i: new int[]{3, 5, 1, 4, 2}) {
            System.out.println("Añadiendo " + i + "...");
            s.push(i);
        }

        System.out.println("pila: " + s);

        System.out.println("Sacando los datos de la pila:");
        while(!s.isEmpty())
            System.out.println("pop() --> " + s.pop());
    }
}