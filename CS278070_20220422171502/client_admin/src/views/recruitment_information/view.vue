<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_no') || $check_field('add','recruitment_no') || $check_field('set','recruitment_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘编号" prop="recruitment_no">
					<el-input id="recruitment_no" v-model="form['recruitment_no']" placeholder="请输入招聘编号"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_no')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_no'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','recruitment_no')">{{form['recruitment_no']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘职位" prop="recruitment_position">
					<el-input id="recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘职位"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_position')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_position')">{{form['recruitment_position']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','number_of_recruits') || $check_field('add','number_of_recruits') || $check_field('set','number_of_recruits')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘人数" prop="number_of_recruits">
					<el-input-number id="number_of_recruits" v-model.number="form['number_of_recruits']"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','number_of_recruits')) || (!form['recruitment_information_id'] && $check_field('add','number_of_recruits'))" :disabled="disabledObj['number_of_recruits_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_recruits')">{{form['number_of_recruits']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_time') || $check_field('add','recruitment_time') || $check_field('set','recruitment_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘时间" prop="recruitment_time">
					<el-input id="recruitment_time" v-model="form['recruitment_time']" placeholder="请输入招聘时间"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','recruitment_time')) || (!form['recruitment_information_id'] && $check_field('add','recruitment_time'))" :disabled="disabledObj['recruitment_time_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_time')">{{form['recruitment_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age_requirements') || $check_field('add','age_requirements') || $check_field('set','age_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄要求" prop="age_requirements">
					<el-input id="age_requirements" v-model="form['age_requirements']" placeholder="请输入年龄要求"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','age_requirements')) || (!form['recruitment_information_id'] && $check_field('add','age_requirements'))" :disabled="disabledObj['age_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age_requirements')">{{form['age_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','salary_forecast') || $check_field('add','salary_forecast') || $check_field('set','salary_forecast')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="工资预计" prop="salary_forecast">
					<el-input id="salary_forecast" v-model="form['salary_forecast']" placeholder="请输入工资预计"
							  v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','salary_forecast')) || (!form['recruitment_information_id'] && $check_field('add','salary_forecast'))" :disabled="disabledObj['salary_forecast_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','salary_forecast')">{{form['salary_forecast']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','educational_requirements') || $check_field('add','educational_requirements') || $check_field('set','educational_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学历要求" prop="educational_requirements">
					<el-input type="textarea" id="educational_requirements" v-model="form['educational_requirements']" placeholder="请输入学历要求"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','educational_requirements')) || (!form['recruitment_information_id'] && $check_field('add','educational_requirements'))" :disabled="disabledObj['educational_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','educational_requirements')">{{form['educational_requirements']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','experience_requirements') || $check_field('add','experience_requirements') || $check_field('set','experience_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="经验要求" prop="experience_requirements">
					<el-input type="textarea" id="experience_requirements" v-model="form['experience_requirements']" placeholder="请输入经验要求"
						v-if="user_group === '管理员' || (form['recruitment_information_id'] && $check_field('set','experience_requirements')) || (!form['recruitment_information_id'] && $check_field('add','experience_requirements'))" :disabled="disabledObj['experience_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','experience_requirements')">{{form['experience_requirements']}}</div>
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
				field: "recruitment_information_id",
				url_add: "~/api/recruitment_information/add?",
				url_set: "~/api/recruitment_information/set?",
				url_get_obj: "~/api/recruitment_information/get_obj?",
				url_upload: "~/api/recruitment_information/upload?",

				query: {
					"recruitment_information_id": 0,
				},

				form: {
					"recruitment_no":this.$get_stamp(), // 招聘编号
					"recruitment_position":'', // 招聘职位
					"number_of_recruits":0, // 招聘人数
					"recruitment_time":'', // 招聘时间
					"age_requirements":'', // 年龄要求
					"salary_forecast":'', // 工资预计
					"educational_requirements":'', // 学历要求
					"experience_requirements":'', // 经验要求
					"recruitment_information_id": 0, // ID

				},
				disabledObj:{
					"recruitment_no_isDisabled": false,
					"recruitment_position_isDisabled": false,
          "number_of_recruits_isDisabled": false,
					"recruitment_time_isDisabled": false,
					"age_requirements_isDisabled": false,
					"salary_forecast_isDisabled": false,
					"educational_requirements_isDisabled": false,
					"experience_requirements_isDisabled": false,
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
					bl = this.$check_action('/recruitment_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/recruitment_information/view','get');
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
