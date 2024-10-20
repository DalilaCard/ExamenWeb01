package com.upizz.examen_01.models;


import java.time.LocalDateTime;

public class Producto {
        private int id;
        private String nombre;        //
        private String descripcion;
        private double precio;
        private int stock;
        private LocalDateTime fecha;

        // Getters y Setters
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public double getPrecio() {
            return precio;
        }
        public void setPrecio(double precio) {
            this.precio = precio;
        }
        public int getStock() {
            return stock;
        }
        public void setStock(int stock) {
            this.stock = stock;
        }
        public LocalDateTime getFecha() {
            return fecha;
        }
        public void setFecha(LocalDateTime fecha) {
            this.fecha = fecha;
        }

    }

