package com.upizz.examen_01.controllers;


import com.upizz.examen_01.models.Producto;
import com.upizz.examen_01.services.ProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")

public class ProductoController {

    ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }



    @GetMapping
    public List<Producto> getAllProducts() {
        return productoService.getAllProductos();
    }


    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public Producto createProduct(@RequestBody Producto producto) {
        return productoService.createProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto updateProduct(@PathVariable int id, @RequestBody Producto producto) {
        return productoService.updateProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProduct(@PathVariable int id) {
        return productoService.deleteProducto(id);
    }
}
