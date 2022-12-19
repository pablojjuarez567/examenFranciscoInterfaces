package com.example.examenfranciscointerfaces;

public class Persona {
    private String nombre;
    private int edad;
    private String sexo;
    private double peso;
    private Integer altura;
    private String actividad;
    private int ger;
    private int get;
    public Persona(String nombre, int edad, String sexo, double peso, Integer altura, String actividad) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.actividad = actividad;

        if(sexo.equals("Hombre")) {
            this.ger = (int) (66.4730 + (13.7516 * peso) + (5.0033 * altura) - (6.755 * edad));

            switch (actividad){
                case "Muy ligera":
                    this.get = (int) (ger * 1.3);
                    break;
                case "Ligera":
                    this.get = (int) (ger * 1.6);
                    break;
                case "Moderada":
                    this.get = (int) (ger * 1.7);
                    break;
                case "Intensa":
                    this.get = (int) (ger * 2.1);
                    break;
            }
        } else if(sexo.equals("Mujer")) {
            this.ger = (int) (655.0955 + (9.5634 * peso) + (1.8496 * altura) - (4.6756 * edad));

            switch (actividad){
                case "Muy ligera":
                    this.get = (int) (ger * 1.3);
                    break;
                case "Ligera":
                    this.get = (int) (ger * 1.5);
                    break;
                case "Moderada":
                    this.get = (int) (ger * 1.6);
                    break;
                case "Intensa":
                    this.get = (int) (ger * 1.9);
                    break;
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public int getGer() {
        return ger;
    }

    public void setGer(int ger) {
        this.ger = ger;
    }

    public int getGet() {
        return get;
    }

    public void setGet(int get) {
        this.get = get;
    }
}
