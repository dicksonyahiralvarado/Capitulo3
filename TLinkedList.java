//R-3.12 Implemente un método de rotate() en la clase SinglyLinkedList, que tiene una semántica igual a 
//addLast(removeFirst()), pero sin crear ningún nodo nuevo.

class Illegal extends IllegalArgumentException {}
class Empty extends ArrayIndexOutOfBoundsException {}

public class TLinkedList<E> {

	private static class Node<E> {
		private E data;
		private Node<E> next;

		/** Constructor con valor especificado que apunta a nadie. */
		public Node(E data) {
			this(data,null);
		}

		/** Constructor con valor especificado que apunta al objetivo. */
		public Node(E data, Node<E> next) { 
			this.data = data;
			this.next = next;
		}
		public E getData() { return this.data; }
		public Node<E> getNext() { return this.next; }
		public void setNext(Node<E> node) { this.next = node; }
		public String toString() { return this.data.toString(); }
	}


	//////////////////////////////////


	private Node<E> head; // puntero a la cabeza de la lista (primer elemento)
	private Node<E> tail; //puntero a la cola de la lista (último elemento)
	private int size; // tamaño de la lista (número de elementos)

	public TLinkedList() { 
		head=null; tail=null;
		size = 0;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		if(isEmpty()) {
			sb.append("]");
			return sb.toString();
		} 
		Node<E> runner = head;
		sb.append( runner.toString() );
		while(runner.getNext()!=null) {
			// El orden es importante aquí
			runner = runner.getNext();
			sb.append(", ");
			sb.append( runner.toString() );
		}
		sb.append("]");
		return sb.toString();
	}

	/** El tamaño de esta cosa */
	public int size() { return size; }
	
	/** Devuelve true si está vacío. */
	public boolean isEmpty() { return this.size==0; }

	/** Devuelve la referencia al primer elemento de la lista. */
	public E first() { return head.getData(); }

	/** Devuelve la referencia al último elemento de la lista. */
	public E last()  { return tail.getData(); }


	/** Invertir toda la lista enlazada en tiempo O(n). */
	public void reverse() { 
		if(this.size==0 || this.size==1) {
			return;
		}
		Node<E> runner = this.head;
		Node<E> prev = null;
		Node<E> next_runner = this.head.getNext();

		while(next_runner!=null){
			runner.setNext(prev);
			prev = runner;
			runner = next_runner;
			next_runner = next_runner.getNext();
		}
		this.head = runner;
	}

	/** Rota la lista moviendo un elemento de adelante hacia atrás.
	 *
	 * Esto se implementa sin crear/destruir un nodo.
	 */
	public void rotate() { 
		if(this.size==0 || this.size==1) { 
			return;
		}
		// Hacer circular
		tail.setNext(this.head);
		tail = tail.getNext();
		
		// Circular
		head = tail.getNext();

		// Romper el círculo
		tail.setNext(null);

	}

	/** Añadir un elemento al principio de la lista. */
	public void addFirst(E e)  { 
		Node<E> newhead = new Node<E>(e);
		Node<E> oldhead = this.head;
		if(isEmpty()) { 
			this.head = newhead;
			this.tail = newhead;
		} else {
			// Establecer el puntero del nodo insertado en la cabeza antigua
			newhead.setNext(oldhead);
			// Establecer el puntero de la cabeza al nodo insertado
			this.head = newhead; 
		}
		size++;
	}

	/** Añadir un elemento al principio de la lista. */
	public void addLast(E e) { 
		Node<E> newtail = new Node<E>(e);
		if(isEmpty()) { 
			this.head = newtail;
			this.tail = newtail;
		} else {
			// Establecer el puntero de cola al nodo anexado
			this.tail.setNext(newtail);
			this.tail = newtail;
		}
		size++;
	}

	public E removeFirst() throws Empty {
		if(isEmpty()) { 
			throw new Empty();
		}
		E value = this.head.getData();

		// actualizar head para que apunte a head.next
		Node<E> newhead = this.head.getNext();
		this.head = newhead;
		size--;

		return value;
	}


	//////////////////////////////////


	/** Construir una lista ficticia estática. */
	public static TLinkedList<Integer> getTLinkedList() {
		TLinkedList<Integer> l = new TLinkedList<Integer>();
		l.addFirst(42);
		l.addFirst(5);
		l.addFirst(4);
		l.addFirst(3);
		l.addFirst(2);
		l.addFirst(1);
		l.addFirst(0);
		return l;
	}

	/** Método Main. */
	public static void main(String[] args) throws Illegal, Empty { 

		TLinkedList<Integer> list;
		list = getTLinkedList();

		System.out.println("Inicio:");
		System.out.println(list);

		System.out.println("Rotar:");

		list.rotate();
		System.out.println(list);

		System.out.println("Rotar 3:");
		list.rotate();
		System.out.println(list);
		list.rotate();
		System.out.println(list);
		list.rotate();
		System.out.println(list);

		for(int i=0; i<20; i++) { 
			list.rotate();
			System.out.println(list);
		}
		System.out.println("¡Uf! Ahora estoy mareado...");

	}

	public static void oldTest() throws Illegal, Empty {

		TLinkedList<Integer> list;
		
		System.out.println("Inicio:");
		list = getTLinkedList();
		System.out.println(list);
		System.out.println("Tamanio: "+list.size());

		System.out.println("Retira las 4 primeras veces:");
		list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		list.removeFirst();
		System.out.println(list);
		System.out.println("Tamanio: "+list.size());

		list = getTLinkedList();
		System.out.println("Inicio:");
		System.out.println(list);

		System.out.println("Adding first");
		list.addFirst(105);
		list.addFirst(104);
		list.addFirst(103);
		list.addFirst(102);
		list.addFirst(101);
		list.addFirst(100);
		System.out.println(list);
		System.out.println("Tamanio: "+list.size());

		System.out.println("Añadiendo la última");
		list.addLast(997);
		list.addLast(998);
		list.addLast(999);
		list.addLast(1000);
		System.out.println(list);

		System.out.println("Invertir");
		list.reverse();
		System.out.println(list);

		for(int i=0; i<1000; i++) { 
			try {
				list.removeFirst();
			} catch(Illegal e) { 
				System.out.println("Illegal index");
				break;
			} catch(Empty e) { 
				System.out.println("Lista vacía");
				break;
			}

		}
		System.out.println("Terminado con las pruebas de TLinkedList.");
	}
}
