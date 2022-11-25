package com.dailycodebuffer.user.VO;

import com.dailycodebuffer.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseTemplateVO {

    private User user;
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
