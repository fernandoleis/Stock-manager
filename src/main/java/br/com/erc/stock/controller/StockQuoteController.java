package br.com.erc.stock.controller;

import br.com.erc.stock.entity.Quote;
import br.com.erc.stock.entity.Symbol;
import br.com.erc.stock.repository.SymbolRepository;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
@ApiOperation(value = "Controller for managment for Stock Quote.")
public class StockQuoteController {

    @Autowired
    private SymbolRepository symbolRepository;

    @ApiOperation(value = "Search all stock quotes.")
    @GetMapping()
    public ResponseEntity<List<Symbol>> findAll() {
        return ResponseEntity.ok(symbolRepository.findAll());
    }

    @ApiOperation(value = "Search only one stock quotes filter by ticker name.")
    @GetMapping("/{id}")
    public ResponseEntity<Symbol> findOne(@PathVariable String id) {
        Optional<Symbol> symbol = symbolRepository.findById(id.toLowerCase());
        if (symbol.isPresent()) {
            return ResponseEntity.ok(new Symbol(symbol.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value = "Save stock quote.")
    @PostMapping()
    @Transactional
    public ResponseEntity<Symbol> create(@RequestBody String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        Symbol ticker = new Symbol(jsonObject.get("id").toString().toLowerCase());
        HashMap<String, Object> map = new Gson().fromJson(jsonObject.get("quotes").toString(), HashMap.class);
        List<Quote> quotes = new ArrayList<>();
        map.forEach((k, v) -> quotes.add(new Quote(ticker, k, Integer.parseInt(String.valueOf(v)))));
        Symbol symbol = new Symbol(ticker.getId(), quotes);
        Symbol createdSymbol = symbolRepository.save(symbol);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdSymbol.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdSymbol);
    }

    @ApiOperation(value = "Delete stock quote.")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id) {
        symbolRepository.deleteById(id.toLowerCase());
    }
}
