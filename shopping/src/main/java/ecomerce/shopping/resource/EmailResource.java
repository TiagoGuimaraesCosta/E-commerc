package ecomerce.shopping.resource;

import ecomerce.shopping.interfaces.IResource;
import ecomerce.shopping.model.Email;
import ecomerce.shopping.service.EmailService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/email")
public class EmailResource implements IResource<Email,Integer> {

   @Autowired
    EmailService emailService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Email create(@Valid @RequestBody Email entity) {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());
        return emailService.create(entity);
    }

    @Override
    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Email read(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());

        return emailService.read(id);
    }

    @Override
    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public List<Email> readALL() {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());

        return emailService.readALL();
    }

    @Override
    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Email updatePart(@PathVariable Integer id,@Valid @RequestBody Email entity) {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());

        return emailService.updatePart(id, entity);
    }

    @Override
    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Email updateall(@PathVariable Integer id,@Valid @RequestBody Email entity) {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());

        return emailService.updatePart(id, entity);
    }

    @Override
    @DeleteMapping(
            value = "/{id}"
    )
    public void delete(@PathVariable Integer id) {
        log.info("Resource: {}, método: {}",
                EmailService.class.getCanonicalName(),
                EmailService.class.getEnclosingMethod().getName());

        emailService.delete(id);
    }
}
