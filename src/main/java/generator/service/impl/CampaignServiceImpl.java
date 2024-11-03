package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.userbackend.model.domain.Campaign;
import generator.service.CampaignService;
import generator.mapper.CampaignMapper;
import org.springframework.stereotype.Service;

/**
* @author jklanling
* @description 针对表【campaign】的数据库操作Service实现
* @createDate 2024-11-03 17:39:30
*/
@Service
public class CampaignServiceImpl extends ServiceImpl<CampaignMapper, Campaign>
    implements CampaignService{

}




