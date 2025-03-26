<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_no') || $check_field('add','recruitment_no') || $check_field('set','recruitment_no')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘编号" prop="recruitment_no">
					<el-input id="recruitment_no" v-model="form['recruitment_no']" placeholder="请输入招聘编号"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','recruitment_no')) || (!form['resume_management_id'] && $check_field('add','recruitment_no'))" :disabled="disabledObj['recruitment_no_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_no')">{{form['recruitment_no']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','recruitment_position') || $check_field('add','recruitment_position') || $check_field('set','recruitment_position')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="招聘职位" prop="recruitment_position">
					<el-input id="recruitment_position" v-model="form['recruitment_position']" placeholder="请输入招聘职位"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','recruitment_position')) || (!form['resume_management_id'] && $check_field('add','recruitment_position'))" :disabled="disabledObj['recruitment_position_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','recruitment_position')">{{form['recruitment_position']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','full_name')) || (!form['resume_management_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
					<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','gender')) || (!form['resume_management_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','id') || $check_field('add','id') || $check_field('set','id')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="身份证" prop="id">
					<el-input id="id" v-model="form['id']" placeholder="请输入身份证"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','id')) || (!form['resume_management_id'] && $check_field('add','id'))" :disabled="disabledObj['id_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','id')">{{form['id']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','education') || $check_field('add','education') || $check_field('set','education')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="学历" prop="education">
					<el-input id="education" v-model="form['education']" placeholder="请输入学历"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','education')) || (!form['resume_management_id'] && $check_field('add','education'))" :disabled="disabledObj['education_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','education')">{{form['education']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','nation') || $check_field('add','nation') || $check_field('set','nation')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="民族" prop="nation">
					<el-input id="nation" v-model="form['nation']" placeholder="请输入民族"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','nation')) || (!form['resume_management_id'] && $check_field('add','nation'))" :disabled="disabledObj['nation_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','nation')">{{form['nation']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','political_outlook') || $check_field('add','political_outlook') || $check_field('set','political_outlook')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="政治面貌" prop="political_outlook">
					<el-input id="political_outlook" v-model="form['political_outlook']" placeholder="请输入政治面貌"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','political_outlook')) || (!form['resume_management_id'] && $check_field('add','political_outlook'))" :disabled="disabledObj['political_outlook_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','political_outlook')">{{form['political_outlook']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
					<el-input id="age" v-model="form['age']" placeholder="请输入年龄"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','age')) || (!form['resume_management_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','expected_salary') || $check_field('add','expected_salary') || $check_field('set','expected_salary')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="预期薪资" prop="expected_salary">
					<el-input id="expected_salary" v-model="form['expected_salary']" placeholder="请输入预期薪资"
							  v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','expected_salary')) || (!form['resume_management_id'] && $check_field('add','expected_salary'))" :disabled="disabledObj['expected_salary_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','expected_salary')">{{form['expected_salary']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','user_account') || $check_field('add','user_account') || $check_field('set','user_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="用户账号" prop="user_account">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_user_account(form['user_account']) }}
							<!--<el-input id="business_name" v-model="form['user_account']" placeholder="请输入用户账号"-->
							<!--v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','user_account')) || (!form['resume_management_id'] && $check_field('add','user_account'))" :disabled="disabledObj['user_account_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','user_account')">{{form['user_account']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','user_account')) || (!form['resume_management_id'] && $check_field('add','user_account'))" id="user_account" v-model="form['user_account']" :disabled="disabledObj['user_account_isDisabled']">
								<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','user_account')" id="user_account" v-model="form['user_account']" :disabled="true">
								<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="user_account" v-model="form['user_account']" :disabled="disabledObj['user_account_isDisabled']">
							<el-option v-for="o in list_user_user_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','file') || $check_field('add','file') || $check_field('set','file')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="文件" prop="file">
					<div v-if="disabledObj['file_isDisabled']">
						<div v-if="$check_field('get','file')">
							<el-button type="primary" @click="$download($fullUrl(form['file']),form['file'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
					<div v-else>
						<el-upload v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','file')) || (!form['resume_management_id'] && $check_field('add','file'))" class="upload-demo" drag
								   action="" style="max-width: 300px;width: 100%;" :http-request="upload_file" :limit="1" accept="">
							<i class="el-icon-upload"></i>
							<div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
						</el-upload>
						<div v-else-if="$check_field('get','file')">
							<el-button type="primary" @click="$download($fullUrl(form['file']),form['file'])">下载<i
									class="el-icon-download el-icon--right"></i></el-button>
						</div>
					</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','educational_experience') || $check_field('add','educational_experience') || $check_field('set','educational_experience')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="教育经验" prop="educational_experience">
					<el-input type="textarea" id="educational_experience" v-model="form['educational_experience']" placeholder="请输入教育经验"
						v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','educational_experience')) || (!form['resume_management_id'] && $check_field('add','educational_experience'))" :disabled="disabledObj['educational_experience_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','educational_experience')">{{form['educational_experience']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','hands_on_background') || $check_field('add','hands_on_background') || $check_field('set','hands_on_background')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="工作经验" prop="hands_on_background">
					<el-input type="textarea" id="hands_on_background" v-model="form['hands_on_background']" placeholder="请输入工作经验"
						v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','hands_on_background')) || (!form['resume_management_id'] && $check_field('add','hands_on_background'))" :disabled="disabledObj['hands_on_background_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','hands_on_background')">{{form['hands_on_background']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','interview_notice') || $check_field('add','interview_notice') || $check_field('set','interview_notice')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="面试通知" prop="interview_notice">
					<el-input type="textarea" id="interview_notice" v-model="form['interview_notice']" placeholder="请输入面试通知"
						v-if="user_group === '管理员' || (form['resume_management_id'] && $check_field('set','interview_notice')) || (!form['resume_management_id'] && $check_field('add','interview_notice'))" :disabled="disabledObj['interview_notice_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','interview_notice')">{{form['interview_notice']}}</div>
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
				field: "resume_management_id",
				url_add: "~/api/resume_management/add?",
				url_set: "~/api/resume_management/set?",
				url_get_obj: "~/api/resume_management/get_obj?",
				url_upload: "~/api/resume_management/upload?",

				query: {
					"resume_management_id": 0,
				},

				form: {
					"recruitment_no":'', // 招聘编号
					"recruitment_position":'', // 招聘职位
					"full_name":'', // 姓名
					"gender":'', // 性别
					"id":'', // 身份证
					"education":'', // 学历
					"nation":'', // 民族
					"political_outlook":'', // 政治面貌
					"age":'', // 年龄
					"expected_salary":'', // 预期薪资
					"user_account": 0, // 用户账号
					"file":'', // 文件
					"educational_experience":'', // 教育经验
					"hands_on_background":'', // 工作经验
					"interview_notice":'', // 面试通知
					"resume_management_id": 0, // ID

				},
				disabledObj:{
					"recruitment_no_isDisabled": false,
					"recruitment_position_isDisabled": false,
					"full_name_isDisabled": false,
					"gender_isDisabled": false,
					"id_isDisabled": false,
					"education_isDisabled": false,
					"nation_isDisabled": false,
					"political_outlook_isDisabled": false,
					"age_isDisabled": false,
					"expected_salary_isDisabled": false,
					"user_account_isDisabled": false,
					"file_isDisabled": false,
					"educational_experience_isDisabled": false,
					"hands_on_background_isDisabled": false,
					"interview_notice_isDisabled": false,
				},
				// 用户列表
				list_user_user_account: [],
				// 用户组
				group_user_user_account: "",
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
			/**
			 * 获取用户注册用户组
			 */
			async get_group_user_user_account() {
				this.form["user_account"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=用户注册");
				if(json.result && json.result.obj){
					this.group_user_user_account = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_user_account(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_user_account.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
						  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                for (var j = 0; j < arrForm.length; j++) {
                  if (arr[i] === arrForm[j]) {
                    if (arr[i] !== "user_account") {
                      _this.form[arrForm[j]] = res.result.obj[arr[i]]
                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                      break;
                    } else {
                      _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                    }
                  }
                }
              }
						}
					}
				});
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
			 * 上传文件
			 * @param {Object} param文件参数
			 */
			upload_file(param){
				this.uploadFile(param.file, "file");
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
					bl = this.$check_action('/resume_management/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_management/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_management/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_management/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/resume_management/view','get');
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
			this.get_group_user_user_account();
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
