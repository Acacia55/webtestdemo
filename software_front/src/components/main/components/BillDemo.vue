<!-- 记账本 -->
<template>
  <el-table :data="data.tableData" style="width: 100%"  @current-change="TableCurrentChange">
    <el-table-column prop="createdDate" label="时间" width="360" />
    <el-table-column prop="in" label="收入" width="180" />
    <el-table-column prop="out" label="支出" />
    <el-table-column label="删除">
        <el-button type="danger" @click="remove()" :icon="Delete"  circle />
    </el-table-column>
  </el-table>
</template>

<script setup lang="ts">
import { reactive, onMounted, ref } from 'vue';
import { selectBill, deleteBill } from '../../../axios/api';
import {
  Delete,
} from '@element-plus/icons-vue'
import { ElMessageBox, ElMessage } from 'element-plus';
const data = reactive({
    tableData: []
})
const currentRow = ref({})

function TableCurrentChange(val : any){
  currentRow.value = val
}
async function getTableInfo(){
    await selectBill({userid: localStorage.getItem("userid")}).then(
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
        '确定要删除这条记录吗?',
        '提示',
        {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
        }
    ).then(() => {
        deleteBill({id: currentRow.value.id}).then(
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
onMounted(async () => {
    getTableInfo();
})
</script>

<style  scoped>

</style>
