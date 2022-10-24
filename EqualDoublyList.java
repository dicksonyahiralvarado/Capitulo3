//R-3.16 Implemente el método equals() para la clase DoublyLinkedList.

package Ej3_16;

public class EqualDoublyList {

    public class Nodo {

        /* El elemento del nodo. */
        private Object elemento;
        /* El nodo anterior. */
        private Nodo anterior;
        /* El nodo siguiente. */
        private Nodo siguiente;
        
        //Construye un nodo con un elemento..
        public Nodo(Object elemento) {
            this.elemento=elemento;
            this.anterior=null;
            this.siguiente=null;
        }

        //Regresa el nodo anterior del nodo.
        public Nodo getAnterior() {
            return this.anterior;
        }


        //Regresa el nodo siguiente del nodo.
        public Nodo getSiguiente() {
            return this.siguiente;
        }

        //Regresa el elemento del nodo.
        public Object get() {
            return this.elemento;
        }
    }

    //Primer elemento de la lista.
    private Nodo cabeza;
    //Último elemento de la lista.
    private Nodo cola;
    // Número de elementos en la lista.
    private int longitud;

    //Regresa la longitud de la lista, el número de elementos que contiene.
    public int getLongitud() {
        return this.longitud;
    }

    /*
     * Nos dice si la lista es vacía.
     * <code>true</code> si la lista es vacía, <code>false</code> en otro caso.
     */
    public boolean esVacia() {
        return cabeza==null;
    }

    /*
     * Agrega un elemento al final de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     */
    public void agregaFinal(Object elemento) {
        Nodo n=new Nodo(elemento);
        if (!esVacia()){
          cola.siguiente=n;
          cola.siguiente.anterior=cola;
          cola=n;
          longitud++;
        }else{
          cabeza=n;
          cola=n;
          longitud++;
        }
    }

    /*
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y último.
     */
    public void agregaInicio(Object elemento) {
        Nodo n=new Nodo(elemento);
        if (!esVacia()){
          cabeza.anterior=n;
          cabeza.anterior.siguiente=cabeza;
          cabeza=n;
          longitud++;
        }else{
          cabeza=n;
          cola=n;
          longitud++;
        }
    }

    /*
     * Inserta un elemento en un índice explícito.
     *
     * Si el índice es menor o igual que cero, el elemento se agrega al inicio
     * de la lista. Si el índice es mayor o igual que el número de elementos en
     * la lista, el elemento se agrega al fina de la misma. En otro caso,
     * después de mandar llamar el método, el elemento tendrá el índice que se especifica en la lista.
     * i el índice dónde insertar el elemento. Si es menor que 0 el
     * elemento se agrega al inicio de la lista, y si es mayor o igual
     * que el número de elementos en la lista se agrega al final.
     */
    public void inserta(int i, Object elemento) {
        Nodo n= new Nodo(elemento);
        if (i<=0){
            agregaInicio(elemento);
        }else if (i>=getLongitud()){
            agregaFinal(elemento);
        }else if(getLongitud()==0){
            cabeza=n;
            cola=n;
            longitud++;
        }else{
          int cont=0;
          Nodo aux=cabeza;
          while(cont<i){
            aux=aux.siguiente;
            cont++;
          }
          aux.anterior.siguiente=n;
          aux.anterior=n;
          n.siguiente=aux;
          n.anterior=aux.anterior.anterior;
          longitud++;
        }

    }

    /*
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no la modifica.
     */
    public void elimina(Object elemento) {
        if(!esVacia() && contiene(elemento)){
          if(cabeza.siguiente==null){
            cabeza=null;
            cola=null;
            longitud--;
          }else{
            Nodo n=cabeza;
            while(n.siguiente!=null && !n.get().equals(elemento)){
              n=n.siguiente;
            }
            if(n.anterior==null){
              eliminaPrimero();
            }else if (n.siguiente==null){
              eliminaUltimo();
            }else{
              n.siguiente.anterior=n.anterior;
              n.anterior.siguiente=n.siguiente;
              n.siguiente=null;
              n.anterior=null;
              longitud--;
            }
          }
        }
    }

    /*
     * Elimina el primer elemento de la lista y lo regresa.
     * el primer elemento de la lista antes de eliminarlo, o <code>null</code> si la lista está vacía.
     */
    public Object eliminaPrimero() {
        if(!esVacia()){
          Nodo n=cabeza;
          if(cabeza.siguiente==null){
            cabeza=null;
            cola=null;
          }else{
            cabeza=cabeza.siguiente;
            cabeza.anterior.siguiente=null;
            cabeza.anterior=null;
          }
          longitud--;
          return n.get();
        }
        return null;
    }

    /*
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo, o <code>null</code> si la lista está vacía.
     */
    public Object eliminaUltimo() {
        // Aquí va su código.
        if(!esVacia()){
          Nodo n=cola;
          if(cola.anterior==null){
            cabeza=null;
            cola=null;
          }else{
            cola=cola.anterior;
            cola.siguiente.anterior=null;
            cola.siguiente=null;
          }
          longitud--;
          return n.get();
        }
        return null;
    }

    /*
     * Nos dice si un elemento está en la lista.
     *  el elemento que queremos saber si está en la lista.
     *  <tt>true</tt> si <tt>elemento</tt> está en la lista, <tt>false</tt> en otro caso.
     */
    public boolean contiene(Object elemento) {
        Nodo aux=cabeza;
        for (int i=1;i<=getLongitud();i++){
          if(aux.get().equals(elemento)){
            return true;
          }
          aux=aux.siguiente;
        }
        return false;
    }

    /*
     * Regresa la reversa de la lista.
     * Una nueva lista que es la reversa la que manda llamar el método.
     */
    public EqualDoublyList reversa() {
        // Aquí va su código.
        EqualDoublyList rev=new EqualDoublyList();
        Nodo n=cola;
        for(int i=1;i<=getLongitud();i++){
          rev.agregaFinal(n.get());
          n=n.anterior;
        }
        return rev;
    }

    /*
     * Regresa una copia de la lista. La copia tiene los mismos elementos que la
     * lista que manda llamar el método, en el mismo orden.
     */
    public EqualDoublyList copia() {
        EqualDoublyList l=new EqualDoublyList();
        Nodo n=cabeza;
        for(int i=1;i<=getLongitud();i++){
          l.agregaFinal(n.get());
          n=n.siguiente;
        }
        return l;
    }

    /*
     * Limpia la lista de elementos. El llamar este método es equivalente a
     * eliminar todos los elementos de la lista.
     */
    public void limpia() {
        Nodo n=cabeza;
        while(getLongitud()!=0){
          eliminaPrimero();
        }
    }

    /*
     * Regresa el primer elemento de la lista.
     * El primer elemento de la lista, o <code>null</code> si la lista es vacía.
     */
    public Object getPrimero() {
        if(!esVacia()){
          return cabeza.get();
        }
        return null;
    }

    /*
     * Regresa el último elemento de la lista.
     * El primer elemento de la lista, o <code>null</code> si la lista es vacía.
     */
    public Object getUltimo() {
        if(!esVacia()){
          return cola.get();
        }
        return null;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista. Si el índice es menor
     * que cero o mayor o igual que el número de elementos de la lista, el
     * método regresa <tt>null</tt>.
     * i el índice del elemento que queremos.
     * el <em>i</em>-ésimo elemento de la lista, si <em>i</em> es mayor
     * o igual que cero y menor que el número de elementos en la lista; <tt>null</tt> en otro caso.
     */
    public Object get(int i) {
        if(0<=i && i<getLongitud()){
          Nodo n=cabeza;
          int cont=0;
          while(n.siguiente!=null && cont<i){
            n=n.siguiente;
            cont++;
          }
          return n.get();
        }
        return null;
    }

    /*
     * Regresa el índice del elemento recibido en la lista.
     * El elemento del que se busca el índice.
     * El índice del elemento recibido en la lista, o -1 si el elemento no está contenido en la lista.
     */
    public int indiceDe(Object elemento) {
        if(contiene(elemento)){
          int contador=0;
          Nodo aux=cabeza;
          while(!aux.get().equals(elemento)){
            aux=aux.siguiente;
            contador++;
          }
          return contador;
        }
        return -1;
    }

    /*
     * Regresa una representación en cadena de la lista.
     */
    @Override public String toString() {
        if (getLongitud()==0){
          return "[]";
        }
        String s = "[";
        for (int i = 0; i < getLongitud()-1; i++)
            s += String.format("%s, ", (String)get(i));
        s += String.format("%s]", (String)get(getLongitud()-1));
        return s;
    }

    /**
     * Nos dice si la lista es igual al objeto recibido.
     * O el objeto con el que hay que comparar. <tt>true</tt> si la lista es igual al objeto recibido;
     *<tt>false</tt> en otro caso.
     */
    @Override public boolean equals(Object o) {
        if (!(o instanceof EqualDoublyList))
            return false;
            EqualDoublyList lista = (EqualDoublyList)o;
        if(getLongitud()!=lista.getLongitud())
            return false;
        Nodo aux1=this.cabeza;
        Nodo aux2=lista.cabeza;
        for(int i=0;i<getLongitud();i++){
            if(!aux1.get().equals(aux2.get()))
                return false;
            aux1=aux1.siguiente;
            aux2=aux2.siguiente;
        }
        return true;
    }

    /*
     * Regresa el nodo cabeza de la lista.
     */
    public Nodo getCabeza() {
        return this.cabeza;
    }

    /*
     * Regresa el nodo rabo de la lista.
     */
    public Nodo getRabo() {
        return this.cola;
    }
}
