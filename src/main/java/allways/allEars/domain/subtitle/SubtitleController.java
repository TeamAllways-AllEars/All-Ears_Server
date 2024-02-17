package allways.allEars.domain.subtitle;

import allways.allEars.domain.subtitle.dto.request.SubtitleCreateRequestDto;
import allways.allEars.domain.subtitle.dto.response.SubtitleListResponseDto;
import allways.allEars.domain.subtitle.dto.response.SubtitleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/subtitle")
public class SubtitleController {
    private final SubtitleService subtitleService;
    @PutMapping("")
    public ResponseEntity<?> createSubtitle(@RequestParam String identity,
                                           @RequestBody SubtitleCreateRequestDto subtitleCreateRequestDto){

        subtitleService.createNewSubtitle(identity, subtitleCreateRequestDto);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("")
    public ResponseEntity<SubtitleListResponseDto> getAllSubtitle(@RequestParam String identity){

        SubtitleListResponseDto subtitleListResponseDto = subtitleService.getAllSubtitle(identity);
        return new ResponseEntity<>(subtitleListResponseDto, HttpStatusCode.valueOf(200));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubtitleResponseDto> getOneSubtitle(@RequestParam String identity,
                                           @PathVariable Long id){

        SubtitleResponseDto subtitleResponseDto = subtitleService.getOneSubtitle(identity, id);
        return new ResponseEntity<>(subtitleResponseDto, HttpStatusCode.valueOf(200));
    }

}
