<!-- 通讯录 -->
<template>
  <el-table :data="data.tableData" style="width: 100%"  @current-change="TableCurrentChange">
    <el-table-column prop="nickname" label="联系人" width="360" />
    <el-table-column prop="phone" label="联系方式" width="300" />
    <el-table-column label="删除">
        <el-button type="danger" @click="remove()" :icon="Delete"  circle />
    </el-table-column>
  </el-table>
</template>

<script setup lang="ts">
import {
  Delete,
} from '@element-plus/icons-vue'
import { reactive, onMounted, ref } from 'vue';
import { ElMessageBox, ElMessage } from 'element-plus';
import { selectCall, deleteCall } from '../../../axios/api';

const currentRow = ref({})
let data = reactive({
    tableData: []
})


function TableCurrentChange(val : any){
  currentRow.value = val
}

async function getTableInfo(){
    await selectCall({userid: localStorage.getItem("userid")}).then(
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
        deleteCall({id: currentRow.value.id}).then(
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
