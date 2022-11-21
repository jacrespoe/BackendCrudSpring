package com.example.database;

import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;



@RestController
@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT} )

@RequestMapping("/api/")
public class Rest {
    @Autowired
    private ServiceProducto serviceProducto;
        private Repository repository;



      @GetMapping("/productos")
    private ResponseEntity<Object> getAllProductos(){
        
           // final Properties properties = gson.fromJson(serviceProducto.findAll(), Properties.class);

           Map<String, Object> map = new HashMap<String, Object>();
            map.put("code", 200);
            map.put("status", "OK");
            map.put("data", (serviceProducto.findAll()));
           
           
        //return ResponseEntity.ok((serviceProducto.findAll()));
                    return new ResponseEntity<Object>(map,HttpStatus.OK);

        
    }
    @PostMapping("/productos")
    private ResponseEntity<Model> saveProducto(@RequestBody Model model){
        try {
            Model ProductoGuardado = serviceProducto.save(model);
            return  ResponseEntity.created(new URI("/producto/"+ProductoGuardado.getId())).body(ProductoGuardado);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
     @GetMapping("/productos/{id}")
    public ResponseEntity<Model> getProductoById(@PathVariable("id") String id) {
    Optional<Model> Producto = serviceProducto.findById(Long.valueOf(id));

    if (Producto.isPresent()) {
      return new ResponseEntity<>(Producto.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  @PutMapping("/productos/{id}")
  public ResponseEntity<Model> updateProducto(@PathVariable("id") String id, @RequestBody Model producto) {
    Optional<Model> ProductoData = serviceProducto.findById(Long.valueOf(id));

    if (ProductoData.isPresent()) {
      Model _producto = ProductoData.get();
      _producto.setId(producto.getId());
      _producto.setName(producto.getName());
      _producto.setdescription(producto.getdescription());
      _producto.setimage(producto.getimage());
      _producto.setprice(producto.getprice());
      
      
      
      return new ResponseEntity<>(serviceProducto.save(_producto), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/productos/{id}")
  public ResponseEntity<Object> deleteTutorial(@PathVariable("id") String id) {
    try {
      serviceProducto.deleteById(Long.valueOf(id));
      
       Map<String, Object> map = new HashMap<String, Object>();
            map.put("Resultado", "Registro Eliminado");
            return new ResponseEntity<Object>(map,HttpStatus.OK);
      
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

   

}
