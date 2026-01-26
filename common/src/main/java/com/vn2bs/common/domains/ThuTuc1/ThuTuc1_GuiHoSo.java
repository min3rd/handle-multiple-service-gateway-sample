package com.vn2bs.common.domains.ThuTuc1;

import java.util.List;

import com.vn2bs.common.domains.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "thutuc1_guihoso")
public class ThuTuc1_GuiHoSo extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String maSoHoSo;
    private String tenNguoiGui;
    private List<String> taiLieuDinhKem;
}
