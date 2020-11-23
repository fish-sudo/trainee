package cn.com.dao.info;

import cn.com.bean.TraineeBean;

import java.util.List;

public interface TraineeDaoInfo {
    List<TraineeBean> findAll();
    List<TraineeBean> findByName();
    int insert(TraineeBean bean);
    int update(TraineeBean bean);
    int delete(TraineeBean bean);
}
