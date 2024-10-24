package pe.ciberted.edu.stockify.stockify.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import pe.ciberted.edu.stockify.stockify.entity.Provedor;


@RestController
@RequestMapping("/provedor")
public class ProvedorController {

	
private String URL = "http://localhost:8080/";
	
	@GetMapping("/lista")
    public ResponseEntity<?> obtenerLista() {
        RestTemplate rt = new RestTemplate();
        
        // Acceder a la ruta
        ResponseEntity<Provedor[]> data = rt.getForEntity(URL + "provedor/lista", Provedor[].class);

        // Devolver los datos
        return ResponseEntity.ok(data.getBody());
    }
}
