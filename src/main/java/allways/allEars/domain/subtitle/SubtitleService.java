package allways.allEars.domain.subtitle;


import allways.allEars.domain.device.Device;
import allways.allEars.domain.device.DeviceRepository;
import allways.allEars.domain.subtitle.dto.request.SubtitleCreateRequestDto;
import allways.allEars.domain.subtitle.dto.response.SubtitleListResponseDto;
import allways.allEars.domain.subtitle.dto.response.SubtitleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional
public class SubtitleService {
    private final SubtitleRepository subtitleRepository;
    private final DeviceRepository deviceRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    /* Save device to DB if not exists */
    public void findDeviceData(String identity){
        Device device = deviceRepository.findDeviceByIdentity(identity);
        if (device == null) {
            Device newDevice = Device.builder()
                    //.identity(bCryptPasswordEncoder.encode(identity))
                    .identity(identity)
                    .build();
            deviceRepository.save(newDevice);
        }
    }

    public void createNewSubtitle(String identity, SubtitleCreateRequestDto subtitleCreateRequestDto){
        findDeviceData(identity);

        Device device = deviceRepository.findDeviceByIdentity(identity);

        Subtitle newSubtitle = Subtitle.builder()
                .createdDate(LocalDateTime.now())
                .subtitleText(subtitleCreateRequestDto.getSubtitleText())
                .device(device)
                .build();

        //save new subtitle to DB
        subtitleRepository.save(newSubtitle);
    }

    public SubtitleListResponseDto getAllSubtitle(String identity){
        findDeviceData(identity);

        List<Subtitle> subtitleList = subtitleRepository.findSubtitlesByDevice_Identity(identity);

        List<SubtitleResponseDto> subtitleResponseDtos = subtitleList.stream()
                .map(subtitle -> SubtitleResponseDto.builder()
                        .id(subtitle.getId())
                        //Parse the date and time
                        .createdDate(subtitle.getCreatedDate().format(DateTimeFormatter.ofPattern("MMM dd, yyyy, E").withLocale(Locale.forLanguageTag("en"))))
                        .createdTime(subtitle.getCreatedDate().format(DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.forLanguageTag("en"))))
                        .subtitleText(subtitle.getSubtitleText())
                        .build())
                // sort subtitles by latest
                .sorted(Comparator.comparing(SubtitleResponseDto::getCreatedDate).reversed())
                .toList();

        //return all subtitles of specific device(user)
        return new SubtitleListResponseDto(subtitleResponseDtos);
    }

    public SubtitleResponseDto getOneSubtitle(String identity, Long subtitleId){
        findDeviceData(identity);

        Subtitle subtitle = subtitleRepository.findSubtitleById(subtitleId);

        SubtitleResponseDto subtitleResponseDto = SubtitleResponseDto.builder()
                .id(subtitle.getId())
                //Parse the date and time
                .createdDate(subtitle.getCreatedDate().format(DateTimeFormatter.ofPattern("MMM dd, yyyy, E").withLocale(Locale.forLanguageTag("en"))))
                .createdTime(subtitle.getCreatedDate().format(DateTimeFormatter.ofPattern("hh:mm a").withLocale(Locale.forLanguageTag("en"))))
                .subtitleText(subtitle.getSubtitleText())
                .build();

        //return one subtitle of specific device(user)
        return subtitleResponseDto;
    }

}
