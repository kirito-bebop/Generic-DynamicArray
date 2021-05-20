package ds;

public class ListNode<T> {
    //---------------------------
    //       * ATRIBUTOS *
    //---------------------------
    private T data;
    private ListNode<T> next;
    private ListNode<T> prev;

    //---------------------------
    //       * CONSTRUCTOR *
    //---------------------------
    public ListNode(T data){
        this.data = data;
    }

    //---------------------------
    //       * METODOS *
    //---------------------------

    /**
     * Devolve a instancia data. A instancia data será un
     * atributo xenérico que almacena o valor do nodo.
     * @return data - Instancia que conterá un atributo xenérico <T>
     */
    public T getData(){ return this.data;}

    /**
     * Devolve o seguinte nodo da LinkedList.
     * @return next - Apunta ao seguinte nodo.
     */
    public ListNode<T> getNext(){ return this.next;}

    /**
     * Establece o valor do nodo da LinkedList. Facilitará un
     * valor xenérico <T> que será o nodo do seguinte atributo xenérico
     * <T>.
     * @param ln referido ao atributo xenérico que será o seguinte
     */
    public void setNext(ListNode<T> ln){ this.next = ln;}

    /**
     * Devolve o anterior nodo da LinkedList.
     * @return prev - Apunta ao nodo anterior
     */
    public ListNode<T> getPrev(){ return this.prev;}

    /**
     * Establece o valor do noda na LinkedList. Facilitará un valor xenérico
     * <T> que será o nodo anterior ao que apunte o atributo xenérico
     * @param ln referido ao atributo xenérico que é o anterior
     */
    public void setPrev(ListNode<T> ln){ this.prev = ln;}

    /**
     * Devolve o valor gardado no nodo.
     * @return o valor gardado en data.
     */
    @Override
    public String toString(){
        return data.toString();
    }


}
