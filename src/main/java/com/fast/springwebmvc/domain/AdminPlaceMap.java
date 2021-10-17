package com.fast.springwebmvc.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminPlaceMap {
    private Long adminId;
    private Long PlaceId;

    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
}
