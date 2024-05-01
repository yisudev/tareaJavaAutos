package com.mycompany.auto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AutoApp {

    public static void main(String[] args) {
        int opcion;
        ArrayList<Auto> cars = new ArrayList<Auto>();
        Scanner sc = new Scanner(System.in);
        int id;
        do {
            System.out.println("Ingresa la opcion: ");
            System.out.println("1- ingresar registro");
            System.out.println("2- Mostrar registro");
            System.out.println("3- Editar registro");
            System.out.println("4- Salir del Programa");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    if (cars.size() == 0) {
                        id = 1;
                    } else {
                        id = cars.size() + 1;
                    }
                    System.out.println("Marca: ");
                    String marca = sc.next();
                    System.out.println("Modelo: ");
                    String modelo = sc.next();
                    int año = 0;
                    while (año == 0) {
                        try {
                            System.out.println("Año: ");
                            año = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor, ingresa un año válido.");
                            sc.next(); // Limpiar el buffer del scanner
                        }
                    }
                    System.out.println("Tipo: ");
                    String tipo = sc.next();
                    System.out.println("Número de Chasis: ");
                    String numeroChasis = sc.next();
                    System.out.println("Color: ");
                    String color = sc.next();
                    Auto auto = new Auto(id, marca, modelo, año, tipo, numeroChasis, color);
                    cars.add(auto);
                    System.out.println("El id es: " + id);
                    break;
                case 2:
                    if (cars.size() == 0) {
                        System.out.println("No hay autos registrados.");
                        break;
                    }
                    System.out.println("Número de Chasis: ");
                    numeroChasis = sc.next();
                    for (int i = 0; i < cars.size(); i++) {
                        if (cars.get(i).getNumeroChasis().equals(numeroChasis)) {
                            System.out.println(cars.get(i).toString());
                        }
                    }
                    break;
                case 3:
                    if (cars.size() == 0) {
                        System.out.println("No hay autos registrados.");
                        break;
                    }
                    System.out.println("ID del auto a editar: ");
                    id = sc.nextInt();
                    for (int i = 0; i < cars.size(); i++) {
                        if (cars.get(i).getId() == id) {
                            System.out.println("Ingrese los nuevos datos del auto");
                            System.out.println("Marca: ");
                            marca = sc.next();
                            System.out.println("Modelo: ");
                            modelo = sc.next();
                            año = 0;
                            while (año == 0) {
                                try {
                                    System.out.println("Año: ");
                                    año = sc.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("Por favor, ingresa un año válido.");
                                    sc.next(); // Limpiar el buffer del scanner
                                }
                            }
                            System.out.println("Tipo: ");
                            tipo = sc.next();
                            System.out.println("Número de Chasis: ");
                            numeroChasis = sc.next();
                            System.out.println("Color: ");
                            color = sc.next();
                            cars.get(i).setMarca(marca);
                            cars.get(i).setModelo(modelo);
                            cars.get(i).setAño(año);
                            cars.get(i).setTipo(tipo);
                            cars.get(i).setNumeroChasis(numeroChasis);
                            cars.get(i).setColor(color);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
}
