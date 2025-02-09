package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static Torre torre;
	
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		}catch (NullPointerException e) {
			System.out.println("ERROR: No se creó ninguna torre.");
		}
	}
	
	private static void mostrarMenu() {
		
		System.out.println("MENÚ DE SELECCIÓN DE OPCIONES: ");
		System.out.println("1. Crear torre por defecto");
		System.out.println("2. Crear torre de un color a elegir.");
		System.out.println("3. Crear torre de un color y columna inicial a elegir.");
		System.out.println("4. Mover la torre.");
		System.out.println("5. Salir.");
		
	}
	
	private static int elegirOpcion() {
		
		int opcion;
		
		do {
			System.out.println("Elija una opción (1-5):");
			opcion=Entrada.entero();
		} while (opcion<1 || opcion>5);
		
		return opcion;
	}
	
	private static Color elegirColor() {
		
		Color opcionColor=null;
		char respuesta;
		
		do {
			System.out.println("Elija un color: blancas o negras (b/n):");
			respuesta=Entrada.caracter();
			
		} while (respuesta!='b' && respuesta!='n');
		
		if (respuesta=='b') {
			opcionColor=Color.BLANCO;
		} else if (respuesta=='n') {
			opcionColor=Color.NEGRO;
		}
		
		return opcionColor;
	}
	
	private static char elegirColumna() {
		
		char columnaInicial;
		
		do {
			System.out.println("Elija una columna inicial ('a'/'h')");
			columnaInicial=Entrada.caracter();
		} while (columnaInicial != 'a' && columnaInicial!='h');
		
		return columnaInicial;
	}
	
	private static void mostrarMenuDirecciones() {
		
		System.out.println("MENÚ DE DIRECCIONES:");
		System.out.println("1. ARRIBA");
		System.out.println("2. ABAJO");
		System.out.println("3. IZQUIERDA");
		System.out.println("4. DERECHA");
		System.out.println("5. ENROQUE CORTO");
		System.out.println("6. ENROQUE LARGO");
	}
	
	private static Direccion elegirDireccion() {
		
		Direccion direccion=null;
		int opcionDireccion;
		
		do { 
			System.out.println("Elija una dirección para mover la torre (1-6):");
			opcionDireccion=Entrada.entero();
		} while (opcionDireccion<1 && opcionDireccion>6);
		
		switch (opcionDireccion) {
		
		case 1:
			direccion=Direccion.ARRIBA;
			break;
		case 2:
			direccion=Direccion.ABAJO;
			break;
		case 3:
			direccion=Direccion.IZQUIERDA;
			break;
		case 4:
			direccion=Direccion.DERECHA;
			break;
		case 5:
			direccion=Direccion.ENROQUE_CORTO;
			break;
		case 6: 
			direccion=Direccion.ENROQUE_LARGO;
		}
		
		return direccion;
	}
	
	private static void crearTorreDefecto() {
		
		torre= new Torre();
		
	}
	
	private static void crearTorreColor() {
		
		try {
			
			torre= new Torre(elegirColor());
			
		} catch (NullPointerException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	private static void crearTorreColorColumna() {
		
		try {
			
			torre= new Torre(elegirColor(), elegirColumna());
			
		} catch (NullPointerException | IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	private static void mover() {
		
		int pasos;
		Direccion direccion=null;
		 
		if (torre==null) {
			
			System.out.println("Antes de mover la torre, debe crear una.");
			
			
		} else {
			mostrarMenuDirecciones();
			direccion=elegirDireccion();
			
			if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
				
				try {
					torre.enrocar(direccion);
					
				} catch (OperationNotSupportedException e) {
					
					System.out.println(e.getMessage());
				}
			} else {
				
				System.out.println("Introduzca el número de pasos para mover la torre:");
				pasos=Entrada.entero();
				
				try {
					
					torre.mover(direccion, pasos);
					
				} catch (OperationNotSupportedException e) {
					
					System.out.println(e.getMessage());
				}
			}	
		}
	}
	
	private static void ejecutarOpcion(int opcion) {
		
		
		switch (opcion) {
		
		case 1:
			
			crearTorreDefecto();
			break;
			
		case 2:
			crearTorreColor();
			break;
			
		case 3:
			crearTorreColorColumna();
			break;
			
		case 4:
			mover();
			break;
			
		case 5:
			System.out.println("Adiós.");
		}
		
	}
	
	

	public static void main(String[] args) {
		
		int opcion;
		
		do {
			
			mostrarMenu();
			opcion=elegirOpcion();
			ejecutarOpcion(opcion);
			mostrarTorre();
				
		} while (opcion!=5);
	}

}
