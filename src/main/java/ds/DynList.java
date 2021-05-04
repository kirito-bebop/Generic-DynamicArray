package ds;

/**
 * El interfaz DynList nos permite manejar el contenido de colecciones de objetos.
 */
public interface DynList<E> {
    /**
     * Devuelve el número de elementos en la lista.
     * 
     * @return número de elementos en la lista
     */
    int size();

    /**
     * Devuelve si la lista está vacío o no.
     * 
     * @return si la lista está vacío o no
     */
    boolean isEmpty();

    /**
     * Vacía la lista. 
     */
    void clear();

    /**
     * Devuelve el elemento de la posición indicada de la lista.
     * 
     * @param index índice del elemento a devolver
     * @return el elemento en la posición indicada en la lista
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */
    E get(int index) throws IndexOutOfBoundsException;

    /**
     * Añade el nuevo elemento al final de la lista.
     * 
     * @param element nuevo elemento que se añadirá a la lista
     */
    void add(E element);

    /**
     * Inserta el nuevo elemento en la posición indicada.
     * 
     * @param index posición en la que se insertará el elemento
     * @param elemento nuevo elemento que se añadirá a la lista
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index > size())
     */
    void add(int index, E elemento) throws IndexOutOfBoundsException;

    /**
     * Actualiza la posición indicada con el nuevo valor suministrado.
     * 
     * @param index posición dla lista que se actualizará
     * @param elemento nuevo elemento en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    void set(int index, E elemento) throws IndexOutOfBoundsException;

    /**
     * Elimina el valor en la posición indicada dla lista.
     * 
     * @param index posición dla lista que se borrará
     * @return el valor de la posición borrada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    E remove(int index) throws IndexOutOfBoundsException;

    /**
     * Elimina la primera ocurrencia del elemento indicado si se encuentra en la lista.
     * 
     * @param elemento elemento que se quiere eliminar
     * @return si se encontró (y borró) la elemento buscada o no
     */
    boolean delete(E elemento);

    /**
     * Devuelve la posición de la primera ocurrencia del elemento en la lista.
     * 
     * @param elemento elemento que se quiere buscar
     * @return posición en la lista del elemento buscado o -1 si no se encuentra
     */    
    int indexOf(E elemento);
}
