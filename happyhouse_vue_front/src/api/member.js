import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/user/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function findById(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/info/${userid}`).then(success).catch(fail);
}

async function idcheck(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/idcheck/${userid}`).then(success).catch(fail);
}

async function signup(user, success, fail) {
  await api
    .post(`/user/signup`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function updatemember(user, success, fail) {
  await api
    .post(`/user/update`, JSON.stringify(user))
    .then(success)
    .catch(fail);
}

async function deleteMember(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/user/delete/${userid}`).then(success).catch(fail);
}

// function logout(success, fail)

export { login, findById, signup, updatemember, deleteMember, idcheck };
