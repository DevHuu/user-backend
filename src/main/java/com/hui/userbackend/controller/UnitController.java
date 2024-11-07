package com.hui.userbackend.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.userbackend.model.domain.Unit;
import com.hui.userbackend.model.domain.request.SearchRequest;
import com.hui.userbackend.service.UnitService;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author liujh
 * @date 2024/11/4
 */
@RestController
@RequestMapping("/api/unit")
public class UnitController {

    @Resource
    private UnitService unitService;

    @PostMapping("/search")
    public List<Unit> search(@RequestBody SearchRequest param) {
        QueryWrapper<Unit> queryWrapper = new QueryWrapper<>();
        String unitName = param.getUnitName();
        if (StringUtils.isNotBlank(unitName)) {
            queryWrapper.like("unit_name", unitName);
        }
        return unitService.list(queryWrapper);
    }

    @GetMapping("/searchPage")
    public Page<Unit> searchPage(@RequestBody SearchRequest param) {
        QueryWrapper<Unit> queryWrapper = new QueryWrapper<>();
        String unitName = param.getUnitName();
        if (StringUtils.isNotBlank(unitName)) {
            queryWrapper.like("unitName", unitName);
        }
        return unitService.page(new Page<>(1, 2), queryWrapper);
    }

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public boolean uploadFile(@RequestPart("file") MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Unit.class, new PageReadListener<Unit>(dataList -> {
            unitService.saveBatch(dataList);
        })).sheet().doRead();
        return true;
    }

    /**
     * 文件下载
     */
    @GetMapping("/download")
    public void downloadFile(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String name = "创建单元模板";
        String fileName = URLEncoder.encode(name, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        Unit unitDemo = getUnitDemo();
        EasyExcel.write(response.getOutputStream(), Unit.class)
                .registerWriteHandler(new SimpleColumnWidthStyleStrategy(20))
                .sheet(name)
                .doWrite(Collections.singletonList(unitDemo));
    }

    /**
     * 删除计划
     */
    @PostMapping("/delete")
    public boolean delete(@RequestBody List<String> ids) throws IOException {
        return unitService.removeByIds(ids);
    }

    /**
     * 创建计划
     */
    @PostMapping("/create")
    public boolean create(@RequestBody List<String> ids) throws IOException {
        QueryWrapper<Unit> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("unit_id");
        queryWrapper.in("id", ids);
        List<Unit> unitList = unitService.list(queryWrapper);
        for (Unit unit : unitList) {
            unitService.create(unit.getId().toString());
        }
        return true;
    }

    private Unit getUnitDemo() {
        Unit unit = new Unit();
        unit.setAdvertiserId(0L);
        unit.setCampaignId(0L);
        unit.setUnitName("xxx单元");
        unit.setEventBid(0);
        unit.setNoteIds("xxx,xxx,xxx");
        unit.setPromotionTarget(0);
        unit.setTargetType(0);
        unit.setKeywordTargetPeriod(0);
        unit.setKeywordTargetAction("1,2,3");
        unit.setBusinessTreeName("xxx");
        unit.setSubstitutedUserId("abc");
        unit.setKeywordGenType(0);
        unit.setPageId("123");
        unit.setLandingPageUrl("http://xxx.com");
        unit.setUnitExternalPageUrl("http://xxx.com");
        unit.setUnitLandingPageDesc("xxx,xxx,xxx");
        unit.setTargetTemplateId(0L);
        unit.setTargetGender("all");
        unit.setTargetAge("all");
        unit.setTargetCity("all");
        unit.setTargetDevice("all");
        unit.setIndustryInterestTarget("");
        unit.setCrowdTarget("");
        unit.setInterestKeywords("xxx,xxx,xxx");
        unit.setKeywords("xxx,xxx,xxx");
        unit.setIntelligentExpansion(0);
        unit.setSearchTargetCityIntent("0");
        unit.setSpuNoteInfo("123:abc,bcd;234:cde,def");
        unit.setKeywordWithBid("");

        return unit;
    }
}
