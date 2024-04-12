package ecomerce.shopping.resource;

import ecomerce.shopping.interfaces.IResource;
import ecomerce.shopping.model.Pessoa;
import ecomerce.shopping.service.ContatoService;
import ecomerce.shopping.service.PessoaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaResource implements IResource<Pessoa, Integer> {

    @Autowired
    PessoaService pessoaService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa create(@Valid @RequestBody Pessoa entity) {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());
        return pessoaService.create(entity);
    }

    @Override
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());

        return pessoaService.read(id);
    }

    @Override
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Pessoa> readALL() {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());

        return pessoaService.readALL();
    }

    @Override
    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa updatePart(@PathVariable Integer id,@Valid @RequestBody Pessoa entity) {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());

        return pessoaService.updatePart(id, entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Pessoa updateall(@PathVariable Integer id,@Valid @RequestBody Pessoa entity) {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());

        return pessoaService.updateall(id, entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                PessoaService.class.getCanonicalName(),
                PessoaService.class.getEnclosingMethod().getName());

        pessoaService.delete(id);
    }
}
