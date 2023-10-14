package com.example.assessmentitems.mapper;


import com.example.assessmentitems.entity.Team;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeamMapper {
    //四个方法
    //1.接口重置
    @Update("update assessment_system set state = 0 where state = 1")
    void Reset();
    //2.进入功能
    @Select("select * from  assessment_system where id = #{id}")
    Team getTeam(@Param("id") int id);
    @Update("update assessment_system set state = 1 where id = #{id}")
    void State(@Param("id") int id);
    //3.查看功能
    @Select("select * from assessment_system")
    List<Team>  examineTeam();
    //返回列表
    @Select("select id from assessment_system where state = 0")
    List<Integer> ListTeam();
}
