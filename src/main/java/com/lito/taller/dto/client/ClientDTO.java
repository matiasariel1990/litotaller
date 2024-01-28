package com.lito.taller.dto.client;


import com.lito.taller.entity.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    long id;
    String name;
    String tel;
    String summary;

    public ClientDTO(Client client){
        this.id =  client.getId();
        this.name = client.getName();
        this.tel = client.getTel();
        this.summary = client.getSummary();

    }

    public Client mapToEntity(){
        Client client = new Client();
        client.setId(this.id);
        client.setName(this.name);
        client.setTel(this.tel);
        client.setSummary(this.summary);
        return client;
    }

}
