<template>
	<div>
		<el-form-item v-if="$check_register_field('add','gender','/user_registration/view')" label="性别" prop="gender">
		<el-select id="gender" v-model="form['gender']">
			<el-option v-for="o in list_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','full_name','/user_registration/view')" label="姓名" prop="full_name">
		<el-input id="full_name" v-model="form['full_name']" placeholder="请输入姓名"></el-input>
		</el-form-item>

	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
						"gender":'',
						"full_name":'',
					}
				}
			},

		},
		data() {
			return {
				field: "user_registration_id",
				url_add: "~/api/user_registration/add?",
				url_set: "~/api/user_registration/set?",
				url_upload: "~/api/user_registration/upload?",
				list_gender: ['男','女'],

				rules: {
					"gender": [ ],
					"full_name": [ ],
				}

			}
		},
		methods: {

		},
		created() {
		}
	}
</script>
