 <script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue';
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const getId=JSON.parse(localStorage.getItem("getId"))
const router = useRouter()
const home=()=>{
    router.push("/home")
}

const countdown = ref(600); // 初始倒计时时间
const counting = ref(false); // 是否在倒计时中

let timer; // 用于存储计时器

const startCountdown = () => {
counting.value = !counting.value; // 切换倒计时状态

if (counting.value) {
  // 如果开始倒计时
  timer = setInterval(() => {
    countdown.value--;

    if (countdown.value === 120) {
      // 当时间到20s时，暂停倒计时
      clearInterval(timer);
      counting.value = false;
      ElMessage.success("当前前时间还剩120s,已自动暂停")
      
    }

    if (countdown.value === 0) {
      // 时间到，重置倒计时
      clearInterval(timer);
      counting.value = false;
      countdown.value = 600;
    }
  }, 1000);
} else {
  // 如果暂停倒计时
  clearInterval(timer);
}
};
const formatTime = (seconds) => {
      const minutes = Math.floor(seconds / 60);
      const remainingSeconds = seconds % 60;
      return `${minutes}:${remainingSeconds < 10 ? '0' : ''}${remainingSeconds}`;
    };
onBeforeUnmount(() => {
// 组件卸载时清除计时器
clearInterval(timer);
});


</script>
<template>
   <div class="bigBox">
    <div class="box">
      <div style="margin: 20px;">
        <el-text size="25"  tag="b">当前题号:{{ getId.data.id }}</el-text>
        <el-button style="margin-left: 600px;" @click="startCountdown" type="primary">{{ counting ? '暂停' : '开始' }}</el-button> 
        <el-icon  size="14" style="margin-left: 10px;"><AlarmClock /></el-icon>
        <el-text size="large" > {{ formatTime(countdown) }} </el-text> 
           
      </div>
      <div >
        <div  style="margin-left: 60px;margin-right: 60px;margin-top: 80px;height: 300px;width: 200;border: 1px solid rgba(255, 255, 255, 0.6);" >
          <el-text size="25px">
            &nbsp; &nbsp; &nbsp; &nbsp;{{ getId.data.information }}
          </el-text>
        </div>
        <el-button type="primary" @click="home" style="margin-left: 400px;margin-top:  10px;">返回</el-button>
      </div>  
    </div>
    </div>
</template>
<style>
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
