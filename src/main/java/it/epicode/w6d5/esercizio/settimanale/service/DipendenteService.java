package it.epicode.w6d5.esercizio.settimanale.service;

import it.epicode.w6d5.esercizio.settimanale.exception.NotFoundException;
import it.epicode.w6d5.esercizio.settimanale.model.Dipendente;
import it.epicode.w6d5.esercizio.settimanale.repository.DipendenteRepository;
import it.epicode.w6d5.esercizio.settimanale.request.DipendenteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Page<Dipendente> findAllDipendenti(Pageable pageable){

        return dipendenteRepository.findAll(pageable);
    }

    public Dipendente findDipendenteById(int id) throws NotFoundException {
        return dipendenteRepository.findById(id).orElseThrow(()->new NotFoundException("Dipendente con id= " + id + " non trovato"));
    }

    public Dipendente saveDipendente(DipendenteRequest dipendenteRequest){
        Dipendente a = new Dipendente();
        a.setNome(dipendenteRequest.getNome());
        a.setCognome(dipendenteRequest.getCognome());
        a.setEmail(dipendenteRequest.getEmail());
        a.setUsername(dipendenteRequest.getUsername());


        return dipendenteRepository.save(a);
    }

    public Dipendente updateDipendente(int id, DipendenteRequest dipendenteRequest) throws NotFoundException{
        Dipendente a = new Dipendente();
        a.setNome(dipendenteRequest.getNome());
        a.setCognome(dipendenteRequest.getCognome());
        a.setEmail(dipendenteRequest.getEmail());
        a.setUsername(dipendenteRequest.getUsername());


        return dipendenteRepository.save(a);
    }

    public void deleteDipendente(int id) throws NotFoundException{
        Dipendente a = findDipendenteById(id);
        dipendenteRepository.delete(a);
    }

    public Dipendente uploadLogo(int id, String url) throws NotFoundException{
        Dipendente a = findDipendenteById(id);
        a.setLogo(url);
        return dipendenteRepository.save(a);
    }


}
