package me.sathish.nikerundataload.loader.jpa;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class NikeRunsDataDTO {
    long totalElements;
    int totalPages;
    int currentPage;
    boolean isLast;
    boolean isFirst;
    boolean hasNext;
    boolean hasPrevious;
    private List<NikeRunsDBData> data;

}
