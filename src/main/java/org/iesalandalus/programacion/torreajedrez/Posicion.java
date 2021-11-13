package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	
	private int fila;
	private char columna;
	
	public void setFila(int fila) { // Método SETTER fila
		
		if (fila<1 || fila>8) {
			
			throw new IllegalArgumentException("EROOR: Fila no válida.");
			
		} else {
			
			this.fila=fila;
		}
	}
	
	public int getFila() { //Método GETTER fila
		
		return fila;
	}
	
	public void setColumna(char columna) { //Método SETTER columna
		
		if (columna<'a' || columna>'h') {
			
			throw new IllegalArgumentException("ERROR: Columna no válida.");
			
		} else {
			
			this.columna=columna;
		}
	}
	
	public char getColumna() { //Método GETTER columna
		
		return columna;
	}

}
