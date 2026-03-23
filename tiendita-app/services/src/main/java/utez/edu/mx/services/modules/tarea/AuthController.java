package utez.edu.mx.services.modules.tarea;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/code-api/auth")
public class AuthController {

    @GetMapping("/findAll")
    public void findAll() {}

    @GetMapping("/findById/{id}")
    public void findById(@PathVariable Long id) {}

    @PostMapping("/save")
    public void save(@RequestBody Object body) {}

    @PutMapping("/update/{id}")
    public void update(@PathVariable Long id, @RequestBody Object body) {}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {}
}