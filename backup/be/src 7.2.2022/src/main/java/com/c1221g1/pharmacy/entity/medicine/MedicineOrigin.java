package com.c1221g1.pharmacy.entity.medicine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"medicineList"})
public class MedicineOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineOriginId;
    private String medicineOriginName;
    @JsonBackReference(value = "medicineList")
    @OneToMany(mappedBy = "medicineOrigin")
    private List<Medicine> medicineList;

    @Override
    public String toString() {
        return "MedicineOrigin{" +
                "medicineOriginId=" + medicineOriginId +
                ", medicineOriginName='" + medicineOriginName + '\'' +
                '}';
    }
}
