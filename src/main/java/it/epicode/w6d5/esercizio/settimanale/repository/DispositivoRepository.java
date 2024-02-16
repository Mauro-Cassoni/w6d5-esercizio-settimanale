package it.epicode.w6d5.esercizio.settimanale.repository;

import it.epicode.w6d5.esercizio.settimanale.model.Dipendente;
import it.epicode.w6d5.esercizio.settimanale.model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Integer>, PagingAndSortingRepository<Dispositivo, Integer> {
}
