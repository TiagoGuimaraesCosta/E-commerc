package ecomerce.shopping.resource;

import ecomerce.shopping.interfaces.IResource;
import ecomerce.shopping.model.Endereco;
import ecomerce.shopping.service.ContatoService;
import ecomerce.shopping.service.EnderecoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/contato")
public class EnderecoResource implements IResource<Endereco, Integer> {

    @Autowired
    EnderecoService enderecoService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Endereco create(@Valid @RequestBody Endereco entity) {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());
        return enderecoService.create(entity);
    }

    @Override
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Endereco read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());

        return enderecoService.read(id);
    }

    @Override
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Endereco> readALL() {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());

        return enderecoService.readALL();
    }

    @Override
    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Endereco updatePart(@PathVariable Integer id,@Valid @RequestBody Endereco entity) {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());

        return enderecoService.updatePart(id, entity);
    }

    @Override
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Endereco updateall(@PathVariable Integer id,@Valid @RequestBody Endereco entity) {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());

        return enderecoService.updateall(id, entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                EnderecoService.class.getCanonicalName(),
                EnderecoService.class.getEnclosingMethod().getName());

        enderecoService.delete(id);
    }
}
