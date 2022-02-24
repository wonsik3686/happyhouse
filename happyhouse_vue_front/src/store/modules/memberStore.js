import jwt_decode from "jwt-decode";
import { login } from "@/api/member.js";
import {
  deleteMember,
  findById,
  signup,
  updatemember,
  idcheck,
} from "../../api/member";

const memberStore = {
  namespaced: true,
  state: {
    isLogin: false,
    isLoginError: false,
    userInfo: null,
    isSignUp: false,
    idCheck: 0,
    isAdmin: false,
  },
  getters: {
    checkUserInfo: function (state) {
      return state.userInfo;
    },
    checkIdCheck: function (state) {
      return state.idCheck;
    },
  },
  mutations: {
    SET_IS_LOGIN: (state, isLogin) => {
      state.isLogin = isLogin;
      console.log(state.isLogin, " SET IS LOGIN");
    },
    SET_IS_LOGIN_ERROR: (state, isLoginError) => {
      state.isLoginError = isLoginError;
    },
    SET_USER_INFO: (state, userInfo) => {
      state.isLogin = true;
      state.userInfo = userInfo;
    },
    SET_IS_SIGN_UP: (state, isSignUp) => {
      state.isSignUp = isSignUp;
    },
    SET_ID_CHECK: (state, idcheck) => {
      state.idCheck = idcheck;
    },
    SET_IS_ADMIN: (state, isAdmin) => {
      state.isAdmin = isAdmin;
    },
  },
  actions: {
    async userConfirm({ commit }, user) {
      console.log("userConfirm()");
      await login(
        user,
        (response) => {
          if (response.data.message === "success") {
            let token = response.data["access-token"];
            commit("SET_IS_LOGIN", true);
            commit("SET_IS_LOGIN_ERROR", false);
            sessionStorage.setItem("access-token", token);
          } else {
            console.log("fail?");
            commit("SET_IS_LOGIN", false);
            commit("SET_IS_LOGIN_ERROR", true);
            commit("SET_IS_ADMIN", false);
          }
        },
        () => {}
      );
    },
    getUserInfo({ commit }, token) {
      let decode_token = jwt_decode(token);
      findById(
        decode_token.userid,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_USER_INFO", response.data.userInfo);
            if (response.data.userInfo.isAdmin !== "y") {
              commit("SET_IS_ADMIN", true);
            } else {
              commit("SET_IS_ADMIN", false);
            }
          } else {
            console.log("유저 정보 없음!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async userIdCheck({ commit }, id) {
      console.log("userIdCheck()");
      await idcheck(
        id,
        (response) => {
          if (response.data.message === "success") {
            commit("SET_ID_CHECK", response.data.idcheck);
            return response.data.idcheck;
          } else {
            console.log("idcheck fail");
          }
        },
        () => {}
      );
    },
    userSignup({ commit }, user) {
      signup(
        user,
        (response) => {
          if (response.data.message === "success") {
            console.log("회원 가입 성공!!");
            commit("SET_IS_SIGN_UP", true);
          } else {
            console.log("회원 가입 실패!!");
            commit("SET_IS_SIGN_UP", false);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    userUpdate({ commit }, user) {
      updatemember(
        user,
        (response) => {
          if (response.data.message === "success") {
            console.log("회원정보 수정 성공!!");
            commit("SET_IS_LOGIN", true);
            //commit("SET_IS_SIGN_UP", true);
          } else {
            console.log("회원정보 수정 실패!!");
            //commit("SET_IS_SIGN_UP", false);
          }
        },
        () => {}
      );
    },
    deleteUser({ commit }, token) {
      let decode_token = jwt_decode(token);
      deleteMember(
        decode_token.userid,
        (response) => {
          if (response.data.message === "success") {
            alert("정상적으로 회원 탈퇴 되었습니다.");
            commit("SET_IS_LOGIN", false);
            commit("SET_USER_INFO", null);
            sessionStorage.removeItem("access-token");
          } else {
            console.log("회원 탈퇴 실패!!");
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default memberStore;
