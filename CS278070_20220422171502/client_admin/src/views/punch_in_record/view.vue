<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','punch_in_type') || $check_field('add','punch_in_type') || $check_field('set','punch_in_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="打卡类型" prop="punch_in_type">
					<el-input id="punch_in_type" v-model="form['punch_in_type']" placeholder="请输入打卡类型"
							  v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','punch_in_type')) || (!form['punch_in_record_id'] && $check_field('add','punch_in_type'))" :disabled="disabledObj['punch_in_type_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','punch_in_type')">{{form['punch_in_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','punch_in_date') || $check_field('add','punch_in_date') || $check_field('set','punch_in_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="打卡日期" prop="punch_in_date">
					<el-input id="punch_in_date" v-model="form['punch_in_date']" placeholder="请输入打卡日期"
							  v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','punch_in_date')) || (!form['punch_in_record_id'] && $check_field('add','punch_in_date'))" :disabled="disabledObj['punch_in_date_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','punch_in_date')">{{form['punch_in_date']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','clock_in_time') || $check_field('add','clock_in_time') || $check_field('set','clock_in_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="打卡时间" prop="clock_in_time">
					<el-date-picker :disabled="disabledObj['clock_in_time_isDisabled']" v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','clock_in_time')) || (!form['punch_in_record_id'] && $check_field('add','clock_in_time'))" id="clock_in_time"
						v-model="form['clock_in_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','clock_in_time')">{{form['clock_in_time']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','full_name') || $check_field('add','full_name') || $check_field('set','full_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="姓名" prop="full_name">
					<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"
							  v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','full_name')) || (!form['punch_in_record_id'] && $check_field('add','full_name'))" :disabled="disabledObj['full_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','full_name')">{{form['full_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','staff') || $check_field('add','staff') || $check_field('set','staff')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="员工" prop="staff">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_staff(form['staff']) }}
							<!--<el-input id="business_name" v-model="form['staff']" placeholder="请输入员工"-->
							<!--v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','staff')) || (!form['punch_in_record_id'] && $check_field('add','staff'))" :disabled="disabledObj['staff_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','staff')">{{form['staff']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['punch_in_record_id'] && $check_field('set','staff')) || (!form['punch_in_record_id'] && $check_field('add','staff'))" id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
								<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','staff')" id="staff" v-model="form['staff']" :disabled="true">
								<el-option v-for="o in list_user_staff" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="staff" v-model="form['staff']" :disabled="disabledObj['staff_isDisabled']">
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
				field: "punch_in_record_id",
				url_add: "~/api/punch_in_record/add?",
				url_set: "~/api/punch_in_record/set?",
				url_get_obj: "~/api/punch_in_record/get_obj?",
				url_upload: "~/api/punch_in_record/upload?",

				query: {
					"punch_in_record_id": 0,
				},

				form: {
					"punch_in_type":'', // 打卡类型
					"punch_in_date":'', // 打卡日期
					"clock_in_time":'', // 打卡时间
					"full_name":'', // 姓名
					"staff": 0, // 员工
					"punch_in_record_id": 0, // ID

				},
				disabledObj:{
					"punch_in_type_isDisabled": false,
					"punch_in_date_isDisabled": false,
					"clock_in_time_isDisabled": false,
					"full_name_isDisabled": false,
					"staff_isDisabled": false,
				},
				// 用户列表
				list_user_staff: [],
				// 用户组
				group_user_staff: "",
			}
		},
		methods: {
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
			/**
			 * 获取员工用户用户组
			 */
			async get_group_user_staff() {
				this.form["staff"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=员工用户");
				if(json.result && json.result.obj){
					this.group_user_staff = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_staff(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_staff.source_table+"/get_obj?"
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
                    if (arr[i] !== "staff") {
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
				this.form["clock_in_time"] = this.$toTime(parseInt(this.form["clock_in_time"]),"yyyy-MM-dd hh:mm:ss")
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
        if(this.form["clock_in_time"]=="0000-00-00 00:00:00"){
          this.form["clock_in_time"] = null;
        }
				if(parseInt(this.form["clock_in_time"]) > 9999){
					this.form["clock_in_time"] = this.$toTime(parseInt(this.form["clock_in_time"]),"yyyy-MM-dd hh:mm:ss")
				}
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/punch_in_record/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/punch_in_record/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/punch_in_record/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/punch_in_record/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/punch_in_record/view','get');
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
			this.get_group_user_staff();
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
