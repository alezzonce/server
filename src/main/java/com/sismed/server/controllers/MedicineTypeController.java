package com.sismed.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.UUID;
import com.sismed.server.entities.MedicineTypeEntity;
import com.sismed.server.services.MedicineTypeService;
import com.sismed.server.utils.Pagination;

/* Controlador de medicineType */

@RestController
@RequestMapping("/medicineType")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MedicineTypeController {
    @Autowired private MedicineTypeService medicineTypeService;
    
    @GetMapping("/all")
    public ResponseEntity<Pagination<MedicineTypeEntity>> getAllUsers(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "5") int size){
        return new ResponseEntity<Pagination<MedicineTypeEntity>>(medicineTypeService.getAllUsers(page, size), HttpStatus.OK);
    }   //Obtener todos los registros

    @PostMapping
    public ResponseEntity<MedicineTypeEntity> createUser(@RequestBody MedicineTypeEntity userEntity){
        return new ResponseEntity<MedicineTypeEntity>(medicineTypeService.createMedicineType(userEntity), HttpStatus.CREATED);
    }  //Crear un registro
    
    @PutMapping("/{id}")
    public ResponseEntity<MedicineTypeEntity> updateUser(@PathVariable UUID id, @RequestBody MedicineTypeEntity userEntity){
        return new ResponseEntity<MedicineTypeEntity>(medicineTypeService.updateMedicineType(id, userEntity), HttpStatus.OK);
    }   //Actualizar un registro

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicineTypeEntity> deleteUser(@PathVariable UUID id){
        return new ResponseEntity<MedicineTypeEntity>(medicineTypeService.deleteById(id), HttpStatus.OK);
    } //Eliminar un registro

}
