<!-- 日程安排 -->
<template>
  <el-table :data="data.tableData" style="width: 100%"  @current-change="TableCurrentChange">
    <el-table-column prop="deadline" label="截止日期" width="360" />
    <el-table-column prop="content" label="日程安排" width="500" />
    <el-table-column label="完成">
        <el-button type="success" :icon="Check" circle @click="remove"/>
    </el-table-column>
  </el-table>
</template>

<script setup lang="ts">
import {
    Check,
} from '@element-plus/icons-vue'
import { reactive, onMounted, ref } from 'vue';
import { ElMessageBox, ElMessage } from 'element-plus';
import { selectDate, deleteDate } from '../../../axios/api';

const currentRow = ref({})
let data = reactive({
    tableData: []
})

async function getTableInfo(){
    await selectDate({userid: localStorage.getItem("userid")}).then(
            (res: { code: any; data: any; msg: string; }) => {
                if (res.code === "666") {
                    data.tableData = res.data;
                }
                else {
                    console.log(res.msg);
                }
            },
            (err: any) => {
                console.log(err);
            }
        )
}

function remove() {
    ElMessageBox.confirm(
        '确定已完成该日程？',
        '提示',
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        }
    ).then(() => {
        deleteDate({id: currentRow.value.id}).then(
            (res: { code: any; data: any; msg: string; }) => {
                if (res.code === "666") {
                    getTableInfo();
                }
                else {
                    console.log(res.msg);
                }
            },
            (err: any) => {
                console.log(err);
            }
        )
        ElMessage({
            type: 'success',
            message: '删除成功!'
        });
    }).catch(() => {
        ElMessage({
            type: 'info',
            message: '删除取消!'
        });
    });
}


function TableCurrentChange(val : any){
  currentRow.value = val
}
onMounted(async () => {
    getTableInfo();
})
</script>

<style  scoped>

</style>
