package info.xiaomo.website.model.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import info.xiaomo.core.filter.CustomDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 把今天最好的表现当作明天最新的起点．．～
 * いま 最高の表現 として 明日最新の始発．．～
 * Today the best performance  as tomorrow newest starter!
 * Created by IntelliJ IDEA.
 *
 * @author: xiaomo
 * @github: https://github.com/qq83387856
 * @email: hupengbest@163.com
 * @QQ_NO: 83387856
 * @Date: 2016/4/1 20:37
 * @Copyright(©) 2015 by xiaomo.
 **/

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Version
    @Column(name = "Version")
    private long version;

    @JsonSerialize(using = CustomDateSerializer.class)
    @Column(name = "CreateTime")
    private Date createTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    @Column(name = "UpdateTime")
    private Date updateTime;

    @Column(name = "Position")
    private int position = 1;
}
