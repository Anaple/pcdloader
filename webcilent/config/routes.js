export default [
  {
    path: '/user',
    layout: false,
    routes: [
      { path: '/user', routes: [{ name: '登录', path: '/user/login', component: './user/Login' }] },
      { component: './404' },
    ],
  },
  { path: '/welcome', name: '欢迎', icon: 'smile', component: './Welcome' },
  // {
  //   path: '/admin',
  //   name: '管理页',
  //   icon: 'crown',
  //   access: 'canAdmin',
  //   component: './Admin',
  //   routes: [
  //     { path: '/admin/sub-page', name: '二级管理页', icon: 'smile', component: './Welcome' },
  //     { component: './404' },
  //   ],
  // },
  // { name: '查询表格', icon: 'table', path: '/list', component: './TableList' },
  { name: '点云文件管理', icon:'FileImageOutlined', path: '/fileManager', component: './UserFileTable' },
  { name: '设备管理', icon:'VideoCameraOutlined', path: '/deviceManager', component: './DeviceTable' },
  { name: '分享管理',  icon:'ShareAltOutlined', path: '/shareManager', component: './ShareManager' },
  { path: '/', redirect: '/welcome' },
  { component: './404' },
];
