<!-- 登录页面 -->
<template>
      <div id="background">
    <div id="form">
      <div id="title">用户登录</div>
      <div id="pic" ><img src="../../assets/background/loginLogo.png" style="width: 75%;height: 75%"></div>
      <div id="regisTip">新用户？<a @click="toRegister">点击注册!</a></div>
      <div id="info">
        <div id="tip">
          <div>{{formTip.left}}</div>
          <div>{{formTip.right}}</div>
        </div>
        <div id="infoData">
          <div><el-input v-model="formData.account" placeholder="账号" @blur="checkAccount"></el-input></div>
          <div><el-input placeholder="密码" v-model="formData.psw" show-password></el-input></div>
        </div>
        <div id="submit" @click="login">登录</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive } from 'vue';
import router from '../../router';
import {postLogin} from '../../axios/api';

    let formTip = reactive({
        left: "",
        right: ""
    });

    let formData = reactive({
        account: "1234567890",
        psw: "123456789"
    });

    function login() {
        let data  = {
            userid: formData.account,
            password: formData.psw
        }
        if (checkAccount()) {
            postLogin(data).then(
                (res: { code: any; data: any; msg: string; }) => {
                    if (res.code === "666") {
                        localStorage.setItem("userid", res.data.userid);
                        router.push("main");
                    }
                    else {
                        formTip.left = "账号或密码错误，请重试";
                        formData.psw = "";
                    }
                },
                (err: any) => {
                    console.log(err);
                }
            )
        }
    }

    function checkAccount() {
        let check = /^\d{10}$/;
        let flag = check.test(formData.account);
        if (!flag) {
            formTip.left = "账号格式错误";
            return false;
        } else {
            formTip.left = "";
            return true
        }
    }

    function toRegister() {
        //router.push("/register");
    }

</script>

<style  scoped>
#background {
  background: url("../../assets/background/loginBackground.png") no-repeat center;
  height: 100%;
  width: 100%;
  background-size: cover;
  position: fixed;
}

#form {
  height: 530px;
  width: 30%;
  margin-left: 60%;
  margin-top: 5%;
  background:rgba(250, 240, 250, 0.5);
}

#title {
  text-align: center;
  font-family: '华文行楷';
  font-size: 50px;
}

#pic {
  padding-left: 20%;
}

#regisTip {
  text-align: center;
}

#regisTip > a {
  font-size: 20px;
  text-decoration: underline;
}

#info {
  height: 75px;
  width: 80%;
  margin-left: 10%;
  margin-top: 15%;
}

#tip {
  display: flex;
}

#tip > div {
  height: 25px;
  width: 50%;
  color: red;
  font-size: 10px;
  line-height: 25px;
}

#infoData {
  display: flex;
}

#infoData > div {
  height: 50px;
  width: 50%;
}

#submit {
  height: 30px;
  width: 30%;
  margin-left: 35%;
  text-align: center;
  background-color: bisque;
}
</style>
