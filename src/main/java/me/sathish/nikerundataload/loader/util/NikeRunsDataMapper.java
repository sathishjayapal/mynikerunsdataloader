package me.sathish.nikerundataload.loader.util;

import me.sathish.nikerundataload.loader.jpa.NikeRunsDBData;
import me.sathish.nikerundataload.loader.jpa.NikeRunsDBDataDTO;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@Component
public class NikeRunsDataMapper {
    public NikeRunsDBDataDTO toDTO(NikeRunsDBData nikeRunsDBData) {
        NikeRunsDBDataDTO nikeRunsDBDataDTO = new NikeRunsDBDataDTO();
        nikeRunsDBDataDTO.setId(nikeRunsDBData.getId());
        nikeRunsDBDataDTO.setName(nikeRunsDBData.getName());
        nikeRunsDBDataDTO.setRun_start_time_str(Instant.
                ofEpochMilli(nikeRunsDBData.getStart_time()).
                atZone(ZoneId.systemDefault()).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        nikeRunsDBDataDTO.setRun_end_time_str(Instant.
                ofEpochMilli(nikeRunsDBData.getEnd_time()).
                atZone(ZoneId.systemDefault()).toLocalDate().toString());
        nikeRunsDBDataDTO.setRun_active_duration_str(fromMinutesToHHmm(nikeRunsDBData.getActiveDurationMS()));
        return nikeRunsDBDataDTO;
    }

    public String fromMinutesToHHmm(int minutes) {
//        long hours = TimeUnit.MINUTES.toHours(Long.valueOf(minutes));
        long remainMinutes = TimeUnit.MILLISECONDS.toMinutes(minutes);
        return String.format("%02d", remainMinutes);
    }

}
