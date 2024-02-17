package allways.allEars.domain.subtitle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubtitleListResponseDto {
    private List<SubtitleResponseDto> subtitleResponseDtoList;
}
