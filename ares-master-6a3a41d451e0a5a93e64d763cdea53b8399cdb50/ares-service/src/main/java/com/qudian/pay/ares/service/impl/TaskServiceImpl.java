package com.qudian.pay.ares.service.impl;

import com.qudian.pay.ares.dao.dto.TaskInfoExt;
import com.qudian.pay.ares.dao.entity.local.PageInfoPO;
import com.qudian.pay.ares.dao.entity.local.TaskInfo;
import com.qudian.pay.ares.dao.entity.local.TaskInfoExample;
import com.qudian.pay.ares.dao.enumeration.TaskStatusEnum;
import com.qudian.pay.ares.dao.mapper.local.TaskInfoMapper;
import com.qudian.pay.ares.dao.util.DateUtil;
import com.qudian.pay.ares.dao.util.ObjectUtil;
import com.qudian.pay.ares.dao.vo.TaskInfoVo;
import com.qudian.pay.ares.service.TaskService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangdelong on 17/1/13.
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Resource
    TaskInfoMapper taskInfoMapper;

    @Override
    public int count(TaskInfo record) {
        return 0;
    }

    @Override
    public int insert(TaskInfo record) {
        return taskInfoMapper.insert(record);
    }

    @Override
    public int delete(TaskInfo record) {
        return taskInfoMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public List<TaskInfo> query(TaskInfo record) {
        TaskInfoExample taskInfoExample = new TaskInfoExample();
        TaskInfoExample.Criteria cc = taskInfoExample.createCriteria();
        if (ObjectUtil.isNotEmpty(record.getTaskStatus())) {
            if (record.getTaskStatus() == Integer.valueOf(TaskStatusEnum.TASK_TMP.getCode())) {
                cc.andTaskStatusNotEqualTo(Integer.valueOf(TaskStatusEnum.TASK_INIT.getCode()));
            } else {
                cc.andTaskStatusEqualTo(record.getTaskStatus());
            }
        }
        if (ObjectUtil.isNotEmpty(record.getTaskName())) {
            cc.andTaskNameEqualTo(record.getTaskName());
        }
        if (ObjectUtil.isNotEmpty(record.getRepairDate())) {
            cc.andRepairDateEqualTo(record.getRepairDate());
        }
        if (ObjectUtil.isNotEmpty(record.getTaskType())) {
            cc.andTaskTypeEqualTo(record.getTaskType());
        }
        return taskInfoMapper.selectByExample(taskInfoExample);
    }

    @Override
    public int update(TaskInfo record) {
        return taskInfoMapper.updateByPrimaryKeySelective(record);

    }

    @Override
    public PageInfoPO<TaskInfo> queryByPage(TaskInfo record, int startLimit, int endLimit) throws Exception {
        TaskInfoExample example = new TaskInfoExample();
        TaskInfoExample.Criteria cc = example.createCriteria();
        if (ObjectUtil.isNotEmpty(record.getTaskStatus())) {
            cc.andTaskStatusEqualTo(record.getTaskStatus());
        }

        if (ObjectUtil.isNotEmpty(record.getBeginCreateDate()) && ObjectUtil.isNotEmpty(record.getEndCreateDate())) {
            Date beginDate = DateUtil.stringDateToDate2(record.getBeginCreateDate());
            Date endDate = DateUtil.stringDateToDate2(record.getEndCreateDate());
            cc.andCreateTimeGreaterThanOrEqualTo(beginDate);
            cc.andCreateTimeLessThanOrEqualTo(endDate);
        }

        if (ObjectUtil.isNotEmpty(record.getBeginRepairDate()) && ObjectUtil.isNotEmpty(record.getEndRepairDate())) {
            Date beginDate = DateUtil.stringDateToDate2(record.getBeginRepairDate());
            Date endDate = DateUtil.stringDateToDate2(record.getEndRepairDate());
            cc.andRepairDateGreaterThanOrEqualTo(beginDate);
            cc.andRepairDateLessThanOrEqualTo(endDate);
        }

        if (ObjectUtil.isNotEmpty(record.getTaskName())) {
            cc.andTaskNameEqualTo(record.getTaskName());
        }

        example.setPageNum(startLimit, endLimit);
        example.setOrderByClause("id desc");
        PageInfoPO<TaskInfo> res = new PageInfoPO<TaskInfo>();
        res.setResults(taskInfoMapper.selectByExampleByPage(example));
        res.setCount(taskInfoMapper.countByExample(example));
        res.setPageNum(startLimit);
        res.setPageSize(endLimit);
        for (int i = 0; i < res.getResults().size(); i++) {
            res.getResults().get(i).setCreateTimeStr(DateUtil.formatToDay3(res.getResults().get(i).getCreateTime()));
            res.getResults().get(i).setRepairDateStr(DateUtil.formatToDay2(res.getResults().get(i).getRepairDate()));
        }
        return res;
    }

    @Override
    public int updateByExample(TaskInfo record) {
        TaskInfoExample example = new TaskInfoExample();
        TaskInfoExample.Criteria cc = example.createCriteria();
        cc.andIdEqualTo(record.getId());
        return taskInfoMapper.updateByExampleSelective(record, example);

    }

    @Override
    public int updateAddById(Integer id, BigDecimal payLoanCapital, BigDecimal payLoanInterst, BigDecimal payBorrowInterst, int billItemsNum) {
        return taskInfoMapper.updateAddById(id, payLoanCapital, payLoanInterst, payBorrowInterst, billItemsNum);
    }

    @Override
    public List<TaskInfo> queryByExt(TaskInfoExt record) {
        TaskInfoExample taskInfoExample = new TaskInfoExample();
        TaskInfoExample.Criteria cc = taskInfoExample.createCriteria();
        if (ObjectUtil.isNotEmpty(record.getTaskStatus())) {
            cc.andTaskStatusEqualTo(record.getTaskStatus());
        }
        if (ObjectUtil.isNotEmpty(record.getTaskName())) {
            cc.andTaskNameEqualTo(record.getTaskName());
        }
        if (ObjectUtil.isNotEmpty(record.getRepairDate())) {
            cc.andRepairDateEqualTo(record.getRepairDate());
        }
        if (ObjectUtil.isNotEmpty(record.getTaskType())) {
            cc.andTaskTypeEqualTo(record.getTaskType());
        }
        if (ObjectUtil.isNotEmpty(record.getIds())) {
            cc.andIdIn(record.getIds());
        }
        return taskInfoMapper.selectByExample(taskInfoExample);
    }

    @Override
//    @Transactional(readOnly = true)
    public int insertService(TaskInfo record) throws Exception {
//        taskInfoMapper.insertSelective(record);
        throw new NullPointerException();
    }

    @Override
    @Transactional(timeout = 500)
    public Map<String, Object> get() throws InterruptedException {
        // Thread.sleep(500000);
        Map<String, Object> get = taskInfoMapper.get();
        for (Map.Entry<String, Object> entry : get.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }
        return null;
    }


//    @Override
//    public PageInfoPO<TaskInfo> queryByPage(TaskInfo record, int startLimit, int endLimit) {
//        TaskInfoExample example = new TaskInfoExample();
//        TaskInfoExample.Criteria cc = example.createCriteria();
//        if (ObjectUtil.isNotEmpty(record.getTaskStatus())) {
//            cc.andTaskStatusEqualTo(record.getTaskStatus());
//        }
//        example.setPageNum(startLimit, endLimit);
//        example.setOrderByClause("id desc");
//        PageInfoPO<TaskInfo> res = new PageInfoPO<TaskInfo>();
//        res.setResults(taskInfoMapper.selectByExampleByPage(example));
//        res.setCount(taskInfoMapper.countByExample(example));
//        res.setPageNum(startLimit);
//        res.setPageSize(endLimit);
//        for (int i = 0; i < res.getResults().size(); i++) {
//            res.getResults().get(i).setCreateTimeStr(DateUtil.formatToDay3(res.getResults().get(i).getCreateTime()));
//
//        }
//        return res;
//    }

    @Override
    public int insertReturnPK(TaskInfo record) {
        int id = taskInfoMapper.insertReturnPK(record);
        return record.getId();
    }
}
