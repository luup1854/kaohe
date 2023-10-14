package com.example.assessmentitems.service;

import com.example.assessmentitems.entity.Team;
import com.example.assessmentitems.mapper.TeamMapper;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class TeamService {
  @Resource
  private TeamMapper teamMapper;
  //重置
  public void Rest(){
      teamMapper.Reset();
  }
  //进入
  public Team getTeam(int id){
    return teamMapper.getTeam(id);
  }
  public void State(int id){
     teamMapper.State(id);
  }
  //查找
  public List<Team> examineTeam(){
    return teamMapper.examineTeam();
  }
  //随机一个数字不重复
  public int randId(){
      List<Team> list = teamMapper.examineTeam();
      List<Integer> randId = new ArrayList<>();
      for (Team team : list) {
          if (team.getState() == 0) {
              int id = team.getId();
              randId.add(id);
          }
      }
      Random random = new Random();
      int nextInt = random.nextInt(randId.size());
      Integer integer = randId.get(nextInt);
      return integer;
  }
  //返回一个列表
  public List<Integer> ListTeam(){
     return teamMapper.ListTeam();
  }
}
