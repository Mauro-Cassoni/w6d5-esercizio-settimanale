package it.epicode.w6d5.esercizio.settimanale.request;

import it.epicode.w6d5.esercizio.settimanale.enums.Disponibilita;
import it.epicode.w6d5.esercizio.settimanale.enums.Tipologia;
import it.epicode.w6d5.esercizio.settimanale.model.Dipendente;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DispositivoRequest {

    @NotNull(message = "disponibilita obblogatoria")
    @NotEmpty(message = "disponibilita obblogatoria")
    private Disponibilita disponibilita;

    @NotNull(message = "disponibilita obblogatoria")
    @NotEmpty(message = "disponibilita obblogatoria")
    private Tipologia tipologia;

    private Dipendente dipendente;

}
