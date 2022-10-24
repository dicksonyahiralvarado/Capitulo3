//R-3.13 ¿Cuál es la diferencia entre una prueba de igualdad superficial y una prueba de igualdad profunda 
//entre dos arreglos Java, A y B, si son arreglos unidimensionales de tipo int? ¿Qué sucede si las matrices 
//son matrices bidimensionales de tipo int?

package Ej3_13;

public class Equality {
    
    /* ¿Cuál es la diferencia entre una prueba de igualdad superficial
       y una prueba de igualdad profunda entre dos matrices de Java, A y B,
       si son matrices unidimensionales de tipo int?
       
       ¿Y si las matrices son bidimensionales de tipo int?*/
    
    /* Copia superficial*/

    // En Java, java.lang.Object proporciona clone() método,
    // que es ampliamente utilizado para crear copia del objeto.
    // La implementación por defecto Object.clone() método
    // devuelve una copia exacta del objeto original.

    // Esto funciona bien si la clase contiene solo primitivos y campos inmutables.
    // Pero la asignación de campo por campo no dará como resultado
    // el comportamiento deseado si hay campos mutables, como colecciones y arrays,
    // en la clase, ya que la memoria se compartiría entre el original y la copia.

    //-------------------------------------------------------------------------

    /* Copia profunda */

    // en la que se crean nuevos objetos para los objetos a los que se hace
    // referencia en lugar de referencias a los objetos que se copian.

    // El JDK no proporciona una copia profunda equivalente a Object.clone() método.
    // Pero podemos lograr una copia profunda modificando la implementación
    // predeterminada del Object.clone() método y asigne nueva memoria
    // para los campos mutables del objeto devuelto por super.clone()
    // antes de volver a la persona que llama. Si el objeto tiene referencias
    // a otros objetos como campos, se recomienda llamar al clone() método sobre ellos.
    // Los campos primitivos se pueden ignorar, ya que su contenido ya está copiado.
    // Para campos inmutables como una string, podemos dejar que el método copie la referencia,
    // y tanto el original como su clon compartirán el mismo objeto.

    //-------------------------------------------------------------------------

    /* Diferencias entre copia superficial y copia profunda */

    // 1.
    // La copia superficial es una copia bit a bit de un objeto y funciona bien
    // si la clase contiene solo primitivos y campos inmutables.
    // Pero la asignación campo por campo hará que se copien referencias
    // (dirección de memoria) a campos/objetos mutables.
    // Una copia profunda creará una copia distinta para cada uno de los
    // campos mutables del objeto y los objetos a los que se hace referencia,
    // en lugar de referencias a los objetos que se copian.

    // 2.
    // Se prefiere la copia superficial si un objeto consta 
    // solo de campos primitivos e inmutables.
    // Una copia profunda es un enfoque preferible
    // a una copia superficial cuando un objeto tiene
    // objetos a los que se hace referencia en él.

    // 3.
    // La copia profunda puede ser muchas veces más lenta que la copia superficial.
    // La copia superficial implica copiar solo desde un nivel de un objeto,
    // mientras que la clonación profunda implica copiar de forma recursivamente
    // todos los tipos mutables (involucran varios niveles) que pueden
    // tener un impacto significativo en el rendimiento.

    /*Por lo tanto para la copia unidimensional es mejor la copia profunda ya que
     * la matriz no requiere de tantos datos para realizar una copia y evitan que
     * tarde menos timepo.
     * 
     * Con la bidimensional es mejor la copia suoerficial ya que tarda menos y la matriz
     * dispone de más información y eso tendria una desventaja para la copia profunda.
     * Aunque la copia superficial es mejor esta el problema que funciona bien si la clase
     * solo tiene primitivos y campos inmutables, por lo que hay que tomar en cuenta eso.
    */
}
