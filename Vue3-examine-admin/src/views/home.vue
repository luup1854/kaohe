<script setup>
import { ref } from "vue";
import {
  examin,
  getInformationById,
  resetService,
  getNumberList,
} from "../api/user";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";

const router = useRouter();

const NumberList = async () => {
  const res = await getNumberList();
  numberList = res.data.data;
  console.log(11 + res.data.data);
};
NumberList();
let numberList = [];
const number = ref("");
//开始还是暂停
const startOrStop = ref(1);
//开始
const start = () => {
  if (numberList.length == 0) {
    ElMessage.error("已经抽完了");
    // showMsg.value = "请先导入参与人员数据！";
  } else {
    startOrStop.value = 0;
    forNameList(numberList); //循环数组
  }
};
//停止
const stop = () => {
  startOrStop.value = 1;
};

//洗牌算法(乱序数组)
const shuffle = (list) => {
  var l = list.length;
  var index, temp;
  while (l > 0) {
    index = Math.floor(Math.random() * l);
    temp = list[l - 1];
    list[l - 1] = list[index];
    list[index] = temp;
    l--;
  }
  return list;
};
//循环列表
const forNameList = (list) => {
  list = shuffle(list);
  for (let i = 0; i < list.length; i++) {
    setTimeout(() => {
      if (!startOrStop.value) {
        number.value = list[i];
        i == list.length - 1 && forNameList(numberList); //数组耗尽循环
      }
    }, 50 * i);
  }
};
//进入页面2
const entry = async (number) => {
  if (typeof number != "number") {
    ElMessage.error("请先抽取号码");
    return;
  }
  //此时number为形参
  console.log(number);
  const res = await getInformationById(number);
  console.log(res);
  localStorage.setItem("getId", JSON.stringify(res.data));
  router.push("/information");
};
const reset = async () => {
  await resetService();

  NumberList();
  console.log(numberList);
};
//查看
const isDisabled = ref(false);
const dialogVisible = ref(false);
let informationList = []
const see = async() => {
  const ref = await examin()
  informationList = ref.data.data
  console.log(informationList)
  dialogVisible.value = true;
};
</script>
<template>
  <div class="bigBox">
    <div class="box">
      <div style="margin: 20px">
        <span tag="b" type="primary">科传考核系统</span>
      </div>
      <el-button
        style="margin-left: 800px"
        size="large"
        type="error"
        @click="reset"
      >
        重置
      </el-button>
      <div>
        <div class="Box">
          <div style="position: relative">
            <el-progress
              type="circle"
              :width="300"
              :percentage="100"
              :show-text="false"
            ></el-progress>
            <div class="name">
              <span v-if="numberList.length == 0"> </span>
              <span v-else>
                {{ number }}
              </span>
              <!-- <h4 v-if="numberList.length == 0">同学们,要点名了!</h4> -->
            </div>
          </div>
        </div>
      </div>
      <div>
        <el-button
          style="margin-left: 350px"
          size="large"
          type="primary"
          v-if="startOrStop == 1"
          @click="start"
        >
          开始
        </el-button>
        <el-button
          style="margin-left: 350px"
          size="large"
          type="warning"
          v-if="startOrStop == 0"
          @click="stop"
        >
          暂停
        </el-button>
        <el-button
          style="margin-left: 80px"
          size="large"
          type="primary"
          @click="entry(number)"
        >
          进入
        </el-button>
        <el-button
          style="margin-left: 220px"
          size="large"
          type="primary"
          @click="see"
        >
          查看
        </el-button>
      </div>
      <div class="com-div"></div>
      <div class="name">
        <span>
          {{ numberList }}
        </span>
      </div>
      <el-dialog v-model="dialogVisible" title="查看" @close="clearForm">
        <div>
          <h4 style="text-align: center; font-size: 30px">考核系统</h4>
        </div>
        <span>
          {{ numberList }}
        </span>
        <el-row>
          <div
            v-for="item in informationList"
            :key="item.id"
            @click="entry(item.id)"
            style="margin: 80px"
          >
            <el-button type="primary">{{
              item.id
            }}</el-button>
          </div>
        </el-row>
      </el-dialog>
    </div>
  </div>
</template>

<style>
.Box {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 450px;
  width: 100%;
  padding: 30px 20px;
  box-sizing: border-box;
}

.Box .name {
  font-size: 100px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  flex-direction: column;
}

.bigBox {
  height: 100vh;
  overflow-x: hidden;
  display: flex;
  background: #fff;
}

/* 最外层的大盒子 */
.box {
  width: 900px;
  height: 600px;

  /* 相对定位 */
  position: relative;

  margin: auto;
  /* 设置圆角 */
  border-radius: 8px;
  /* 设置边框 */
  border: 1px solid rgba(255, 255, 255, 0.6);
  /* 设置盒子阴影 */
  box-shadow: 2px 1px 19px rgba(0, 0, 0, 0.1);
}
</style>

