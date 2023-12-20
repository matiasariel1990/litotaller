package com.lito.taller.dto;

import com.lito.taller.entity.Client;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    long id;
    Date date;
    String content;
    Client client;
    Vehicle Vehicle;
    Work work;
}
