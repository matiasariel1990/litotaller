package com.lito.taller.dto.Note;

import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import com.lito.taller.entity.Vehicle;
import com.lito.taller.entity.Work;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


public interface NoteContentDTO {
    long getId();
    Date getDate();
    String getContent();

    
}
