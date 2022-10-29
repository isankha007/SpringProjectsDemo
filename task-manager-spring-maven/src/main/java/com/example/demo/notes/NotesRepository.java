package com.example.demo.notes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface NotesRepository extends JpaRepository<NotesEntity, Long> {

}
