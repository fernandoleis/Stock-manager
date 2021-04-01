package br.com.erc.stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
public class Quote implements Serializable {
    private static final long serialVersionUID = 8086754301294240299L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "symbol_id")
    private Symbol symbol;

    private String date;
    private Integer value;

    public Quote() {
    }

    public Quote(Symbol symbol, String date, Integer value) {
        this.symbol = symbol;
        this.date = date;
        this.value = value;
    }
}
