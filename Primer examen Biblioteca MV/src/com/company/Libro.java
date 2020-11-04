package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Libro {
    private String nombre;
    private  int anio;
    private int isbn;
    private  int existencia;
    public Scanner scanner = new Scanner(System.in);
    ArrayList<Libro> listalibros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
    public Libro agregar()//Creamos del tipo de la clase para enviar sin errores a la instancia
    {
        System.out.println("Ingresa el nombre del libro");
        String nombre = scanner.next(); int i=0;
        System.out.println("Ingrese el anio de publicacion");
        int anio = scanner.nextInt();
        System.out.println("Ingrese el ISBN");
        int isbn = scanner.nextInt();
        System.out.println("Ingrese la cantidad de libros a ingresar");
        int cant = scanner.nextInt();
        System.out.println("Libro aniadido con exito");

        Libro nuevolibro = new Libro();
        nuevolibro.setAnio(anio);
        nuevolibro.setExistencia(cant);
        nuevolibro.setNombre(nombre);
        nuevolibro.setIsbn(isbn);
        return nuevolibro;//enviamos el objeto con sus atributos para solo agregarlo en el main

    }
    public  void  consultarportipo(ArrayList<Libro> libros)
    {
        System.out.println("Por que metodo quieres consultar el libro\n1.Nombre\n2.Anio\n3.ISBN");
        int opcion2 = scanner.nextInt();
        switch (opcion2) {
            case 1://nombre
            {
                System.out.println("Cual es el nombre del libro");
                String nombre = scanner.next();
                int i=0;
                for (Libro nuevolibro : libros)
                {
                    if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
                    {
                        System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
                    }
                    else {//si no hay coicidencias mandar solo un mensaje de error
                        if(i==0){
                            System.out.println("No hubo ninguno concidencia");
                        }
                    }
                    i++;
                }
                break;
            }
            case 2://anio
            {
                System.out.println("Cual es el anio del libro a consultar");
                int anio = scanner.nextInt();
                int i=0;
                for (Libro nuevolibro : libros)
                {
                    if (anio==(nuevolibro.getAnio()))
                    {
                        System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
                    }
                    else {
                        if(i==0){
                            System.out.println("No hubo ninguno concidencia");
                        }
                    }
                    i++;
                }
                break;
            }
            case 3://ISBM
            {
                System.out.println("Cual es el ISBM del libro");
                int ISBM = scanner.nextInt();
                int i=0;
                for (Libro nuevolibro : libros) {
                    if (ISBM==(nuevolibro.getIsbn()))
                    {
                        System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISBN:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia()+"\n");
                    }
                    else {
                        if(i==0){
                            System.out.println("No hubo ninguno concidencia");
                        }
                    }
                   i++;
                }
                break;
            }
        }
    }
    public  void  consultartodos(ArrayList<Libro>libros)
    {
        System.out.println("Estos son todos los Libros");
        for(Libro nuevolibro :libros)
        {
            System.out.println("Nombre:"+nuevolibro.getNombre()+"\nAnio:"+nuevolibro.getAnio()+"\nISNB:"+nuevolibro.getIsbn()+"\nCantidad:"+nuevolibro.getExistencia()+"\n");
        }
    }
    public void prestaralv(ArrayList<Libro> libros) {
        System.out.println("Ingresa el nombre del libro que deseas alquilar?");
            String num = scanner.next();
            int i = 0;
        for (Libro nuevolibro : libros)
        {
            int comprobar = nuevolibro.getExistencia();
            if (comprobar > 1)//Comprobar si hay existencias del libro que se quiere
            {
                if (num.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))//Si el nombre coincide
                {
                    int NV = nuevolibro.getExistencia() - 1;
                    nuevolibro.setExistencia(NV);
                    if (i == 0)
                    {System.out.println("Muy bien el libro " + num + " se ha prestado");}
                }
                else {//Si el nombre no es correcto
                    if (i==0)
                    {System.out.println("El libro que estas buscando no existe en nuestro catalogo");}
                }
            }//No hay coincidencias con el nombre
            else {//Si la existencia es menor a 1
                if(i==0) { System.out.println("No hay existencias del libro que estas buscando");}
            }
            i++;//Que no se repita
        }
    }


    public void  regresar(ArrayList<Libro>libros)
    {
        System.out.println("Cual es el nombre del libro que deseas regresar?");
        String nomdev = scanner.next();
        for (Libro nuevolibro : libros)
        {
            if (nomdev.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
            {
                int NV = nuevolibro.getExistencia() + 1;
                nuevolibro.setExistencia(NV);
            }
        }
        System.out.println("Muy bien el libro "+nomdev+" se ha devuelto");
    }
    public void  verexistencia(ArrayList<Libro>libros)
    {
        System.out.println("Estos son las existencias de libros");
        for(Libro nuevolibro :libros)
        {
            System.out.println(nuevolibro.getNombre()+" "+nuevolibro.getExistencia()+"\n");
        }
    }
    public void modificardatos(ArrayList<Libro>libros)//Este metodo hace tod lo de las anteriores pero mas chidi
    {
        System.out.println("Cual es el nombre del libro");
        String nombre = scanner.next();
        int i=0;
        for (Libro nuevolibro : libros)
        {
            if (nombre.toUpperCase().equals((nuevolibro.getNombre().toUpperCase())))
            {
                if(i==0) {
                    System.out.println("El libro consultado es\nNombre:" + nuevolibro.getNombre() + "\nAnio:" + nuevolibro.getAnio() + "\nISNB:" + nuevolibro.getIsbn() + "\nCantidad:" + nuevolibro.getExistencia() + "\n");
                    System.out.println("Que dato deseas modificar?\n1.Nombre\n2.Anio\n3.ISBN\n4.Existencias");
                    int opcion = scanner.nextInt();
                    switch (opcion) {
                        case (1): {
                            System.out.println("Ingresa el nuevo nombre que tendra el libro");
                            String NN = scanner.next();
                            nuevolibro.setNombre(NN);
                            System.out.println("El nombre ha sido actualizado con exito\n");
                        }
                        break;
                        case (2): {
                            System.out.println("Ingresa el nuevo anio que tendra el libro");
                            int NA = scanner.nextInt();
                            nuevolibro.setAnio(NA);
                            System.out.println("El Anio ha sido actualizado con exito\n");
                        }
                        break;
                        case (3): {
                            System.out.println("Ingresa el nuevo ISBN que tendra el libro");
                            int NI = scanner.nextInt();
                            nuevolibro.setIsbn(NI);
                            System.out.println("El ISBN ha sido actualizado con exito\n");
                        }
                        break;
                        case (4): {
                            System.out.println("Ingresa las existencias que tendra el libro");
                            int NE = scanner.nextInt();
                            nuevolibro.setExistencia(NE);
                            System.out.println("Las existencias han sido actualizadas con exito\n");
                        }
                        break;
                    }
                }
                i++;
            }
            else {//si no hay coicidencias mandar solo un mensaje de error
                if(i==0){
                    System.out.println("No hubo ninguna concidencia\n");
                }
            }

        }

    }
}
