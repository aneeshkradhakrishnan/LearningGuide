package com.training.algorithms.datastructure;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private LinkedListIterator<T> iterator;
	private int size = 0;

	public LinkedList(T value) {
		this(new Node<>(value));
	}

	public LinkedList(Node<T> node) {
		super();
		this.first = node;
		this.last = node;
		this.iterator = new LinkedListIterator(this);
	}
	
	public LinkedList copy(){
//		LinkedList newParent = new LinkedList(this.value);
//		if(null != this.next){
//			newParent.next = this.next.copy();
//		}
//		return newParent;
		return null;
	}
	
	public LinkedList add(T value){
		add(new Node(value));
		return this;
	}

	public LinkedList add(Node<T> node){
		last.setNext(node);
		last = node;
		size++;
		return this;
	}

	public boolean hasCycle() {
		Node head = first;
		if (head == null || head.next == null) {
			return false;
		}
		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}

	public Iterator<T> iterator() {
		return this.iterator;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		while(iterator.hasNext()){
			Node<T> node  = iterator.next();
			sb.append(node.getValue()+" ");
			System.out.print(node.getValue()+", ");
		}
		return sb.toString();
	}

	public static class Node<T> {

		private Node next;
		private T value;

		public Node(T value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		private void setNext(Node next) {
			this.next = next;
		}

		public T getValue() {
			return value;
		}
	}

	public static class LinkedListIterator<T> implements Iterator{

		private Node<T> current;
		private Node<T> first;
		private int iterationCount;
		private LinkedList linkedList;

		private LinkedListIterator(LinkedList linkedList) {
			this.current = linkedList.first;
			this.linkedList = linkedList;
		}

		@Override
		public boolean hasNext() {
			return current != null && current != first && iterationCount <= linkedList.getSize();
		}

		@Override
		public Node<T> next() {
			Node node = current;
			if (first == null) {
				first = current;
			}
			if(null != current) {
				current = current.getNext();
			}
			iterationCount++;
			return node;
		}

		@Override
		public void remove() {

		}

		@Override
		public void forEachRemaining(Consumer action) {

		}
	}
}
