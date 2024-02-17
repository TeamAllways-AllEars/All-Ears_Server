package allways.allEars.domain.subtitle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SubtitleResponseDto {
    private Long id;

    private String createdDate;

    private String createdTime;

    private String subtitleText;

    @Builder
    public SubtitleResponseDto(Long id, String createdDate, String createdTime, String subtitleText){
        this.id = id;
        this.createdDate = createdDate;
        this.createdTime = createdTime;
        this.subtitleText = subtitleText;
    }
}
