package com.example.m2_Testing_David_Sans_Rest_Methodes.controladores;


import com.example.m2_Testing_David_Sans_Rest_Methodes.entities.Perro;
import com.example.m2_Testing_David_Sans_Rest_Methodes.repositories.PerroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PerroController {

    PerroRepository repository;

    public PerroController(PerroRepository repository) {
        this.repository = repository;
    }

    //Datos de prueba

    @GetMapping("/data")
    public void demoData() {
        Perro pincher = new Perro(null, "XS001", "Demo1", "pincher", "macho", 1.5, false, 0);
        Perro american = new Perro(null, "XL001", "Demo2", "American Stanfordincher", "Hembra", 25.5, true, 2);
        repository.save(pincher);
        repository.save(american);
    }

    // Get Recuperar

    @GetMapping("/perros")
    public List<Perro> findAll() {
        return repository.findAll();
    }

    //Get by Id

    @GetMapping("/perros/{id}")
    public Perro findById(@PathVariable long id) {
        Optional<Perro> perroOptional = repository.findById(id);
        if (perroOptional.isPresent())
            return perroOptional.get();
        else
            return null;
    }

    // Get by name
    @GetMapping("/perros/nombre/{name}")
    public List<Perro> findByNameIgnoreCase(@PathVariable String name) {
        return repository.findByNameIgnoreCase(name);
    }

    // Get by Chip
    @GetMapping("/perros/chip/{chip}")
    public List<Perro> findByChipIgnoreCase(@PathVariable String chip) {
        return repository.findByChipIgnoreCase(chip);
    }

    // Get by Raza
    @GetMapping("/perros/raza/{raza}")
    public List<Perro> findByRazaIgnoreCase(@PathVariable String raza) {
        return repository.findByRazaIgnoreCase(raza);
    }

    // Get by sexo
    @GetMapping("/perros/sexo/{sexo}")
    public List<Perro> findBySexoIgnoreCase(@PathVariable String sexo) {
        return repository.findBySexoIgnoreCase(sexo);
    }

    // Get by peso
    @GetMapping("/perros/peso/{peso}")
    public List<Perro> findByPesoLessThan(@PathVariable Double peso) {
        return repository.findByPesoLessThan(peso);
    }

    // Get by Licencia
    @GetMapping("/perros/licencia/{licencia}")
    public List<Perro> findByLicencia(@PathVariable Boolean licencia) {
        return repository.findByLicencia(licencia);
    }

    // Get by numero de adopciones
    @GetMapping("/perros/adopciones/{adopciones}")
    public List<Perro> findByAdopcionesLessThan(@PathVariable Integer adopciones) {
        return repository.findByAdopcionesLessThan(adopciones);
    }


    // Post Crear

    @PostMapping("/perros")
    public void create(@RequestBody Perro perro) {
        if (perro.getId() == null)
            repository.save(perro);
    }

    // Put actualizar / modificar
    @PutMapping("/perros")
    public void update(@RequestBody Perro perro) {
        if (perro.getId() != null && repository.existsById(perro.getId())) {
            repository.save(perro);
        }

    }

    // Delete Borrar por id
    @DeleteMapping("/perros/{id}")
    public void deleteById(@PathVariable Long id) {
        if (repository.existsById(id))
            repository.deleteById(id);

    }
    // Delete Borrar all
    @DeleteMapping("/perros")
    public void deleteAll() {
       repository.deleteAll();
    }

}







