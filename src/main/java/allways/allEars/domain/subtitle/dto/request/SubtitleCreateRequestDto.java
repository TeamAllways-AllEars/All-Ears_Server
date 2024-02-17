package allways.allEars.domain.subtitle.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubtitleCreateRequestDto {
    private String subtitleText;
}
