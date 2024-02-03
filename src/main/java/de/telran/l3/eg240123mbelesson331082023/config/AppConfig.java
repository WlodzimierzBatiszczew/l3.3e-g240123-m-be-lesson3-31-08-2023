package de.telran.l3.eg240123mbelesson331082023.config;

import de.telran.l3.eg240123mbelesson331082023.domain.database.CommonDatabase;
import de.telran.l3.eg240123mbelesson331082023.domain.database.Database;
import de.telran.l3.eg240123mbelesson331082023.repository.ClientRepository;
import de.telran.l3.eg240123mbelesson331082023.repository.common.CommonClientRepository;
import de.telran.l3.eg240123mbelesson331082023.repository.common.CommonProductRepository;
import de.telran.l3.eg240123mbelesson331082023.repository.ProductRepository;
import de.telran.l3.eg240123mbelesson331082023.service.ClientService;
import de.telran.l3.eg240123mbelesson331082023.service.common.CommonClientService;
import de.telran.l3.eg240123mbelesson331082023.service.common.CommonProductService;
import de.telran.l3.eg240123mbelesson331082023.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Database database() {

        return new CommonDatabase();
    }

    @Bean
    public ClientService clientService() {
        return new CommonClientService();
    }

    @Bean
    public ProductService productService() {
        return new CommonProductService();
    }

    @Bean
    public ClientRepository clientRepository() {
        return new CommonClientRepository();
    }

    @Bean
    public ProductRepository productRepository() {
        return new CommonProductRepository();
    }

}
