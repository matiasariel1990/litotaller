package com.lito.taller.dto.Client;

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
}
