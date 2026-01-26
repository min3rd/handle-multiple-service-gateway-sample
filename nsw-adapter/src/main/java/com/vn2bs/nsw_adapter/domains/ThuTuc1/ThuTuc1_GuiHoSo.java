package com.vn2bs.nsw_adapter.domains.ThuTuc1;

import java.util.List;

import com.vn2bs.nsw_adapter.domains.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "thutuc1_guihoso")
public class ThuTuc1_GuiHoSo extends BaseEntity<Long> {
    private String maSoHoSo;
    private String tenNguoiGui;
    private List<String> taiLieuDinhKem;
}
