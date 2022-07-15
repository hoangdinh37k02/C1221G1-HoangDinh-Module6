package com.c1221g1.pharmacy.dto.employee;

import com.c1221g1.pharmacy.entity.employee.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public class Position {
    @NotNull(message = "Position may not be null")
    private Integer positionId;
    private String positionName;

    public Position() {
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }


}