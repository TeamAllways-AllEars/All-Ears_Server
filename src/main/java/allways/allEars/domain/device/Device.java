package allways.allEars.domain.device;


import allways.allEars.domain.subtitle.Subtitle;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Device {
    @Id
    @Column(name = "device_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /* Identify users with unique device identity */
    @Column(unique = true)
    private String identity;

    @OneToMany(mappedBy = "device")
    private List<Subtitle> subtitles = new ArrayList<>();

    @Builder
    public Device(Long id, String identity){
        this.id = id;
        this.identity = identity;
    }

}
