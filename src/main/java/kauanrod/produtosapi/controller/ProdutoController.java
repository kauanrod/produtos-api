package kauanrod.produtosapi.controller;

import kauanrod.produtosapi.model.Produto;
import kauanrod.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("produto recebido: " + produto);
        var id = UUID.randomUUID();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }
}
