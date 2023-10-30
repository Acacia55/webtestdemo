<!-- 主页面 -->
<template>
  <div class="common-layout">
    <el-container>
      <el-aside width="12%" id="aside">
        <el-row class="tac">
        <el-col :span="24">
            <el-menu
                class="el-menu-vertical-demo"
            >
                <el-menu-item index="1" @click="toRouter('/main/bill', '记账本', '0')">
                    <el-icon><icon-menu /></el-icon>
                    <span>记账本</span>
                </el-menu-item>
                <el-menu-item index="2" @click="toRouter('/main/phone', '通讯录', '1')" >
                    <el-icon><icon-menu /></el-icon>
                    <span>通讯录</span>
                </el-menu-item>
                <!-- <el-menu-item index="3" @click="toRouter('/main/bus', '班车预约', '2')">
                    <el-icon><icon-menu /></el-icon>
                    <span>校车预约</span>
                </el-menu-item> -->

                <el-menu-item index="4" @click="toRouter('/main/todo', '日程安排', '3')">
                    <el-icon><icon-menu /></el-icon>
                    <span>日程安排</span>
                </el-menu-item>
            </el-menu>
        </el-col>
        </el-row>
      </el-aside>

      <el-container>
        <el-header id="header">
            <el-icon :size="25" @click="add"><Plus /></el-icon>
            <span @click="add">&nbsp;&nbsp;{{ data.headerTip }}</span>
            <el-divider direction="vertical" style="margin-top: 5px;border-left: 1px #000 var(--el-border-style); height: 2em;"/>
            <span style="margin-left: 375px;">{{ data.headerTitle }}</span>
            <!-- <el-button type="info" v-if="data.headerFlag === '3'" round>查看已完成任务</el-button> -->
        </el-header>
        
        <!-- 添加账单菜单 -->
        <el-dialog v-model="diagramControl.bill" title="添加账单">
            <el-form :model="billAddForm">
                <el-form-item label="收入" :label-width="formLabelWidth">
                    <el-input-number v-model.number="billAddForm.in" type="text" autocomplete="off" />
                </el-form-item>
                <el-form-item label="支出" :label-width="formLabelWidth">
                    <el-input-number v-model.number="billAddForm.out" type="text" autocomplete="off" />
                </el-form-item>
            </el-form>

            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="diagramControl.bill = false">取消</el-button>
                    <el-button type="primary" @click="billAdd">
                        添加
                    </el-button>
                </span>
            </template>
        </el-dialog>
        <!-- 添加通讯录菜单 -->
        <el-dialog v-model="diagramControl.phone" title="添加联系人">
            <el-form :model="billAddForm">
                <el-form-item label="联系人" :label-width="formLabelWidth">
                    <el-input v-model="phoneAddForm.name" type="text" autocomplete="off" />
                </el-form-item>
                <el-form-item label="联系方式" :label-width="formLabelWidth">
                    <el-input v-model="phoneAddForm.phone" type="text" oninput="value=value.replace(/[^\d.]/g,'')" autocomplete="off" />
                </el-form-item>
            </el-form>

            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="diagramControl.phone = false">取消</el-button>
                    <el-button type="primary" @click="phoneAdd">
                        添加
                    </el-button>
                </span>
            </template>
        </el-dialog>
        <!-- 添加日程安排菜单 -->
        <el-dialog v-model="diagramControl.date" title="添加日程安排">
            <el-form :model="billAddForm">
                <el-form-item prop="date1" label="截止日期">
                    <el-date-picker
                        v-model="dateAddForm.date"
                        type="date"
                        label="截止日期"
                        placeholder="Pick a date"
                        style="width: 100%"
                    />
                </el-form-item>
                <el-form-item label="日程安排" prop="desc">
                    <el-input v-model="dateAddForm.content" type="textarea" />
                </el-form-item>
            </el-form>

            <template #footer>
                <span class="dialog-footer">
                    <el-button @click="diagramControl.date = false">取消</el-button>
                    <el-button type="primary" @click="dateAdd">
                        添加
                    </el-button>
                </span>
            </template>
        </el-dialog>

        <el-divider />

        <el-main id="main">
            <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
   </div>
</template>

<script setup lang="ts">
import {
Menu as IconMenu,
} from '@element-plus/icons-vue'
import { reactive } from 'vue';

const formLabelWidth = '140px'
let data = reactive({
    headerFlag: localStorage.getItem("headerFlag"),          // 0: 账单添加 1: 通讯录
    headerTip: "添加",      // 添加
    headerTitle: localStorage.getItem("headerTitle"),  // 页面功能
})

// 侧栏路由导航
import router from '../../router/index'
function toRouter(path: string, title: string, flag: string) {
    localStorage.setItem("headerTitle", title);
    localStorage.setItem("headerFlag", flag.toString());
    data.headerTitle = title;
    data.headerFlag = flag;
    router.push({path: path});
}

// 菜单显示控制
let diagramControl = reactive({
    bill: false,
    phone: false,
    date: false
})

// 添加按钮
function add() {
    switch (data.headerFlag)
    {
        case '0': // 账单添加
            diagramControl.bill = true;
            break;
        case '1': // 电话簿添加
            diagramControl.phone = true;
            break;
        case '2': // 校车预约
            break;
        case '3': // 日程安排
            diagramControl.date = true;
            break;
        
    }
}
// 账单添加表单
let billAddForm = reactive({
    in: "",
    out: "",
})
// 通讯录添加表单
let phoneAddForm = reactive({
    name: "",
    phone: "",
})
// 日程安排添加表单
let dateAddForm = reactive({
    date: "",
    content: ""
})
import { addBill,addCall } from '../../axios/api'
function billAdd() {
    addBill({userid: localStorage.getItem("userid"), in: billAddForm.in, out: billAddForm.out}).then(res => {
        console.log(res)
        diagramControl.bill = false;
        location.reload();
    }).catch(err => {
        console.log(err)
    })
}
function phoneAdd() {
    if (phoneAddForm.phone.length != 11) {
        ElMessage.error("请输入正确的11位手机号码")
        return
    }
    addCall({userid: localStorage.getItem("userid"), nickname: phoneAddForm.name, phone: phoneAddForm.phone}).then(res => {
        console.log(res)
        diagramControl.phone = false;
        location.reload();
    }).catch(err => {
        console.log(err)
    })
}
import { addDate } from '../../axios/api'
import { ElMessage } from 'element-plus';
function dateAdd() {
    addDate({userid: localStorage.getItem("userid"), deadline: dateAddForm.date, content: dateAddForm.content}).then(res => {
        console.log(res)
        diagramControl.date = false;
        location.reload();
    }).catch(err => {
        console.log(err)
    })
}

</script>

<style  scoped>
#aside {
  /* background-color: #d3dce6; */
}
#main {
  height: 550px;
}
#header {
  height: 15px;
  display: flex;
}
#header .el-icon {
  margin-top: 5px;
}
#header span {
  margin-top: -6px;
  height: 15px;
  font-size: 20px;
  line-height: 50px;
  font-family: "Microsoft YaHei";
}
#header .el-button {
  margin-top: 3px;
  margin-left: 400px;
}

</style>
