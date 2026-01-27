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
@Table(name = "thutuc1_traloi")
public class ThuTuc1_TraLoi extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maSoHoSo;
    private String ketQua;
    private String lyDo;
    private String tenNguoiXuLy;
    private String bucketName;
    private String vanBan;
    private List<String> taiLieuDinhKem;
}
