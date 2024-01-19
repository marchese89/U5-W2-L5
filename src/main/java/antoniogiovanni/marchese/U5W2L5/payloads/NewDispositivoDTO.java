package antoniogiovanni.marchese.U5W2L5.payloads;

import antoniogiovanni.marchese.U5W2L5.enums.StatoDispositivo;
import antoniogiovanni.marchese.U5W2L5.model.Utente;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewDispositivoDTO(
        @NotNull
        @NotEmpty
        String tipologia,
        @NotNull
        @NotEmpty
        StatoDispositivo statoDispositivo) {
}
