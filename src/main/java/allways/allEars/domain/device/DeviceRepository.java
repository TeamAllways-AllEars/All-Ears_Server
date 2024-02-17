package allways.allEars.domain.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    /* find all subtitles list by specific device identity */
    Device findDeviceByIdentity(String identity);

    /* find one device by device id */
    Device findDeviceById(Long deviceId);
}
