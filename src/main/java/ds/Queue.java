package ds;

public class Queue<T> {
    //---------------------------
    //       * ATRIBUTOS *
    //---------------------------
    private LinkedList<T> list;
    //---------------------------
    //       * CONSTRUCTOR *
    //---------------------------
    public Queue(){
        this.list = new LinkedList<>();
    }
    //---------------------------
    //       * METODOS *
    //---------------------------

    /**
     * Devolve o número de elementos da cola
     * @return int. numero de elementos que ten a cola
     */
    public int size(){ return this.list.size();}

    /**
     * Indica se a cola está vacía ou non
     * @return TRUE or FALSE dependendo de se está vacía ou non a cola.
     */
    public boolean isEmpty(){ return this.list.isEmpty();}

    /**
     * Engade un elemento ao final da cola.
     * @param obj elemento que se engade ao final.
     */
    public void enqueue(T obj){ this.list.add(obj);}

    /**
     * Elimina o seguinte elemento da cola e devolveo
     * @return devolve o último elemento da cola
     */
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        return this.list.remove(this.list.size()-1);
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return list.get(size());
    }

}
