import { apiInstance } from "./index.js";

const api = apiInstance();

async function getInterest(userid, success, fail) {
  api.defaults.headers["access-token"] = sessionStorage.getItem("access-token");
  await api.get(`/map/interest/${userid}`).then(success).catch(fail);
}

// function setInterest(params, success, fail) {
//   api.post(`/map/interest`, { params: params }).then(success).catch(fail);
// }

async function setInterest(params, success, fail) {
  await api
    .post(`/map/interest`, JSON.stringify(params))
    .then(success)
    .catch(fail);
}

export { getInterest, setInterest };
