package me.sathish.nikerundataload.loader.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NikeRunsDBDataDTO {
    private Long id;
    private String name;
    private String run_start_time_str;
    private String run_end_time_str;
    private String run_active_duration_str;
}
