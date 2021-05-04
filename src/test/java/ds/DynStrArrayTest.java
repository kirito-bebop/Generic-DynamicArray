//-----------------------------------------------------------------------------------------------
//  Unit Tests:
//-----------------------------------------------------------------------------------------------
// Test 1: Constructor por defecto
// Test 2: Constructor con tamaño 20
// Test 3: Constructor desde array (también usa get)
// Test 4: Constructor desde dinámico (también usa get)
// Test 5: clear()
// Test 6: add()
// Test 7: get()
// Test 8: get() --> IndexOutOfBoundsException
// Test 9: add() --> IndexOutOfBoundsException
// Test 10: add() con redimensión
// Test 11: set() at index 
// Test 12: set() --> IndexOutOfBoundsException
// Test 13: remove() at index 
// Test 14: remove() --> IndexOutOfBoundsException
// Test 15: delete() de elemento del array
// Test 16: delete() de elemento que no está en el array
// Test 17: indexOf() de elemento del array
// Test 18: indexOf() de elemento que no está en el array
// Test 19: toString()
// Test 20: toString() con múltiples operaciones
//-----------------------------------------------------------------------------------------------
package ds;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DynStrArrayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    //-----------------------------------------------------------------------------------------------
    // Set-Up

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    //-----------------------------------------------------------------------------------------------
    // Tests
    
    // Test 1: Constructor por defecto
    @Test 
    public void test_Constr() {
        DynArray dynArr = new DynArray(); // Creamos el array dinámico
        assertEquals(dynArr.size(), 0);         // Comprobamos ocupación =0
        assertTrue(dynArr.isEmpty());           // Comprobamos vacío =true
    }

    // Test 2: Constructor con tamaño 20
    @Test 
    public void test_Constr_20() {
        DynArray dynArr = new DynArray(20);   // Creamos el array dinámico
        assertEquals(dynArr.size(), 0);             // Comprobamos ocupación =0
        assertTrue(dynArr.isEmpty());               // Comprobamos vacío =true
    }

    // Test 3: Constructor desde array (también usa get)
    @Test 
    public void test_Constr_Arr() {
        String[] testset = {"cero", "uno", "dos"};
        String[] testset_cpy = {"cero", "uno", "dos"};

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        assertEquals(dynArr.size(), 3);             // Comprobamos ocupación =3
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false

        assertTrue(compareArr(dynArr, testset_cpy));    // Comprobamos que ambos arrays contienen lo mismo
    }    

    // Test 4: Constructor desde array dinámico (también usa get)
    @Test 
    public void test_Constr_DynArr() {
        String[] testset = {"cero", "uno", "dos"};

        DynArray dynArr1 = new DynArray(testset); // Creamos el array dinámico con los datos de prueba

        DynArray dynArr2 = new DynArray(dynArr1); // Creamos el 2do. array dinámico a partir del 1ro.
        
        assertEquals(dynArr2.size(), 3);            // Comprobamos ocupación =3
        assertFalse(dynArr2.isEmpty());             // Comprobamos vacío =false
        
        assertTrue(compareDynArr(dynArr1, dynArr2));    // Comprobamos que ambos arrays contienen lo mismo
    }

    // Test 5: clear()
    @Test 
    public void test_clear() {
        String[] testset = {"cero", "uno", "dos"};

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        assertEquals(dynArr.size(), 3);             // Comprobamos ocupación =3
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false

        dynArr.clear(); // Borramos el array dinámico

        assertEquals(dynArr.size(), 0);            // Comprobamos ocupación =0
        assertTrue(dynArr.isEmpty());              // Comprobamos vacío =true
    }

    // Test 6: add()
    @Test
    public void test_add() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        dynArr.add("test");                         // Añadimos un dato de prueba

        assertEquals(dynArr.size(), 1);             // Comprobamos ocupación =1
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false        
    }

    // Test 7: get()
    @Test
    public void test_get() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        dynArr.add("test");                         // Añadimos un dato de prueba

        assertEquals(dynArr.get(0), "test");        // Comprobamos el dato de prueba
    }

    // Test 8: get() --> IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test_get_IndexOutOfBoundsException() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        dynArr.get(0);                              // Debe lanzar la excepción
    }

    // Test 9: add() --> IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test_add_IndexOutOfBoundsException() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        dynArr.add(1, "test");                      // Debe lanzar la excepción
    }

    // Test 10: add() resize
    @Test
    public void test_add_resize() {
        final int SIZE = 12;

        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        for(int i=1; i<=SIZE; i++) dynArr.add(String.valueOf(i));   // Añadimos datos de prueba
        
        assertEquals(dynArr.size(), SIZE);          // Comprobamos ocupación =12
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false

        // Comprobamos contenido del array dinámico
        assertTrue(compareArr(dynArr, new String[] {
                    "1", "2", "3","4", "5", "6","7", "8", "9","10", "11", "12"
                }));
    }

    // Test 11: set() at index 
    @Test
    public void test_set() {
        String[] testset = {"cero", "uno", "dos"};  

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        dynArr.set(1, "1");                         // Modificamos con un dato de prueba

        assertEquals(dynArr.size(), 3);             // Comprobamos ocupación =3
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false
        assertEquals(dynArr.get(1), "1");           // Comprobamos el dato de prueba
    }      
    
    // Test 12: set() --> IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test_set_IndexOutOfBoundsException() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico
        
        dynArr.set(0, "test");                      // Debe lanzar la excepción
    }    

    // Test 13: remove() at index 
    @Test
    public void test_remove() {
        String[] testset = {"cero", "uno", "dos"};  

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        String value = dynArr.remove(1);            // Eliminamos el dato de la posición 1

        assertEquals(value, "uno");                 // Comprobamos el valor devuelto ="uno"
        assertEquals(dynArr.size(), 2);             // Comprobamos ocupación =2
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false
        assertEquals(dynArr.get(1), "dos");         // Comprobamos el dato actual en la posición
    }      

    // Test 14: remove() --> IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class) 
    public void test_remove_IndexOutOfBoundsException() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico

        dynArr.add("test");                         // Añadimos un dato de prueba
        dynArr.remove(0);                           // Borramos dato de prueba (no hay datos)

        dynArr.remove(0);                           // Debe lanzar la excepción 
    }    
    
    // Test 15: delete() de elemento del array
    @Test
    public void test_delete_present() {
        String[] testset = {"cero", "uno", "dos"};  

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        boolean deleted = dynArr.delete("uno");     // Eliminamos el dato "uno"

        assertTrue(deleted);                        // Comprobamos el valor devuelto =true
        assertEquals(dynArr.size(), 2);             // Comprobamos ocupación =2
        assertFalse(dynArr.isEmpty());              // Comprobamos vacío =false
        assertEquals(dynArr.get(1), "dos");         // Comprobamos el dato actual en la posición
    }      

    // Test 16: delete() de elemento que no está en el array
    @Test
    public void test_delete_not_present() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico

        boolean deleted = dynArr.delete("test");    // Eliminamos el dato "test"
        assertFalse(deleted);                       // Comprobamos el valor devuelto =false
    }    

    // Test 17: indexOf() de elemento del array
    @Test
    public void test_indexOf_present() {
        String[] testset = {"cero", "uno", "dos"};  

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        int index = dynArr.indexOf("uno");          // Buscamos el dato "uno"
        assertEquals(index, 1);                     // Comprobamos la posición devuelta =1
    }      

    // Test 18: indexOf() de elemento que no está en el array
    @Test
    public void test_indexOf_not_present() {
        DynArray dynArr = new DynArray();     // Creamos el array dinámico

        int index = dynArr.indexOf("test");         // Buscamos el dato "test"
        assertEquals(index, -1);                    // Comprobamos la posición devuelta =-1
    }        

    // Test 19: toString()
    @Test
    public void test_toString() {
        String[] testset = {"cero", "uno", "dos"};  
        String testset_prt = "[cero, uno, dos]";

        DynArray dynArr = new DynArray(testset);  // Creamos el array dinámico con los datos de prueba

        assertEquals(testset_prt, dynArr.toString());   // Comprobamos el valor devuelto por el método toString()
    }       

    // Test 20: toString() con múltiples operaciones
    @Test
    public void test_toString_multiple() {
        String testset_prt = "[uno, dos, tres, cuatro]";

        DynArray dynArr = new DynArray();         // Creamos el array dinámico

        dynArr.add("2");
        dynArr.add("3");
        dynArr.add(0, "uno");
        dynArr.add(3, "cuatro");
        dynArr.remove(1);
        dynArr.set(1, "tres");
        dynArr.add(1, "dos");

        assertEquals(testset_prt, dynArr.toString());   // Comprobamos el valor devuelto por el método toString()
    }           

    //-----------------------------------------------------------------------------------------------
    // Utility methods

    private boolean compareArr(DynArray dyn, String[] arr) {
        for(int i=0; i<arr.length; i++)
            if(!dyn.get(i).equals(arr[i])) return false;
        return true;
    }

    private boolean compareDynArr(DynArray dynArr1, DynArray dynArr2) {
        if(dynArr1.size() != dynArr2.size()) return false;

        for(int i=0; i<dynArr1.size(); i++)
            if(!dynArr1.get(i).equals(dynArr2.get(i))) return false;
        
        return true;
    }
}
