<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','department_number') || $check_field('add','department_number') || $check_field('set','department_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="部门编号" prop="department_number">
					<el-input id="department_number" v-model="form['department_number']" placeholder="请输入部门编号"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_number')) || (!form['department_information_id'] && $check_field('add','department_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','department_number')">{{form['department_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_name') || $check_field('add','department_name') || $check_field('set','department_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="部门名" prop="department_name">
					<el-input id="department_name" v-model="form['department_name']" placeholder="请输入部门名"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_name')) || (!form['department_information_id'] && $check_field('add','department_name'))" :disabled="disabledObj['department_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_name')">{{form['department_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','number_of_departments') || $check_field('add','number_of_departments') || $check_field('set','number_of_departments')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="部门人数" prop="number_of_departments">
					<el-input id="number_of_departments" v-model="form['number_of_departments']" placeholder="请输入部门人数"
							  v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','number_of_departments')) || (!form['department_information_id'] && $check_field('add','number_of_departments'))" :disabled="disabledObj['number_of_departments_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','number_of_departments')">{{form['number_of_departments']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_profile') || $check_field('add','department_profile') || $check_field('set','department_profile')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="部门简介" prop="department_profile">
					<el-input type="textarea" id="department_profile" v-model="form['department_profile']" placeholder="请输入部门简介"
						v-if="user_group === '管理员' || (form['department_information_id'] && $check_field('set','department_profile')) || (!form['department_information_id'] && $check_field('add','department_profile'))" :disabled="disabledObj['department_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_profile')">{{form['department_profile']}}</div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "department_information_id",
				url_add: "~/api/department_information/add?",
				url_set: "~/api/department_information/set?",
				url_get_obj: "~/api/department_information/get_obj?",
				url_upload: "~/api/department_information/upload?",

				query: {
					"department_information_id": 0,
				},

				form: {
					"department_number":this.$get_stamp(), // 部门编号
					"department_name":'', // 部门名
					"number_of_departments":'', // 部门人数
					"department_profile":'', // 部门简介
					"department_information_id": 0, // ID

				},
				disabledObj:{
					"department_number_isDisabled": false,
					"department_name_isDisabled": false,
					"number_of_departments_isDisabled": false,
					"department_profile_isDisabled": false,
				},
			}
		},
		methods: {

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/department_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/department_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
