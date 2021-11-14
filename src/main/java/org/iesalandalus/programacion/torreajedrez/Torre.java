package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class Torre {
	
	private Color colorTorre;
	private Posicion posicionTorre;
	
	public void setColor(Color colorTorre) { // Método SETTER color
		
		if (colorTorre==null) {
			
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
			
		} else { 
			
			this.colorTorre=colorTorre;
		}
	}
	
	public Color getColor() { //Método GETTER color
		
		return colorTorre;
	}
	
	public void setPosicion(Posicion posicionTorre) { // Método SETTER posicion
		
		if (posicionTorre==null) {
			
			throw new NullPointerException ("ERROR: Posición no válida.");
			
		} else {
			
			this.posicionTorre=posicionTorre;
		}
	}
	
	public Posicion getPosicion() { // Método GETTER posicion
		
		return posicionTorre;
	}
	
	public Torre() { // Constructor por defecto
		
		setColor(Color.NEGRO);
		setPosicion(new Posicion (8,'h'));
	}
	
	public Torre(Color colorTorre) { // Constructor parámetro color
		
		if (colorTorre.equals(Color.BLANCO)) {
			
			setColor(Color.BLANCO);
			setPosicion(new Posicion(1,'h'));
			
		} else {
			
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8,'h'));
		}
	}
	
	public Torre(Color colorTorre, char columna) { // Constructor inicial parametros color y columna
		
		if (columna=='a' || columna=='h') {
			
			if (colorTorre.equals(Color.BLANCO)){
				
				setColor(Color.BLANCO);
				setPosicion(new Posicion (1,columna));
			} else {
				
				setColor(Color.NEGRO);
				setPosicion(new Posicion (8,columna));
			}
			
		} else {
			
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}
	
	public void mover (Direccion direccionTorre, int pasos) throws OperationNotSupportedException {
		
		if (pasos<=0) {
			
			throw new IllegalArgumentException("ERROR: El número de pasos es positivo.");
			
		} else if (posicionTorre==null) {
			
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		
		switch (direccionTorre) {
		
		case ARRIBA: 
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()+pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} else {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()-pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				} 
				
			} break;
			
		case ABAJO:
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()-pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} else {
				
				try { 
					
					setPosicion(new Posicion(posicionTorre.getFila()+pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} break;
			
		case DERECHA:
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()+pasos)));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
				
			} else {
				
				try {
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()-pasos)));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} break;
			
		case IZQUIERDA:
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()-pasos)));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} else {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()+pasos)));
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido, (se sale del tablero).");
				}
			} break;
			
		default:
			
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}  
			
			
	}

}
