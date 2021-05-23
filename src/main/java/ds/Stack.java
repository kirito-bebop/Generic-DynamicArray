package ds;

public class Stack<T> {
    //---------------------------
    //       * ATRIBUTOS *
    //---------------------------
    private LinkedList<T> list;

    //---------------------------
    //       * CONSTRUCTOR *
    //---------------------------
    public Stack(){ this.list = new LinkedList<>();}
    //---------------------------
    //       * METODOS *
    //---------------------------

    /**
     * Devolve o número de elementos que ten a lista
     * @return número de elementos que contén a lista
     */
    public int size(){ return this.list.size();}

    /**
     * Devolve un valor booleano que indica se está vacía ou non a lista.
     * @return TRUE or FALSE dependendo de si está ou non vacía.
     */
    public boolean isEmpty(){return list.isEmpty();}

    /**
     * Engadir un obxecto ao final do array, poñemolo ao inicio porque
     * estamos a realizar un Stack de FIFO. Sigunifica que realizamos
     * accións cunha maneira de ordenar First In First Out.
     * @param obj o elemento que se vai engadir
     */
    public void push(T obj){ this.list.add(0,obj); }

    /**
     * Elimina o último elemento e devolveo.
     * @return o úlitmo elemento que se elimina
     */
    public T pop(){ return this.list.remove(0); }

    /**
     * Devolve o último elemnto da pila.
     * @return último elemento.
     */
    public T peek() { if(isEmpty()){return null;} return this.list.get(0);}


}
