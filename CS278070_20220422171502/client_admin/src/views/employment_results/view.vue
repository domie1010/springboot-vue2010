<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_no') || $check_field('add','recruitment_no') || $check_field('set','recruitment_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘编号" prop="recruitment_no">
					<el-input id="recruitment_no" v-model="form['recruitment_no']" placeholder="请输入招聘编号"
							  v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','recruitment_no')) || (!form['employment_results_id'] && $check_field('add','recruitment_no'))" :disabled="disabledObj['recruitment_no_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_no')">{{form['recruitment_no']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘职位" prop="recruitment_position">
					<el-input id="recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘职位"
							  v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','recruitment_position')) || (!form['employment_results_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_position')">{{form['recruitment_position']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','full_name')) || (!form['employment_results_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
					<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','gender')) || (!form['employment_results_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','id')) || (!form['employment_results_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','user_account') || $check_field('add','user_account') || $check_field('set','user_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户账号" prop="user_account">
						<el-select v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','user_account')) || (!form['employment_results_id'] && $check_field('add','user_account'))" id="user_account" v-model="form['user_account']" :disabled="disabledObj['user_account_isDisabled']">
							<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','user_account')" id="user_account" v-model="form['user_account']" :disabled="true">
							<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','whether_to_employ') || $check_field('add','whether_to_employ') || $check_field('set','whether_to_employ')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="是否录用" prop="whether_to_employ">
					<el-select id="whether_to_employ" v-model="form['whether_to_employ']"
						v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','whether_to_employ')) || (!form['employment_results_id'] && $check_field('add','whether_to_employ'))">
						<el-option v-for="o in list_whether_to_employ" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','whether_to_employ')">{{form['whether_to_employ']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','employment_opinions') || $check_field('add','employment_opinions') || $check_field('set','employment_opinions')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="录用意见" prop="employment_opinions">
					<el-input type="textarea" id="employment_opinions" v-model="form['employment_opinions']" placeholder="请输入录用意见"
						v-if="user_group === '管理员' || (form['employment_results_id'] && $check_field('set','employment_opinions')) || (!form['employment_results_id'] && $check_field('add','employment_opinions'))" :disabled="disabledObj['employment_opinions_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','employment_opinions')">{{form['employment_opinions']}}</div>
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
				field: "employment_results_id",
				url_add: "~/api/employment_results/add?",
				url_set: "~/api/employment_results/set?",
				url_get_obj: "~/api/employment_results/get_obj?",
				url_upload: "~/api/employment_results/upload?",

				query: {
					"employment_results_id": 0,
				},

				form: {
					"recruitment_no":'', // 招聘编号
					"recruitment_position":'', // 招聘职位
					"full_name":'', // 姓名
					"gender":'', // 性别
					"id":'', // 身份证
					"user_account": 0, // 用户账号
					"whether_to_employ":'', // 是否录用
					"employment_opinions":'', // 录用意见
					"employment_results_id": 0, // ID

				},
				disabledObj:{
					"recruitment_no_isDisabled": false,
					"recruitment_position_isDisabled": false,
					"full_name_isDisabled": false,
					"gender_isDisabled": false,
					"id_isDisabled": false,
					"user_account_isDisabled": false,
					"whether_to_employ_isDisabled": false,
					"employment_opinions_isDisabled": false,
				},
				// 用户列表
				list_user_user_account: [],
				//是否录用选项列表
				list_whether_to_employ: ['是','否'],
			}
		},
		methods: {
			/**
			 * 获取用户注册用户列表
			 */
			async get_list_user_user_account() {
                // if(this.user_group !== "管理员" && this.form["user_account"] === 0) {
                //     this.form["user_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=用户注册");
                if(json.result && json.result.list){
                    this.list_user_user_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
			get_user_user_account(id){
				var obj = this.list_user_user_account.getObj({"user_id":id});
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
						case "用户账号":
							if(param["user_account"] > 0){
								param["user_account"] = this.user.user_id;
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
					bl = this.$check_action('/employment_results/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employment_results/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employment_results/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/employment_results/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/employment_results/view','get');
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
			this.get_list_user_user_account();
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
