package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.model.domain.Unit;
import generator.service.UnitService;
import generator.mapper.UnitMapper;
import org.springframework.stereotype.Service;

/**
* @author jklanling
* @description 针对表【unit】的数据库操作Service实现
* @createDate 2024-11-03 17:39:30
*/
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit>
    implements UnitService{

}




