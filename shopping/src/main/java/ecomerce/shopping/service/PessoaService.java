package ecomerce.shopping.service;

import ecomerce.shopping.interfaces.IService;
import ecomerce.shopping.model.Endereco;
import ecomerce.shopping.model.Pessoa;
import ecomerce.shopping.repository.PessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class PessoaService implements IService<Pessoa, Integer> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional(rollbackFor = Error.class)
    @Override
    public Pessoa create(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    @Override
    public Pessoa read(Integer id) {
        return pessoaRepository.getReferenceById(id);
    }

    @Override
    public List<Pessoa> readALL() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa updatePart(Integer id, Pessoa entity) {

        Pessoa pessoaEncontrado = this.read(id);

        if(pessoaEncontrado!=null){
            entity.setId(pessoaEncontrado.getId());

            return pessoaRepository.save(entity);
        }

        return new Pessoa();
    }

    @Override
    public Pessoa updateall(Integer id, Pessoa entity) {

        Pessoa pessoaEncontrado = this.read(id);

        if(pessoaEncontrado!=null){
            entity.setId(pessoaEncontrado.getId());

            return pessoaRepository.save(entity);
        }

        return new Pessoa();
    }

    @Override
    public void delete(Integer id) {
        pessoaRepository.deleteById(id);
    }
}
