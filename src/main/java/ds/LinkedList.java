package ds;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    public static void main(String[] args){
        LinkedList<String> l1 = new LinkedList<>();
        l1.add("hola");
        l1.add("amigo");
        l1.add("mundo");
        l1.add("adios");
        l1.add("astronauta");
        System.out.println(l1.len);
        System.out.println(l1.indexOf("mundo"));


    }
    //---------------------------
    //       * ATRIBUTOS *
    //---------------------------
    private ListNode<T> head;
    private ListNode<T> tail = null;
    private int len = 0;

    //---------------------------
    //       * METODOS *
    //---------------------------

    /**
     * Engade un genérico ao final da colección. Este método revisa se head
     * está a null ou non. No caso de que esté a null: tail = head = node
     *
     * Se non está a null: establecemos o seguinte ListNode establecendo
     * no "tail" o nodo seguinte. E despois,  sobreescribimos o valor que
     * ten "tail".
     * @param type é o elemento genérico que se lle pasa.
     */
    public void add(T type){
        ListNode<T> node = new ListNode<>(type);
        if (head == null){
            tail = head = node;
        }else{
            tail.setNext(node);
            tail = node;
        }
        len++;
    }

    /**
     * Metodo que elimina un elemento da lista
     * @param type elemente genérico que se elimina
     * @return bool - Indicando se se eliminou ou non.
     * True indica SI. False indica NON:
     */
    public boolean delete(T type){
        if (indexOf(type) != -1){

        }
        //TO DO
        return false;
    }

    /**
     * Devolve un geneŕico na posición solicitada.
     * @param index a posición dun elemento
     * @return o elemento que está indexado nesa posición
     */
    public <T> T get(int index){


        for (Iterator<T> it = (Iterator<T>) iterator(); it.hasNext(); ) {
            ListNode<T> t = (ListNode<T>) head;
            if(it.hasNext()){
                t = (ListNode<T>) head.getNext();
            }
            return t.getData();
        }
        return null;
    }

    /**
     * Devolve a posición onde se atopa dito elemento xenérico.
     * @param type o elemento xenerico
     * @return a posición
     */
    public int indexOf(T type){
        int counter = -1;
        Iterator<T> it;

        for (it = iterator(); it.hasNext();){
            counter++;
            // TODO
        }
        return counter;
    }

    /**
     * Inserta un valor nunha posición indicada.
     * @param type o elemento xenerico
     * @param index o indice na lista
     */
    public void insert(T type, int index){
        //TO DO
    }

    /**
     * Devolve un valor true/false indicando se está vacío ou non
     * @return len == 0
     */
    public boolean isEmpty(){
        return len == 0;
    }


    @Override
    public Iterator<T> iterator(){

        Iterator<T> it = new Iterator<T>() {
            private int p = 0;
            ListNode<T> current = head;
            @Override
            public boolean hasNext() {
                return (current != null) ;
            }

            @Override
            public T next() {
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
        return it;
    }

    /**
     * Elimina un elemento xenérico pasando un índice
     * @param index indice
     * @return devolve o valor eliminado
     */
    public String remove(int index){
    // TODO
        return "Non é String senon Xenérico <T>";
    }

    /**
     * Devolve o valor gardado na variable len. Indica
     * o número de elementos que hai na lista
     * @return len. Lonxitude do array
     */
    public int size() {return this.len;}

    /**
     * Devolve os datos gardados no Linked List
     * @return devolve os datos gardados.
     */
    @Override
    public String toString(){
        // TO DO
        return "holaamigo.txt";
    }


}
