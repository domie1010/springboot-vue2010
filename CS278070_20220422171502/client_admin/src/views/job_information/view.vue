<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','position_number') || $check_field('add','position_number') || $check_field('set','position_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="职位编号" prop="position_number">
					<el-input id="position_number" v-model="form['position_number']" placeholder="请输入职位编号"
							  v-if="user_group === '管理员' || (form['job_information_id'] && $check_field('set','position_number')) || (!form['job_information_id'] && $check_field('add','position_number'))" :disabled="disabledObj['position_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position_number')">{{form['position_number']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','position_name') || $check_field('add','position_name') || $check_field('set','position_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="职位名" prop="position_name">
					<el-input id="position_name" v-model="form['position_name']" placeholder="请输入职位名"
							  v-if="user_group === '管理员' || (form['job_information_id'] && $check_field('set','position_name')) || (!form['job_information_id'] && $check_field('add','position_name'))" :disabled="disabledObj['position_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position_name')">{{form['position_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','number_of_positions') || $check_field('add','number_of_positions') || $check_field('set','number_of_positions')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="职位人数" prop="number_of_positions">
					<el-input id="number_of_positions" v-model="form['number_of_positions']" placeholder="请输入职位人数"
							  v-if="user_group === '管理员' || (form['job_information_id'] && $check_field('set','number_of_positions')) || (!form['job_information_id'] && $check_field('add','number_of_positions'))" :disabled="disabledObj['number_of_positions_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','number_of_positions')">{{form['number_of_positions']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','job_profile') || $check_field('add','job_profile') || $check_field('set','job_profile')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="职位简介" prop="job_profile">
					<el-input type="textarea" id="job_profile" v-model="form['job_profile']" placeholder="请输入职位简介"
						v-if="user_group === '管理员' || (form['job_information_id'] && $check_field('set','job_profile')) || (!form['job_information_id'] && $check_field('add','job_profile'))" :disabled="disabledObj['job_profile_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','job_profile')">{{form['job_profile']}}</div>
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
				field: "job_information_id",
				url_add: "~/api/job_information/add?",
				url_set: "~/api/job_information/set?",
				url_get_obj: "~/api/job_information/get_obj?",
				url_upload: "~/api/job_information/upload?",

				query: {
					"job_information_id": 0,
				},

				form: {
					"position_number":'', // 职位编号
					"position_name":'', // 职位名
					"number_of_positions":'', // 职位人数
					"job_profile":'', // 职位简介
					"job_information_id": 0, // ID

				},
				disabledObj:{
					"position_number_isDisabled": false,
					"position_name_isDisabled": false,
					"number_of_positions_isDisabled": false,
					"job_profile_isDisabled": false,
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
					bl = this.$check_action('/job_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/job_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/job_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/job_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/job_information/view','get');
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
