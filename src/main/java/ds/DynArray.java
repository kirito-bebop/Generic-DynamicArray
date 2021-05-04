/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ds;
/**
 * Clase DynamicStringArray - DynStr
 * @author kirito - the shadow programmer
 */
public class DynArray {
    //---------------------------
    // * ATRIBUTOS *
    //---------------------------
    private static final int NUM = 10;
    private String[] data;
    private int punt =0;
    //---------------------------
    // * CONTRUCTOR *
    //---------------------------

    /**
     *Constructor por defecto que inicaliza o array a 10.
     */
    public DynArray(){
        data = new String[NUM];
    }

    /**
     *
     * @param num
     */
    public DynArray(int num){
        try{
           data = new String[num];
        }
        catch(IllegalArgumentException e){
            System.out.println(" Tamaño no válido: " + num);
        }
    }

    /**
     *
     * @param arr
     */
    public DynArray(String[] arr){
        try {
            data = new String[arr.length];
            for(int i = 0; i<arr.length; i++){ data[i] = arr[i]; }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    /**
     *
     * @param ob
     */
    public DynArray(DynArray ob){
        try {
            data = ob.data.clone();
            
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    //---------------------------
    // * METODOS *
    //---------------------------
    
    /**
     * Método que devolve o número de elementos contidos no array dinámico
     * @return count. Devolve a conta de elementos que contén o array 
     */
    public int size(){
        int count=0;
        for(String i:data){
            if(i != null){count++;}
            else{
                break;
            }
        }
        return count;
    }
    
    /**
     * Método que indica se o array está vacío.
     * Entendemos que neste array dinámico, os valores nunca van 
     * a ter valores null por medio, sempre van a estar xuntos.
     * @return boolean. Devolve un valor booleano: true para indicar que 
     * está vacío, e false para indicar que non está vacío.
     */
    public boolean isEmpty(){
        if(data[0] == null){
            return true;
        }else{
            return false;

        }
    }
    
    /**
     * Método que vacía o array. 
     * O que fai é por todos os elementos a null.
     */
    public void clear(){
        int tp = size();
        for (int i = 0; i<tp; i++){
            data[i] = null;
        }
    }
    
    /**
     * Método que devolve a cadena localizada na posición que indica o array.
     * No caso de que dita posición esté fora de rango, lanza a excepción.
     * @param index índice do array que buscará o String do array 
     * @return String da posición index.
     */
    public String get(int index){
        if(size() == 0){throw new IndexOutOfBoundsException(index);}
        try{
            return data[index];
        }
        catch (IndexOutOfBoundsException e){
            return "[ERROR] " + e;
        }
    }
    
    /**
     * Método que engade a cadena ao final do array.
     * No caso de que non exista sitio dispoñible, incrementará o tamaño 
     * do array nun 50%
     * @param cad String 
     */
    public void add(String cad){
        punt = size();
        try{
            if (data[punt] == null){

                data[punt++] = cad;
            }
        }
        catch(IndexOutOfBoundsException e){
            newDynArray();
            add(cad);
        }
        
    }
    
    /**
     * Método que inserta a cadena de String na posición indicada.
     * No caso de que a posición non sexa correcta, lanzará unha excepción
     * de IndexOutOfBoundsException.
     * @param index índice no que se vai engadir 
     * @param cad String que se vai engadir
     */
    public void add(int index, String cad){
        if(size() == 0){throw new IndexOutOfBoundsException(cad);}
        try{
            int SIZE = size() -1;
            if( SIZE < data.length-1){
                moveRight(index, cad);
            }else{
                newDynArray();
                moveRight(index, cad);
            }
            
        }
        catch(Exception e){
            System.out.println("[ERROR] Posición non válida: " + index);
        }
    }
    
    /**
     * Método que modifica o valor da posición indicada coa nova cadena.
     * No caso de que a posición sexa incorrecta, lanzará a exececpción 
     * IndexOutOfBoundsException.
     * @param index índice no que se vai modificar 
     * @param cad String de cadena que vai sobrescribir a posición
     */
    public void set(int index, String cad){
        if(size() == 0){throw new IndexOutOfBoundsException(cad);}
        try{
            if(index <=size()-1){
                data[index] = cad;
            }else{
                throw new IndexOutOfBoundsException(cad);
            }
        }
        catch(IndexOutOfBoundsException e){
            System.out.println("[ERROR] Posición no válida " +  index);
        }
    }
    
    /**
     * Método que elimina a cadena da posición indicada e devolve o valor que 
     * tiña nesa posición. No caso de que a posición indicada sexa incorrecta, 
     * lanzará unha excepción de IndexOuOfBoundsException.
     * @param index posición do índice que se eliminará
     * @return cad - Cadena de String co valor do campo eliminado.
     */
    public String remove(int index){
        if(size() == 0){throw new IndexOutOfBoundsException(index);}
        String str = null;
        try{
            if(index <= size()-1){
                str = data[index];
                moveLeft(index);
                return str;
            }
            else{
                System.out.println("ERROR");
                //throw new IndexOutOfBoundsException(index);
            }
            
        }
        catch(IndexOutOfBoundsException e){
            str = "[ERROR] Posición no válida: " + index;
        }
        return str;
        
    }
    
    /**
     * Método que elimina unha cadena do array.
     * Revisa todo o array buscando esa cadena. En caso de que non atopa a cadena
     * devolverá un valor null, en caso contrario, devolve a cadena que se eliminou.
     * @param cad String que se vai eliminar
     * @return String que se eliminou ou null en caso de que non se elimine ningunha.
     */
    public boolean delete(String cad){
        boolean status;
        int point = indexOf(cad);
        if(point == -1){
            status = false;
        }else{
            data[point] = null;
            //Movemos valores dende point
            for(int i = point; i< data.length-1; i++){
                data[i] = data[i+1];
                data[i+1] = null;
            }
            status = true;
        }
        
        return status;
    }
    
    /**
     * Método que devolve a posición na que se atopa o array.
     * Se non atopa nada, devolve -1.
     * @param cad Cadena de String que comprobaremos se existe no array
     * @return pos. Devolve a posición na que está a cadena; -1 en caso de non atopala.
     */
    public int indexOf(String cad){
        int pos = -1;
        for(int i =0; i<size(); i++){
            if(data[i].equals(cad)){pos = i; break;}
        }
        return pos;
    }
    
    /**
     * Método que devolve os datos da cadena.
     * @return devolve o array cos datos que obtivo
     */
    @Override
    public String toString(){
        int SIZE = size();
        String cad = "[";
        for(int i = 0; i<SIZE; i++){
            if( i == 0){
                cad = cad + data[i];
            }else{
            cad = cad + ", " + data[i];
            }
        }
        cad = cad + "]";
        return cad;
    }
    
    /**
     * Método privado que crea un array 50% máis grande
     */
    private void newDynArray(){
        //Clonamos o array nun array tmp
        String[] tmp = data.clone();
        //Creamos un novo array 
        data = new String[ (int)(data.length * 1.5+1)];
        //Volcamos os datos
        for (int a = 0; a < tmp.length; a++){
            data[a] = tmp[a];
        }
    }
    
    /**
     * Método privado para mover unha posición á dereita o array.
     * @param index índice dende onde se empeza a mover o punteiro
     * @param cad cadena de String que se agregará na posición.
     */
    private void moveRight(int index, String cad){
        try{            
            int SIZE = size();
            for (int i = SIZE; i>index-1; i--){
                data[i+1] = data[i];
            }
            data[index] = cad;
             
        }
        catch (IndexOutOfBoundsException e){
            throw e;
        }
        
    }
    /**
     * Método privado que move á esquerda o array.
     * @param index posición dende onde se vai a comezar a mover.
     */
    public void moveLeft(int index){
        try{
            int SIZE = size()-1;
            for(int i = index; i<SIZE; i++){
                data[i] = data[i+1];
            }
            data[size()-1] = null;
            
        }
        catch(IndexOutOfBoundsException e){
            throw e;
        }
    }
    
    
    
    
    
    
    
}
