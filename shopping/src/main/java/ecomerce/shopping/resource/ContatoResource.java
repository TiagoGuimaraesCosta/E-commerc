package ecomerce.shopping.resource;

import ecomerce.shopping.interfaces.IResource;
import ecomerce.shopping.model.Contato;
import ecomerce.shopping.service.ContatoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/conteto")
public class ContatoResource implements IResource<Contato, Integer> {

    @Autowired
    ContatoService contatoService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Contato create(@Valid @RequestBody Contato entity) {
        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());
        return contatoService.create(entity);
    }

    @Override
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Contato read(@PathVariable Integer id) {

        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());

        return contatoService.read(id);
    }

    @Override
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Contato> readALL() {

        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());

        return contatoService.readALL();
    }

    @Override
    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Contato updatePart(@PathVariable Integer id, @Valid @RequestBody Contato entity) {

        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());

        return contatoService.updatePart(id, entity);
    }

    @Override
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Contato updateall(@PathVariable Integer id,@Valid @RequestBody Contato entity) {

        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());

        return contatoService.updateall(id,entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {

        log.info("Resource: {}, método: {}",
                ContatoService.class.getCanonicalName(),
                ContatoService.class.getEnclosingMethod().getName());

        contatoService.delete(id);
    }
}