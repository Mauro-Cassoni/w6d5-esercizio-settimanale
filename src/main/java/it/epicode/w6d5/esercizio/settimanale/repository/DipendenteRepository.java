package it.epicode.w6d5.esercizio.settimanale.repository;

import it.epicode.w6d5.esercizio.settimanale.model.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer>, PagingAndSortingRepository<Dipendente, Integer> {
}
