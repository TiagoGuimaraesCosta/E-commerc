package ecomerce.shopping.service;

import ecomerce.shopping.interfaces.IService;
import ecomerce.shopping.model.Pessoa;
import ecomerce.shopping.model.Telefone;
import ecomerce.shopping.repository.TelefoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TelefoneService implements IService<Telefone, Integer> {

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Override
    public Telefone create(Telefone entity) {
        return telefoneRepository.save(entity);
    }

    @Override
    public Telefone read(Integer id) {
        return telefoneRepository.getReferenceById(id);
    }

    @Override
    public List<Telefone> readALL() {
        return telefoneRepository.findAll();
    }

    @Override
    public Telefone updatePart(Integer id, Telefone entity) {

        Telefone telefoneEncontrado = this.read(id);

        if(telefoneEncontrado!=null){
            entity.setId(telefoneEncontrado.getId());

            return telefoneRepository.save(entity);
        }

        return new Telefone();
    }

    @Override
    public Telefone updateall(Integer id, Telefone entity) {

        Telefone telefoneEncontrado = this.read(id);

        if(telefoneEncontrado!=null){
            entity.setId(telefoneEncontrado.getId());

            return telefoneRepository.save(entity);
        }

        return new Telefone();
    }

    @Override
    public void delete(Integer id) {
        telefoneRepository.deleteById(id);
    }
}
