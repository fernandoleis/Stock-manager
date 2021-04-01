package br.com.erc.stock.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
public class Symbol implements Serializable {
    private static final long serialVersionUID = 8086754301294240298L;
    @Id
    @Column(unique=true)
    private String id;

    @OneToMany(mappedBy = "symbol", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Quote> quotes;

    public Symbol() {
    }

    public Symbol(String id) {
        this.id = id;
    }

    public Symbol(Symbol symbol) {
        super();
        this.id = symbol.getId();
        this.quotes = symbol.getQuotes();
    }

}
