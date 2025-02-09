package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

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
		
		if (colorTorre==null) {
			
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		}
		
		if (colorTorre.equals(Color.BLANCO)) {
			
			setColor(Color.BLANCO);
			setPosicion(new Posicion(1,'h'));
			
		} else {
			
			setColor(Color.NEGRO);
			setPosicion(new Posicion(8,'h'));
		}
	}
	
	public Torre(Color colorTorre, char columna) { // Constructor inicial parametros color y columna
		
		if (colorTorre==null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
			
		}
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
			
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
			
		} else if (direccionTorre==null) {
			
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		
		
		switch (direccionTorre) {
		
		case ARRIBA: 
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()+pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()-pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				} 
				
			} break;
			
		case ABAJO:
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila()-pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} else {
				
				try { 
					
					setPosicion(new Posicion(posicionTorre.getFila()+pasos, posicionTorre.getColumna()));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} break;
			
		case DERECHA:
			
			if (colorTorre.equals(Color.BLANCO)) {
				
				try {
					
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()+pasos)));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
				
			} else {
				
				try {
					setPosicion(new Posicion(posicionTorre.getFila(), (char)(posicionTorre.getColumna()-pasos)));
					
				} catch (IllegalArgumentException e) {
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
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
					
					throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
				}
			} break;
			
		default:
			
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}  
			
			
	}
	
	public void enrocar(Direccion direccionTorre) throws OperationNotSupportedException {
		
		if (direccionTorre==null) {
			
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
			
		} else {
			
			switch (direccionTorre) {
			
			case ENROQUE_CORTO: 
				
				if (colorTorre.equals(Color.BLANCO)){
					
					if (posicionTorre.getFila()==1 && posicionTorre.getColumna()=='h') {
						
						setPosicion(new Posicion (1,'f'));
						setColor(Color.BLANCO);
					} else {
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
					}
					
				} else {
					
					if (posicionTorre.getFila()==8 && posicionTorre.getColumna()=='h'){
						
						setPosicion(new Posicion(8,'d'));
						setColor(Color.NEGRO);
					} else {
						
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
					}
				} break;
				
			case ENROQUE_LARGO:
				
				if (colorTorre.equals(Color.BLANCO)) {
					
					if (posicionTorre.getFila()==1 && posicionTorre.getColumna()=='a') {
						
						setPosicion(new Posicion(1,'d'));
						setColor(Color.BLANCO);
					} else {
						
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
					}
				} else {
					
					if (posicionTorre.getFila()==8 && posicionTorre.getColumna()=='a') {
						
						setPosicion(new Posicion(8,'d'));
						setColor(Color.NEGRO);
					} else {
						
						throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
					}
				} break;
			} 
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(colorTorre, posicionTorre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return colorTorre == other.colorTorre && Objects.equals(posicionTorre, other.posicionTorre);
	}

	@Override
	public String toString() {
		return posicionTorre +"," + " color=" +colorTorre;
	}

}
