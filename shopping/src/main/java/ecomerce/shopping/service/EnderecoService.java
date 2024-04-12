package ecomerce.shopping.service;

import ecomerce.shopping.interfaces.IService;
import ecomerce.shopping.model.Contato;
import ecomerce.shopping.model.Endereco;
import ecomerce.shopping.repository.EmailRepository;
import ecomerce.shopping.repository.EnderecoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class EnderecoService implements IService<Endereco, Integer> {

   @Autowired
   private EnderecoRepository enderecoRepository;

   @Transactional(rollbackFor = Error.class)
    @Override
    public Endereco create(Endereco entity) {
        return enderecoRepository.save(entity);
    }

    @Override
    public Endereco read(Integer id) {
        return enderecoRepository.getReferenceById(id);
    }

    @Override
    public List<Endereco> readALL() {
        return enderecoRepository.findAll();
    }

    @Override
    public Endereco updatePart(Integer id, Endereco entity) {

       Endereco enderecoEncontrado = this.read(id);

        if(enderecoEncontrado!=null){
            entity.setId(enderecoEncontrado.getId());

            return enderecoRepository.save(entity);
        }

        return new Endereco();
    }

    @Override
    public Endereco updateall(Integer id, Endereco entity) {
        Endereco enderecoEncontrado = this.read(id);

        if(enderecoEncontrado!=null){
            entity.setId(enderecoEncontrado.getId());

            return enderecoRepository.save(entity);
        }

        return new Endereco();
    }

    @Override
    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
