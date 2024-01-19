package antoniogiovanni.marchese.U5W2L5.service;

import antoniogiovanni.marchese.U5W2L5.exceptions.NotFoundException;
import antoniogiovanni.marchese.U5W2L5.model.Utente;
import antoniogiovanni.marchese.U5W2L5.payloads.NewUtenteDTO;
import antoniogiovanni.marchese.U5W2L5.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtenteService {
    @Autowired
    private UtenteRepository utenteRepository;

    public Page<Utente> getUsers(int page, int size, String orderBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy).descending());

        return utenteRepository.findAll(pageable);
    }

    public Utente save(NewUtenteDTO utenteDTO) {
        Utente newUtente = new Utente();
        newUtente.setNome(utenteDTO.nome());
        newUtente.setCognome(utenteDTO.cognome());
        newUtente.setUsername(utenteDTO.username());
        newUtente.setEmail(utenteDTO.email());

        return utenteRepository.save(newUtente);
    }

    public Utente findById(UUID id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(UUID id) {
        Utente found = this.findById(id);
        utenteRepository.delete(found);
    }

    public Utente findByIdAndUpdate(UUID id, Utente utente) {
        Utente found = this.findById(id);
        found.setEmail(utente.getEmail());
        found.setUsername(utente.getUsername());
        found.setNome(utente.getNome());
        found.setCognome(utente.getCognome());
        return utenteRepository.save(found);
    }
}
