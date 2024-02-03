package de.telran.l3.eg240123mbelesson331082023.domain.entity.common;

import de.telran.l3.eg240123mbelesson331082023.domain.entity.Basket;
import de.telran.l3.eg240123mbelesson331082023.domain.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonClient implements Client {

    private int id;
    private String name;
    private Basket basket;

}
