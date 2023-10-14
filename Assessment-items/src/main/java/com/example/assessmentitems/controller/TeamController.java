package com.example.assessmentitems.controller;
import com.example.assessmentitems.entity.Team;
import com.example.assessmentitems.result.Result;
import com.example.assessmentitems.service.TeamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Controller
@RestController
@CrossOrigin
public class TeamController {
    @Resource
    private TeamService teamService;
    //重置方法实现
    @PostMapping("/reset")
    public Result Rest(){
         teamService.Rest();
         log.info("重置成功");
         return Result.success();
    }
    //进入功能方法实现
    @GetMapping("/select")
    public Result getTeam(@RequestParam int id){
        log.info("正在查找");
        Team team = teamService.getTeam(id);
        teamService.State(id);
        return Result.success(team);
    }
    //查看功能实现
    @GetMapping("/examin")
    //[1,3,4,5]
    public Result examineTeam(){
        List<Team> list = teamService.examineTeam();
        return Result.success(list);
    }
    //随机一条数据
    @GetMapping("/rand")
    public int randTeam() {
        return teamService.randId();
    }
    //返回列表
    @GetMapping("/list")
    public Result ListTeam(){
        List<Integer> list = teamService.ListTeam();
        return Result.success(list);
    }
}
