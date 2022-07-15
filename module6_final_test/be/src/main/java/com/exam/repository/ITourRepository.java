package com.exam.repository;

import com.exam.dto.ThongKe;
import com.exam.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ITourRepository extends JpaRepository<Tour, Integer> {

    @Query(value = "select t.ma_thanh_vien maThanhVien, count(ma_dang_ki) soLanDangKi\n" +
            "from thanh_vien t inner join dang_ki dk on t.ma_thanh_vien = dk.thanh_vien\n" +
            "group by t.ma_thanh_vien order by soLanDangKi Desc", nativeQuery = true)
    List<ThongKe> getThongKe();
}
