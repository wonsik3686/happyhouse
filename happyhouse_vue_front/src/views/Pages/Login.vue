<template>
  <div>
    <!-- Header -->
    <div class="header bg-gradient-info py-7 py-lg-8 pt-lg-9">
      <b-container>
        <div class="header-body text-center mb-7">
          <b-row class="justify-content-center">
            <b-col xl="5" lg="6" md="8" class="px-5">
              <h1 class="text-white">로그인</h1>
              <p class="text-lead text-white">
                해피하우스 서비스 이용을 위해 로그인해주세요.
              </p>
            </b-col>
          </b-row>
        </div>
      </b-container>
      <div class="separator separator-bottom separator-skew zindex-100">
        <svg
          x="0"
          y="0"
          viewBox="0 0 2560 100"
          preserveAspectRatio="none"
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
        >
          <polygon
            class="fill-default"
            points="2560 0 2560 100 0 100"
          ></polygon>
        </svg>
      </div>
    </div>
    <!-- Page content -->
    <b-container class="mt--8 pb-5">
      <b-row class="justify-content-center">
        <b-col lg="5" md="7">
          <b-card no-body class="bg-secondary border-0 mb-0">
            <!-- <b-card-header class="bg-transparent pb-5">
              <div class="text-muted text-center mt-2 mb-3">
                <small>간편 로그인</small>
              </div>
              <div class="btn-wrapper text-center">
                <a href="#" class="btn btn-neutral btn-icon">
                  <span class="btn-inner--icon"
                    ><img src="img/icons/common/github.svg"
                  /></span>
                  <span class="btn-inner--text">Github</span>
                </a>
                <a href="#" class="btn btn-neutral btn-icon">
                  <span class="btn-inner--icon"
                    ><img src="img/icons/common/google.svg"
                  /></span>
                  <span class="btn-inner--text">Google</span>
                </a>
              </div>
            </b-card-header> -->
            <b-card-body class="px-lg-5 py-lg-5">
              <div class="text-center text-muted mb-4">
                <small>기존 회원</small>
              </div>
              <validation-observer
                v-slot="{ handleSubmit }"
                ref="formValidator"
              >
                <b-form role="form" @submit.prevent="handleSubmit(confirm)">
                  <base-input
                    alternative
                    class="mb-3"
                    name="Id"
                    :rules="{ required: true }"
                    prepend-icon="ni ni-circle-08"
                    placeholder="ID"
                    v-model="model.userid"
                    @keyup.enter="confirm"
                  >
                  </base-input>

                  <base-input
                    alternative
                    class="mb-3"
                    name="Password"
                    :rules="{ required: true, min: 5 }"
                    prepend-icon="ni ni-lock-circle-open"
                    type="password"
                    placeholder="Password"
                    v-model="model.userpwd"
                    @keyup.enter="confirm"
                  >
                  </base-input>

                  <!-- <b-form-checkbox v-model="model.rememberMe"
                    >아이디 저장</b-form-checkbox
                  > -->
                  <div class="text-center">
                    <base-button
                      type="primary"
                      native-type="submit"
                      class="my-4"
                      >로그인</base-button
                    >
                  </div>
                </b-form>
              </validation-observer>
            </b-card-body>
          </b-card>
          <b-row class="mt-3">
            <b-col cols="6">
              <!-- <router-link to="/dashboard" class="text-light"
                ><small>비밀번호찾기</small></router-link
              > -->
            </b-col>
            <b-col cols="6" class="text-right">
              <router-link to="/register" class="text-light"
                ><small><strong>회원가입</strong></small></router-link
              >
            </b-col>
          </b-row>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import { mapGetters } from "vuex";
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "login",
  data() {
    return {
      model: {
        email: "string",
        joindate: "string",
        userid: "",
        username: "string",
        userpwd: "",
        // rememberMe: false,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo", ""]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    ...mapGetters(memberStore, ["checkUserInfo"]),
    async onSubmit() {
      console.log(">>> onSubmit!!");
      // this will be called only after form is valid. You can do api call here to login
      confirm();
    },
    async confirm() {
      console.log(">>> confirm(), model: ", this.model);
      await this.userConfirm(this.model);
      let token = sessionStorage.getItem("access-token");
      // console.log(">>> await, token: ", token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log(this.userinfo);
        //const checkUserInfo = store.getters["memberStore/checkUserInfo"];
        let checkUserInfo = this.checkUserInfo;
        if (checkUserInfo.isAdmin !== "y") {
          this.isAdmin = false;
        } else {
          this.isAdmin = true;
        }

        this.$router.push({ name: "dashboard" });
      }
    },
  },
};
</script>
