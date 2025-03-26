<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','punch_in_type') || $check_field('add','punch_in_type') || $check_field('set','punch_in_type')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="打卡类型" prop="punch_in_type">
					<el-select id="punch_in_type" v-model="form['punch_in_type']"
						v-if="user_group === '管理员' || (form['clock_in_id'] && $check_field('set','punch_in_type')) || (!form['clock_in_id'] && $check_field('add','punch_in_type'))">
						<el-option v-for="o in list_punch_in_type" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','punch_in_type')">{{form['punch_in_type']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','punch_in_date') || $check_field('add','punch_in_date') || $check_field('set','punch_in_date')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="打卡日期" prop="punch_in_date">
					<el-date-picker :disabled="disabledObj['punch_in_date_isDisabled']" v-if="user_group === '管理员' || (form['clock_in_id'] && $check_field('set','punch_in_date')) || (!form['clock_in_id'] && $check_field('add','punch_in_date'))" id="punch_in_date"
						v-model="form['punch_in_date']" type="date" placeholder="选择日期">
					</el-date-picker>
					<div v-else-if="$check_field('get','punch_in_date')">{{form['punch_in_date']}}</div>
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
				field: "clock_in_id",
				url_add: "~/api/clock_in/add?",
				url_set: "~/api/clock_in/set?",
				url_get_obj: "~/api/clock_in/get_obj?",
				url_upload: "~/api/clock_in/upload?",

				query: {
					"clock_in_id": 0,
				},

				form: {
					"punch_in_type":'', // 打卡类型
					"punch_in_date":'', // 打卡日期
					"clock_in_id": 0, // ID

				},
				disabledObj:{
					"punch_in_type_isDisabled": false,
					"punch_in_date_isDisabled": false,
				},
				//打卡类型选项列表
				list_punch_in_type: ['签到','签退'],
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
        if (this.form["punch_in_date"].indexOf("-")===-1){
          this.form["punch_in_date"] = this.$toTime(parseInt(this.form["punch_in_date"]),"yyyy-MM-dd")
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
        if(this.form["punch_in_date"]=="0000-00-00"){
          this.form["punch_in_date"] = null;
        }
				if(parseInt(this.form["punch_in_date"]) > 9999){
					this.form["punch_in_date"] = this.$toTime(parseInt(this.form["punch_in_date"]),"yyyy-MM-dd")
				}
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/clock_in/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/clock_in/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/clock_in/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/clock_in/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/clock_in/view','get');
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
