package cn.com.dao;

import cn.com.model.ProductInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-05 16:39
 * @modified By:
 */
@Repository
@Mapper
public interface ProductInfoMapper extends BaseMapper<ProductInfo> {
}
