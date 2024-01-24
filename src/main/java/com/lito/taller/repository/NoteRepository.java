package com.lito.taller.repository;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Set;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    @Query(value = "select n.id, n.content, n.date from note n where n.client_id = :id", nativeQuery = true)
    Set<NoteContentDTO> findByClientId(long id);

    @Query(value = "select n.id, n.content, n.date from note n where n.vehicle_id = :id", nativeQuery = true)
    Set<NoteContentDTO> findByVehicleId(long id);

    @Query(value = "select n.id, n.content, n.date from note n where n.work_id = :id", nativeQuery = true)
    Set<NoteContentDTO> findByWorkId(long id);

}
