package antoniogiovanni.marchese.U5W2L5.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record NewUtenteDTO(
        @NotEmpty
        @NotNull
        String username,
        @NotEmpty
        @NotNull
        String nome,
        @NotEmpty
        @NotNull
        String cognome,
        @NotEmpty
        @NotNull
        @Email
        String email) {
}
