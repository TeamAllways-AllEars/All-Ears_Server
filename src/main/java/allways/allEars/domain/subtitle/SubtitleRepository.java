package allways.allEars.domain.subtitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubtitleRepository extends JpaRepository<Subtitle, Long> {
    /* find all subtitles list by specific device identity*/
    List<Subtitle> findSubtitlesByDevice_Identity(String identity);

    /* find one subtitle by subtitle id */
    Subtitle findSubtitleById(Long subtitleId);
}
