package it.epicode.w6d5.esercizio.settimanale.controller;

import com.cloudinary.Cloudinary;
import it.epicode.w6d5.esercizio.settimanale.exception.CustomResponse;
import it.epicode.w6d5.esercizio.settimanale.exception.NotFoundException;
import it.epicode.w6d5.esercizio.settimanale.model.Dipendente;
import it.epicode.w6d5.esercizio.settimanale.model.Dispositivo;
import it.epicode.w6d5.esercizio.settimanale.request.DipendenteRequest;
import it.epicode.w6d5.esercizio.settimanale.request.DispositivoRequest;
import it.epicode.w6d5.esercizio.settimanale.service.DipendenteService;
import it.epicode.w6d5.esercizio.settimanale.service.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {
    
    @Autowired
    private DispositivoService dispositivoService;

    @Autowired
    private DipendenteService dipendenteService;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @GetMapping("")
    public ResponseEntity<CustomResponse> getAllDispositivi(Pageable pageable) {
        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.findAllDipendenti(pageable), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getDispositivoById(@PathVariable int id){
        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.findDispositivoById(id), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<CustomResponse> saveDispositivo(@RequestBody @Validated DispositivoRequest dispositivoRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }
        try{
            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.saveDispositivo(dispositivoRequest), HttpStatus.OK);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomResponse> updateDispositivo(@PathVariable int id, @RequestBody @Validated DispositivoRequest dispositivoRequest, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return CustomResponse.error(bindingResult.getAllErrors().toString(), HttpStatus.BAD_REQUEST);
        }

        try {
            return CustomResponse.success(HttpStatus.OK.toString(), dispositivoService.updateDispositivo(id, dispositivoRequest), HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return CustomResponse.error(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteDispositivo(@PathVariable int id) {
        try{
            dispositivoService.deleteDispositivo(id);
            return CustomResponse.emptyResponse("Dispositivo con id=" + id + " cancellata", HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (Exception e){
            return CustomResponse.error(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/set")
    public ResponseEntity<CustomResponse> setDipendente(@PathVariable int id_dispositivo,@RequestParam("id_dipendente") int id_dipendente){
        try {
            Dispositivo dispositivo = dispositivoService.setDipendente(id_dispositivo, id_dipendente);
            return CustomResponse.success(HttpStatus.OK.toString(), dispositivo, HttpStatus.OK);
        }
        catch (NotFoundException e){
            return CustomResponse.error(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
