package com.vn2bs.nsw_gateway.mapper.ThuTuc1;

import org.mapstruct.Mapper;

import com.vn2bs.common.domains.ThuTuc1.ThuTuc1_TraLoi;
import com.vn2bs.common.dto.ThuTuc1.TraLoiDto;

@Mapper(componentModel = "spring")
public interface TraLoiMapper {
    TraLoiDto toDto(ThuTuc1_TraLoi entity);

    ThuTuc1_TraLoi toEntity(TraLoiDto dto);
}
