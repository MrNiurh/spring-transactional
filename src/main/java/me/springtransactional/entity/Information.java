package me.springtransactional.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/4/18
 * @Description
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
@Data
@NoArgsConstructor
public class Information {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 信息
     */
    private String info;

    public Information(String info) {
        this.info = info;
    }
}

