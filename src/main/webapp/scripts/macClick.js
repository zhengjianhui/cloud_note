// mac 下判断双击
// 双击判断开关
var flag = true;
// 第一次点击
var	first = 0;
// 第二次点击
var second = 0;

var sum = 0;

function macClick(){
  var date = new Date();
  // 获取点击时间
  var one = date.getTime();
  // 判断结果
  var end = 0;
  // 第一次点击进入
  if(flag){
     // 保存第一次点击时间
     first = one;
     // 修改开关 防止第二次点击进入
     flag = false;
     // 修改sum
     sum += 1;
  } else {
     // 获取第二次点击时间
     second = one;
     // 修改开关 回到第一次点击
     flag = true;
     // 修改sum
     sum += 1;
  }

  // 第二次点击进入
  if(sum == 2) {
    sum = 0
    // 判断两次点击的时间
    if(second > first){
      end = second - first ;
      // 小于1s
      if(end < 1000){
        return true;
      }
    }
  }


  // 返回false;
  return true;
}

function a() {
  var flag = macClick();
  console.log(1);

  if (flag) {
    loadBookNotes();
  }
}
