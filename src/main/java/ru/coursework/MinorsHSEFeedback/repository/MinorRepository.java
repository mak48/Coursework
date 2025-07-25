package ru.coursework.MinorsHSEFeedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.coursework.MinorsHSEFeedback.db.Minor;
import ru.coursework.MinorsHSEFeedback.db.MinorTitleInfo;

import java.util.List;
import java.util.Set;

public interface MinorRepository extends JpaRepository<Minor, Long> {

    @Query("SELECT m FROM Minor m WHERE m.categoryId IN :categoryIds")
    List<Minor> findAllByCategoryIds(@Param("categoryIds") Set<Long> categoryIds);

    @Query("SELECT m.id FROM Minor m WHERE m.title = :title")
    Long findByTitle(@Param("title") String title);

    @Query("SELECT NEW ru.coursework.MinorsHSEFeedback.db.MinorTitleInfo(m.id, m.title) FROM Minor m")
    List<MinorTitleInfo> getAllMinorTitles();
}
