package com.upizz.examen_01.repository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.upizz.examen_01.models.Producto;
import org.springframework.stereotype.Repository;



@Repository
public class ProductoRepository {
    private final String filePath = "src/main/resources/productos.json";

    private List<Producto> productos = new ArrayList<>();
    private int currentId = 1;

    public ProductoRepository() {
        loadProductos();
    }

    // Cargar productos desde el archivo JSON
    private void loadProductos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            productos = objectMapper.readValue(new File(filePath), new TypeReference<List<Producto>>() {});
            if (!productos.isEmpty()) {
                currentId = productos.get(productos.size() - 1).getId() + 1;
            }
        } catch (IOException e) {
            // Si no se encuentra el archivo, se inicializa una lista vacía
            productos = new ArrayList<>();
        }
    }

    // Obtener todos los productos (GET)
    public List<Producto> findAll() {
        return productos;
    }

    // Obtener un producto por ID (GET)
    public Producto findById(int id) {
        return productos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    // Guardar un nuevo producto (POST)
    public Producto save(Producto producto) {
        producto.setId(currentId++);
        productos.add(producto);
        saveProductos();
        return producto;
    }

    // Actualizar un producto existente (PUT)
    public Producto update(int id, Producto producto) {
        Producto existingProducto = findById(id);
        if (existingProducto != null) {
            existingProducto.setNombre(producto.getNombre());
            existingProducto.setDescripcion(producto.getDescripcion());
            existingProducto.setPrecio(producto.getPrecio());
            saveProductos();
        }
        return existingProducto;
    }

    // Eliminar un producto por ID (DELETE)
    public boolean delete(int id) {
        Producto existingProducto = findById(id);
        if (existingProducto != null) {
            productos.remove(existingProducto);
            saveProductos();
            return true;
        }
        return false;
    }

    // Guardar la lista de productos en el archivo JSON
    private void saveProductos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(filePath), productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
