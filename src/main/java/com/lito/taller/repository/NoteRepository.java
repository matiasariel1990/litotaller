package com.lito.taller.repository;

import com.lito.taller.dto.Note.NoteContentDTO;
import com.lito.taller.entity.Client;
import com.lito.taller.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {


    @Query(value = "select n.id, n.content, n.date from note n where n.client_id = :id", nativeQuery = true)
    Set<NoteContentDTO> findByClientId(long id);

}
