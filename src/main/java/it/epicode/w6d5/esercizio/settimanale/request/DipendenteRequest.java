package it.epicode.w6d5.esercizio.settimanale.request;

import it.epicode.w6d5.esercizio.settimanale.model.Dispositivo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class DipendenteRequest {

    @NotNull(message = "username obbligatorio")
    @NotEmpty(message = "username obbligatorio")
    @NotBlank
    private String username;

    @NotNull(message = "nome obbligatorio")
    @NotEmpty(message = "nome obbligatorio")
    @NotBlank
    private String nome;

    @NotNull(message = "cognome obbligatorio")
    @NotEmpty(message = "cognome obbligatorio")
    @NotBlank
    private String cognome;

    @NotEmpty(message = "mail obbligatoria")
    @Email
    private String email;

}
