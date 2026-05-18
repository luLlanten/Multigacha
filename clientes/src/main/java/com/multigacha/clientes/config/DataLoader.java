package com.multigacha.clientes.config;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.multigacha.clientes.model.Cliente;
import com.multigacha.clientes.repo.ClienteRepo;

@Configuration
public class DataLoader {
    @Bean
    CommandLineRunner initClienteDataBase(ClienteRepo repo){
        return args ->{
            if(repo.count()==0){
                Cliente c1 = repo.save(new Cliente(null,"20213131-4","Pepe","Tapia",new Date(2000,11,21),1));
                Cliente c2 = repo.save(new Cliente(null,"45678944-9","Roberto","M",new Date(2001,10,1),2));
                Cliente c3 = repo.save(new Cliente(null,"12345646-4","Jaime","Gonzalez",new Date(2004,8,11),3));
            }
        };
    }

}
