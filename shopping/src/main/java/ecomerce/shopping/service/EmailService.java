package ecomerce.shopping.service;

import ecomerce.shopping.interfaces.IService;
import ecomerce.shopping.model.Contato;
import ecomerce.shopping.model.Email;
import ecomerce.shopping.repository.EmailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class EmailService implements IService<Email, Integer> {

    @Autowired
    private EmailRepository emailRepository;

    @Transactional(rollbackFor = Error.class)
    @Override
    public Email create(Email entity) {
        return emailRepository.save(entity);
    }

    @Override
    public Email read(Integer id) {
        return emailRepository.getReferenceById(id);
    }

    @Override
    public List<Email> readALL() {
        return emailRepository.findAll();
    }

    @Override
    public Email updatePart(Integer id, Email entity) {

        Email emailEncontrado = this.read(id);

        if(emailEncontrado!=null){
            entity.setId(emailEncontrado.getId());

            return emailRepository.save(entity);
        }

        return new Email();
    }

    @Override
    public Email updateall(Integer id, Email entity) {

        Email emailEncontrado = this.read(id);

        if(emailEncontrado!=null){
            entity.setId(emailEncontrado.getId());

            return emailRepository.save(entity);
        }

        return new Email();
    }

    @Override
    public void delete(Integer id) {

        emailRepository.deleteById(id);
    }
}
