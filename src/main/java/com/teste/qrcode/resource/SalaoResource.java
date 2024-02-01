package com.teste.qrcode.resource;

import com.google.zxing.WriterException;
import com.teste.qrcode.domain.Salao;
import com.teste.qrcode.service.SalaoService;
import com.teste.qrcode.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/salao")
public class SalaoResource {
    private final SalaoService salaoService;

    @GetMapping
    public ResponseEntity<List<Salao>> getRestaurantes() throws IOException, WriterException {
        List<Salao> saloes = salaoService.getSalao();
        if (saloes.size() != 0){
            for (Salao salao : saloes){
                QRCodeGenerator.generateQRCode(salao);
            }
        }
        return ResponseEntity.ok(salaoService.getSalao());
    }

    @PostMapping
    public Salao addRestaurantes(@RequestBody Salao student){
        return salaoService.addSalao(student);
    }

    @GetMapping("/{id}")
    public Salao findById(@PathVariable("id") Integer id){
        return salaoService.findById(id);
    }
}
