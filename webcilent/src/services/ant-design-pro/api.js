// @ts-ignore

/* eslint-disable */
import { request } from 'umi';
/** 获取当前的用户 GET /api/currentUser */
var storage = window.localStorage;
var promiseToken = new Promise((res, rej) => {
  res
})
export async function currentUser(options) {
  promiseToken.then(storage.getItem("token"))
  return currentUserPM(options)
}
export async function currentUserPM(options) {
  return request('/api/currentUser', {
    method: 'GET',
    params: { token: storage.getItem("token") },
    ...(options || {}),
  });
}
/** 退出登录接口 POST /api/login/outLogin */

export async function outLogin(options) {
  storage["token"] = null
  return request('/api/login/outLogin', {
    method: 'POST',

    ...(options || {}),
  });
}
/** 登录接口 POST /api/login/account */

export async function login(body, options) {
  return request('/api/login/account', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
/** 此处后端没有提供注释 GET /api/notices */

export async function getNotices(options) {
  return request('/api/notices', {
    method: 'GET',
    ...(options || {}),
  });
}
/** 获取规则列表 GET /api/rule */

export async function rule(params, options) {
  return request('/api/rule', {
    method: 'GET',
    params: { ...params },
    ...(options || {}),
  });
}
/** 新建规则 PUT /api/rule */

export async function updateRule(options) {
  return request('/api/rule', {
    method: 'PUT',
    ...(options || {}),
  });
}
/** 新建规则 POST /api/rule */

export async function addRule(options) {
  return request('/api/rule', {
    method: 'POST',
    ...(options || {}),
  });
}
/** 删除规则 DELETE /api/rule */

export async function removeRule(options) {
  return request('/api/rule', {
    method: 'DELETE',
    ...(options || {}),
  });
}

/** 点云文件获取  */
export async function fileManager(params, options) {
  return request('/api/fileManager', {
    method: 'GET',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    params: { ...params },
    ...(options || {}),
  });
}
/** 点云文件上传  */
export async function uploadFile(options) {
  return request('/api/fileManager/upload', {
    method: 'POST',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    ...(options || {}),
  });
}
/** 点云文件删除  */
export async function deleteFile(options) {
  return request('/api/fileManager/delete', {
    method: 'POST',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    data: options

  });
}

/** 获取分享 */

export async function share(params, options) {
  return request('/api/share', {
    method: 'GET',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    params: { ...params },
    ...(options || {}),
  });
}

/** 创建分享 */
export async function addShare(options) {
  return request('/api/share/add', {
    method: 'POST',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    ...(options || {}),
  });
}

/** 取消分享 */
export async function deleteShare(options) {
  return request('/api/share/delete', {
    method: 'POST',
    headers: {
      'X-XSRF-TOKEN': storage.getItem("token"),
    },
    ...(options || {}),
  });
}
/**  */