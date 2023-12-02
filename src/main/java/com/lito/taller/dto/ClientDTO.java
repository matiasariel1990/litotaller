package com.lito.taller.dto;

import com.lito.taller.entity.Note;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    long id;
    String name;
    String tel;
    String summary;
    List<Note> notes;
    List<Vehicle> vehicles;
    List<Work> works; //confirmar que no hay que usar new (recibiria la referencia en el mapTo)
}
