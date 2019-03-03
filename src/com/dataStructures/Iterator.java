package com.dataStructures;

import java.util.NoSuchElementException;

public interface Iterator {
	boolean hasNext ();
	Object next () throws NoSuchElementException;
}