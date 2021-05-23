package ds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LinkedList<T> implements DynList<T>,Iterable{
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
    private ListNode<T> head = null;
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
    @Override
    public void add(T type){
        ListNode<T> node = new ListNode<>(type);
        if (isEmpty()){
            head = node;
        }else{
            tail.setNext(node);
        }
        node.setPrev(tail);
        tail = node;
        len++;
    }

    /**
     * Inserta el nuevo elemento en la posición indicada.
     *
     * @param index    posición en la que se insertará el elemento
     * @param elemento nuevo elemento que se añadirá a la lista
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index > size())
     */
    @Override
    public void add(int index, T elemento) throws IndexOutOfBoundsException {
        if (index > size() || index < 0){throw new IndexOutOfBoundsException();}
        if (index == size()){
            add(elemento);
        }else{
            final ListNode<T> oldNode = getNode(index);
            final ListNode<T> node = new ListNode<T>(elemento);
            node.setNext(oldNode);
            if (isEmpty()){
                head = node;
            }else{
                node.setPrev(oldNode.getPrev());
                oldNode.getPrev().setNext(node);
            }
            oldNode.setPrev(node);
            len++;
        }
    }


    /**
     * Actualiza la posición indicada con el nuevo valor suministrado.
     *
     * @param index    posición dla lista que se actualizará
     * @param elemento nuevo elemento en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */
    @Override
    public void set(int index, T elemento) throws IndexOutOfBoundsException {
        if (index <0 || index > len){
            throw new IndexOutOfBoundsException("Indice fora de rango.");
        }
        getNode(index).setData(elemento);
    }

    /**
     * Metodo que elimina un elemento da lista
     * @param type elemente genérico que se elimina
     * @return bool - Indicando se se eliminou ou non.
     * True indica SI. False indica NON:
     */
    public boolean delete(T type){
        int index = indexOf(type);
        if (index != - 1){ remove(index);}
        return index != - 1;
    }

    /**
     * Devolve un geneŕico na posición solicitada.
     * @param index a posición dun elemento
     * @return o elemento que está indexado nesa posición
     */
    public T get(int index){

        if (index >= len || index < 0){
            throw new IndexOutOfBoundsException();
        }
        return  getNode(index).getData();
    }

    /**
     * Devolve a posición onde se atopa dito elemento xenérico.
     * @param type o elemento xenerico
     * @return a posición
     */
    public int indexOf(T type){
        Iterator<T> it = iterator();
        int index = 0;
        while(it.hasNext()){
            T data = it.next();
            if(data.equals((T) type)){
                return index;
            }
            index++;
            it.next();
        }
        return -1;
    }


    /**
     * Inserta un valor nunha posición indicada.
     * @param type o elemento xenerico
     * @param index o indice na lista
     */
    public void insert(T type, int index) throws IndexOutOfBoundsException{
        if (index <0 || index < len){throw new IndexOutOfBoundsException("Indice fora de rango");}

        ListNode<T> nextNode, prevNode, node;
        node = getNode(index);
        nextNode = node.getNext(); //nodo da dereita
        prevNode = node.getPrev(); // nodo da esquerda
        //Establecemos os nodos previo e seguinte.
        node.setNext(nextNode);
        node.setPrev(prevNode);
        //Establecer o nodo previo
        nextNode.setNext(node);
        //Establecer o novo seguinte
        prevNode.setPrev(node);
    }


    /**
     * Devolve un valor true/false indicando se está vacío ou non
     * @return len == 0
     */
    public boolean isEmpty(){
        return len == 0;
    }

    /**
     * Vacía la lista.
     */
    @Override
    public void clear() {
        this.len = 0;
        this.head = null;
        this.tail = null;
    }


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
                if(current == null){ return null;}
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
    public T remove(int index) throws IndexOutOfBoundsException{
        if (index < 0 || index > len){ throw new IndexOutOfBoundsException("Indice fora de rango.");}

        ListNode<T> prevNode, nextNode, node;
        node = getNode(index);
        prevNode = node.getPrev();
        nextNode = node.getNext();
        if( index == 0){head = nextNode; }
        if (index == len - 1){tail = prevNode; }
        if(prevNode != null)
            prevNode.setNext(nextNode);
        if(nextNode != null)
            nextNode.setPrev(prevNode);

        len--;
        return node.getData();
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
        if (size() == 0){return "[]";}
        ListNode<T> node = head;
        String ret = "";

        while(node != null){
            ret += node.getData();
            node = node.getNext();
            if( node!= null){ ret += ", ";}
        }
        return "[" + ret + "]";
    }


    /**
     * Devolve o nodo na posición indicada
     * @param index posición na lista
     * @return nodo
     */
    private ListNode<T> getNode(int index){
        if (index == 0) {return head;}
        if (index == len-1){return tail;}
        ListNode<T> node = head;
        while (index-- > 0){
            node = node.getNext();
        }
        return node;
    }




}
