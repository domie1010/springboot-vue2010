import Vue from 'vue';
import VueRouter from 'vue-router';
import index from '../views/index.vue';
import login from '../views/login.vue';
import forgot from '../views/forgot.vue';
import register from '../views/register.vue';
Vue.use(VueRouter)

const routes = [
	// 主页
	{
		path: '/',
		name: 'index',
		component: index,
		meta: {
			index: 0,
			title: '首页'
		}
	},

	// 登录
	{
		path: '/login',
		name: 'login',
		component: login,
		meta: {
			index: 0,
			title: '登录'
		}
	},
	// 注册
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {
			index: 0,
			title: '注册'
		}
	},

	// 忘记密码
	{
		path: '/forgot',
		name: "forgot",
		component: forgot,
		meta: {
			index: 0,
			title: '忘记密码'
		}
	},

	// 修改密码
	{
		path: '/user/password',
		name: "password",
		component: () => import("../views/user/password.vue"),
		meta: {
			index: 0,
			title: '修改密码'
		}
	},

	// 视频播放页
	{
		path: "/media/video",
		name: "video",
		component: () => import('../views/media/video.vue'),
		meta: {
			index: 0,
			title: "视频"
		}
	},

	// 音频播放页
	{
		path: "/media/audio",
		name: "audio",
		component: () => import('../views/media/audio.vue'),
		meta: {
			index: 0,
			title: "音频"
		}
	},
	// 用户注册路由
	{
		path: '/user_registration/table',
		name: 'user_registration_table',
		component: () => import('../views/user_registration/table.vue')
	},
	{
		path: '/user_registration/view',
		name: 'user_registration_view',
		component: () => import('../views/user_registration/view.vue')
	},
	// 员工用户路由
	{
		path: '/employee_user/table',
		name: 'employee_user_table',
		component: () => import('../views/employee_user/table.vue')
	},
	{
		path: '/employee_user/view',
		name: 'employee_user_view',
		component: () => import('../views/employee_user/view.vue')
	},
	// 部门信息路由
	{
		path: '/department_information/table',
		name: 'department_information_table',
		component: () => import('../views/department_information/table.vue')
	},
	{
		path: '/department_information/view',
		name: 'department_information_view',
		component: () => import('../views/department_information/view.vue')
	},
	// 职务信息路由
	{
		path: '/job_information/table',
		name: 'job_information_table',
		component: () => import('../views/job_information/table.vue')
	},
	{
		path: '/job_information/view',
		name: 'job_information_view',
		component: () => import('../views/job_information/view.vue')
	},
	// 招聘信息路由
	{
		path: '/recruitment_information/table',
		name: 'recruitment_information_table',
		component: () => import('../views/recruitment_information/table.vue')
	},
	{
		path: '/recruitment_information/view',
		name: 'recruitment_information_view',
		component: () => import('../views/recruitment_information/view.vue')
	},
	// 简历管理路由
	{
		path: '/resume_management/table',
		name: 'resume_management_table',
		component: () => import('../views/resume_management/table.vue')
	},
	{
		path: '/resume_management/view',
		name: 'resume_management_view',
		component: () => import('../views/resume_management/view.vue')
	},
	// 培训信息路由
	{
		path: '/training_information/table',
		name: 'training_information_table',
		component: () => import('../views/training_information/table.vue')
	},
	{
		path: '/training_information/view',
		name: 'training_information_view',
		component: () => import('../views/training_information/view.vue')
	},
	// 考勤打卡路由
	{
		path: '/clock_in/table',
		name: 'clock_in_table',
		component: () => import('../views/clock_in/table.vue')
	},
	{
		path: '/clock_in/view',
		name: 'clock_in_view',
		component: () => import('../views/clock_in/view.vue')
	},
	// 打卡记录路由
	{
		path: '/punch_in_record/table',
		name: 'punch_in_record_table',
		component: () => import('../views/punch_in_record/table.vue')
	},
	{
		path: '/punch_in_record/view',
		name: 'punch_in_record_view',
		component: () => import('../views/punch_in_record/view.vue')
	},
	// 奖惩信息路由
	{
		path: '/reward_and_punishment_information/table',
		name: 'reward_and_punishment_information_table',
		component: () => import('../views/reward_and_punishment_information/table.vue')
	},
	{
		path: '/reward_and_punishment_information/view',
		name: 'reward_and_punishment_information_view',
		component: () => import('../views/reward_and_punishment_information/view.vue')
	},
	// 薪资信息路由
	{
		path: '/salary_information/table',
		name: 'salary_information_table',
		component: () => import('../views/salary_information/table.vue')
	},
	{
		path: '/salary_information/view',
		name: 'salary_information_view',
		component: () => import('../views/salary_information/view.vue')
	},
	// 录用结果路由
	{
		path: '/employment_results/table',
		name: 'employment_results_table',
		component: () => import('../views/employment_results/table.vue')
	},
	{
		path: '/employment_results/view',
		name: 'employment_results_view',
		component: () => import('../views/employment_results/view.vue')
	},

	// 用户路由
	{
		path: '/user/table',
		name: 'user_table',
		component: () => import('../views/user/table.vue'),
		meta: {
			index: 0,
			title: '用户列表'
		}
	},
	{
		path: '/user/view',
		name: 'user_view',
		component: () => import('../views/user/view.vue'),
		meta: {
			index: 0,
			title: '用户详情'
		}
	},
	{
		path: '/user/info',
		name: 'user_info',
		component: () => import('../views/user/info.vue'),
		meta: {
			index: 0,
			title: '个人信息'
		}
	},
	// 用户组路由
	{
		path: '/user_group/table',
		name: 'user_group_table',
		component: () => import('../views/user_group/table.vue'),
		meta: {
			index: 0,
			title: '用户组列表'
		}
	},
	{
		path: '/user_group/view',
		name: 'user_group_view',
		component: () => import('../views/user_group/view.vue'),
		meta: {
			index: 0,
			title: '用户组详情'
		}
	}
]

const router = new VueRouter({
	mode: 'history',
	base: process.env.BASE_URL,
	routes
})

router.beforeEach((to, from, next) => {
	let token = to.query.token;
	if (token){
		$.db.set("token",token,120);
	}
	next();
})

router.afterEach((to, from, next) => {
	let title = "企业人力资源管理系统-admin";
	document.title = title;
})

export default router
