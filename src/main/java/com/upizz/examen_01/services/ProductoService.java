package com.upizz.examen_01.services;

import com.upizz.examen_01.models.Producto;
import com.upizz.examen_01.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    // Requerimos el repositorio de (datos-listado) de productos
    private final ProductoRepository productoRepository;

    // Constructor - cuando creo la instancia le paso el repositorio
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Obtener todos los productos
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Producto getProductoById(int id) {
        return productoRepository.findById(id);
    }

    // Crear un nuevo producto
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Actualizar un producto existente
    public Producto updateProducto(int id, Producto producto) {
        return productoRepository.update(id, producto);
    }

    // Eliminar un producto por ID
    public boolean deleteProducto(int id) {
        return productoRepository.delete(id);
    }
}
