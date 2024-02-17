package allways.allEars.domain.subtitle;

import allways.allEars.domain.device.Device;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Subtitle {
    @Id
    @Column(name = "subtitle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdDate;

    private String subtitleText;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    @Builder
    public Subtitle(Long id, LocalDateTime createdDate, String subtitleText, Device device) {
        this.id = id;
        this.createdDate = createdDate;
        this.subtitleText = subtitleText;
        this.device = device;
    }
}
