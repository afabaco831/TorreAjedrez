package org.iesalandalus.programacion.torreajedrez;

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

}
