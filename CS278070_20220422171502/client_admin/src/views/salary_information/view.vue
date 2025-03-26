<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','full_name')) || (!form['salary_information_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
					<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','gender')) || (!form['salary_information_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
					<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','age')) || (!form['salary_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','id')) || (!form['salary_information_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','department_name') || $check_field('add','department_name') || $check_field('set','department_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="部门名" prop="department_name">
					<el-input id="department_name" v-model="form['department_name']" placeholder="请输入部门名"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','department_name')) || (!form['salary_information_id'] && $check_field('add','department_name'))" :disabled="disabledObj['department_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','department_name')">{{form['department_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','position_name') || $check_field('add','position_name') || $check_field('set','position_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="职位名" prop="position_name">
					<el-input id="position_name" v-model="form['position_name']" placeholder="请输入职位名"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','position_name')) || (!form['salary_information_id'] && $check_field('add','position_name'))" :disabled="disabledObj['position_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','position_name')">{{form['position_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','base_pay') || $check_field('add','base_pay') || $check_field('set','base_pay')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="基本工资" prop="base_pay">
					<el-input-number id="base_pay" v-model.number="form['base_pay']"
						v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','base_pay')) || (!form['salary_information_id'] && $check_field('add','base_pay'))" :disabled="disabledObj['base_pay_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','base_pay')">{{form['base_pay']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','deduction_amount') || $check_field('add','deduction_amount') || $check_field('set','deduction_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="扣款金额" prop="deduction_amount">
					<el-input-number id="deduction_amount" v-model.number="form['deduction_amount']"
						v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','deduction_amount')) || (!form['salary_information_id'] && $check_field('add','deduction_amount'))" :disabled="disabledObj['deduction_amount_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','deduction_amount')">{{form['deduction_amount']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','reward_amount') || $check_field('add','reward_amount') || $check_field('set','reward_amount')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="奖励金额" prop="reward_amount">
					<el-input-number id="reward_amount" v-model.number="form['reward_amount']"
						v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','reward_amount')) || (!form['salary_information_id'] && $check_field('add','reward_amount'))" :disabled="disabledObj['reward_amount_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','reward_amount')">{{form['reward_amount']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','total_salary') || $check_field('add','total_salary') || $check_field('set','total_salary')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="总工资" prop="total_salary">
					<el-input id="total_salary" v-model="form['total_salary']" placeholder="请输入总工资"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','total_salary')) || (!form['salary_information_id'] && $check_field('add','total_salary'))"  @focus="set_total_salary()" :disabled="disabledObj['total_salary_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','total_salary')">{{form['total_salary']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','salary_month') || $check_field('add','salary_month') || $check_field('set','salary_month')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="工资月份" prop="salary_month">
					<el-input id="salary_month" v-model="form['salary_month']" placeholder="请输入工资月份"
							  v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','salary_month')) || (!form['salary_information_id'] && $check_field('add','salary_month'))" :disabled="disabledObj['salary_month_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','salary_month')">{{form['salary_month']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','staff') || $check_field('add','staff') || $check_field('set','staff')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工" prop="staff">
						<el-select v-if="user_group === '管理员' || (form['salary_information_id'] && $check_field('set','staff')) || (!form['salary_information_id'] && $check_field('add','staff'))" id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
							<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','staff')" id="staff" v-model="form['staff']" :disabled="true">
							<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
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
				field: "salary_information_id",
				url_add: "~/api/salary_information/add?",
				url_set: "~/api/salary_information/set?",
				url_get_obj: "~/api/salary_information/get_obj?",
				url_upload: "~/api/salary_information/upload?",

				query: {
					"salary_information_id": 0,
				},

				form: {
					"full_name":'', // 姓名
					"gender":'', // 性别
					"age":'', // 年龄
					"id":'', // 身份证
					"department_name":'', // 部门名
					"position_name":'', // 职位名
					"base_pay":0, // 基本工资
					"deduction_amount":0, // 扣款金额
					"reward_amount":0, // 奖励金额
					"total_salary":'', // 总工资
					"salary_month":'', // 工资月份
					"staff": 0, // 员工
					"salary_information_id": 0, // ID

				},
				disabledObj:{
					"full_name_isDisabled": false,
					"gender_isDisabled": false,
					"age_isDisabled": false,
					"id_isDisabled": false,
					"department_name_isDisabled": false,
					"position_name_isDisabled": false,
          "base_pay_isDisabled": false,
          "deduction_amount_isDisabled": false,
          "reward_amount_isDisabled": false,
					"total_salary_isDisabled": false,
					"salary_month_isDisabled": false,
					"staff_isDisabled": false,
				},
				// 用户列表
				list_user_staff: [],
			}
		},
		methods: {
			set_total_salary(){
				this.form.total_salary =this.form.base_pay + this.form.reward_amount - this.form.deduction_amount
			},
			/**
			 * 获取员工用户用户列表
			 */
			async get_list_user_staff() {
                // if(this.user_group !== "管理员" && this.form["staff"] === 0) {
                //     this.form["staff"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=员工用户");
                if(json.result && json.result.list){
                    this.list_user_staff = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_staff(id){
				var obj = this.list_user_staff.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				// 获取缓存数据附加
				form = $.db.get("form");
				$.push(this.form ,form);
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "员工":
							if(param["staff"] > 0){
								param["staff"] = this.user.user_id;
							}
							break;
					}
				}
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
					bl = this.$check_action('/salary_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/salary_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/salary_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/salary_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/salary_information/view','get');
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
			this.get_list_user_staff();
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
