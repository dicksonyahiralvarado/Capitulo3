R-3.5 El método removeFirst de la clase SinglyLinkedList incluye un caso especial para restablecer el campo de 
cola a nulo cuando se elimina el último nodo de una lista (consulte las líneas 51 y 52 del fragmento de código 
3.15). ¿Cuáles son las consecuencias si elimináramos esas dos líneas del código? 
Explique por qué la clase funcionaría o no con tal modificación.

Tail está definido explícitamente y debe eliminarse explícitamente. Si no se hace, se señalará un objeto y, 
por lo tanto, nunca será candidato para la recolección de elementos no utilizados. Por lo tanto, la línea es 
necesaria para establecer el puntero de tail en nulo para que el objeto de cola no sea señalado y su memoria 
liberada por la recolección de basura de Java. De lo contrario, se producirá una fuga de memoria y, 
potencialmente, el programa colapsará. La clase continuaría funcionando solo porque el elemento 
tail.get.element solo se llama cuando el tamaño no es igual a cero, el tamaño sería == 0. Además, llamar a 
agregar primero arreglar tail.
