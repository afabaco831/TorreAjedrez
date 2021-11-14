package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	private static Torre torre;
	
	private static void mostrarTorre() {
		
		System.out.println(torre.toString());
	}
	
	private static void mostratMenu() {
		
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
			
		} while (respuesta!='b' || respuesta!='n');
		
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
		} while (columnaInicial != 'a' || columnaInicial!='h');
		
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
		} while (opcionDireccion<1 || opcionDireccion>6);
		
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
	
	

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
