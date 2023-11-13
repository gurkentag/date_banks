package db_project.db_project.repositories;


import db_project.db_project.entities.Cds_tracks;
import db_project.db_project.idsClasses.CdsTracksId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Cds_tracksRep extends JpaRepository<Cds_tracks, CdsTracksId> {
}
