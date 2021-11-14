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

	public static void main(String[] args) {
		System.out.println("kk");
	}

}
