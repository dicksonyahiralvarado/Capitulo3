/*R-3.8 Describa un método para encontrar el nodo medio de una lista doblemente enlazada con centinelas de 
encabezado y final mediante "saltos de enlace" y sin depender del conocimiento explícito del tamaño de la lista. 
En el caso de un número par de nodos, informe el nodo ligeramente a la izquierda del centro como el "medio". 
¿Cuál es el tiempo de ejecución de este método?
*/

return m.previousNode()
Comenzar con n= encabezado, m= trailer
While n.nextNod()!=m.previousNode() OR n.element()!=m.previousNode() do{
n=n.nextNode(), m=m.previousNode()}
return m.previousNode()

/*
El tiempo de ejecución será k/2 con números pares. Porque con longitudes de 2, 4 y 6 podemos ver fácilmente que
el tiempo de ejecución es respectivamente 1, 2 y 3 iteraciones. Con impar vemos que si es de longitud uno, 
tenemos la solución instantáneamente, con 3 solo se necesita una iteración, etc. Entonces (k-1)/2 tiempo de 
ejecución con números impares.
*/