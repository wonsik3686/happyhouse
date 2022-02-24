<template>
  <div>
    <!-- Header -->
    <div class="header bg-gradient-info py-7 py-lg-8 pt-lg-9">
      <b-container class="container">
        <div class="header-body text-center mb-7">
          <b-row class="justify-content-center">
            <b-col xl="5" lg="6" md="8" class="px-5">
              <h1 class="text-white">회원 가입</h1>
              <p class="text-lead text-white">
                환영합니다! 해피하우스 서비스 이용을 위해 아래 정보를
                입력해주세요.
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
      <!-- Table -->
      <b-row class="justify-content-center">
        <b-col lg="6" md="8">
          <b-card no-body class="bg-secondary border-0">
            <!-- <b-card-header class="bg-transparent pb-5">
              <div class="text-muted text-center mt-2 mb-4">
                <small>Sign up with</small>
              </div>
              <div class="text-center">
                <a href="#" class="btn btn-neutral btn-icon mr-4">
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
                <small>Osign up with credentials</small>
              </div>
              <validation-observer
                v-slot="{ handleSubmit }"
                ref="formValidator"
              >
                <b-form role="form" @submit.prevent="handleSubmit(onSubmit)">
                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-circle-08"
                    placeholder="아이디 입력"
                    name="Id"
                    :rules="{ required: true, min: 5, max: 20 }"
                    v-model="useridCheck"
                  >
                  </base-input>
                  <b-alert
                    v-if="
                      (idCheck === 0) &
                      (useridCheck.length >= 5) &
                      (useridCheck.length <= 20)
                    "
                    show
                    variant="success"
                    alternative
                    class="mb-3"
                  >
                    사용 가능한 아이디입니다
                  </b-alert>

                  <b-alert
                    v-if="
                      (idCheck !== 0) &
                      (useridCheck.length >= 5) &
                      (useridCheck.length <= 20)
                    "
                    show
                    variant="danger"
                    alternative
                    class="mb-3"
                  >
                    중복된 아이디가 있습니다
                  </b-alert>

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-hat-3"
                    placeholder="이름 입력"
                    name="Name"
                    :rules="{ required: true }"
                    v-model="model.username"
                  >
                  </base-input>

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-email-83"
                    placeholder="이메일 입력"
                    name="Email"
                    :rules="{ required: true, email: true }"
                    v-model="model.email"
                  >
                  </base-input>

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-lock-circle-open"
                    placeholder="비밀번호 입력"
                    type="password"
                    name="Password"
                    :rules="{ required: true, min: 6, max: 20 }"
                    v-model="model.userpwd"
                  >
                  </base-input>

                  <base-input
                    alternative
                    class=""
                    prepend-icon="ni ni-lock-circle-open"
                    placeholder="비밀번호 확인"
                    type="password"
                    name="ConfirmPassword"
                    v-model="passwordCheck"
                    @blur="passwordCheckValid"
                  >
                  </base-input>
                  <b-alert
                    v-if="!passwordCheckFlag"
                    alternative
                    class="mb-3"
                    show
                    variant="danger"
                  >
                    비밀번호가 일치하지 않습니다
                  </b-alert>

                  <base-input
                    alternative
                    label="국가"
                    class="mb-3"
                    prepend-icon="ni ni-world"
                    name="Country"
                    placeholder="국가"
                  >
                    <select class="form-control" v-model="model.country">
                      <option disabled value="">국가 선택</option>
                      <option>아프가니스탄</option>
                      <option>호주</option>
                      <option>브라질</option>
                      <option>영국</option>
                      <option>중국</option>
                      <option>일본</option>
                      <option>프랑스</option>
                      <option>대한민국</option>
                      <option>스페인</option>
                      <option>미국</option>
                    </select>
                  </base-input>

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-square-pin"
                    placeholder="도시 입력"
                    name="City"
                    :rules="{ required: true, max: 20 }"
                    v-model="model.city"
                  />

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-single-02"
                    placeholder="나이 입력"
                    name="Age"
                    :rules="{ required: true }"
                    v-model="model.age"
                  />

                  <base-input
                    alternative
                    label="Job"
                    class="mb-3"
                    prepend-icon="ni ni-badge"
                    name="Job"
                    placeholder="직업 선택"
                  >
                    <select class="form-control" v-model="model.job">
                      <option disabled value="">직업 선택</option>
                      <option>관리자</option>
                      <option>사무 종사자</option>
                      <option>서비스 종사자</option>
                      <option>판매 종사자</option>
                      <option>전문가 및 관련 종사자</option>
                      <option>농림 어업 숙련 종사자</option>
                      <option>기능원 및 관련 기능 종사자</option>
                      <option>장치 기계 조작 및 조립 종사자</option>
                      <option>단순노무 종사자</option>
                      <option>군인</option>
                      <option>기타</option>
                    </select>
                  </base-input>

                  <base-input
                    alternative
                    class="mb-3"
                    prepend-icon="ni ni-notification-70"
                    type="tel"
                    name="Phone"
                    placeholder="전화번호 입력"
                    v-model="model.phone"
                  />

                  <base-input label="자기 소개">
                    <textarea
                      class="form-control mb-3"
                      name="AboutMe"
                      id="exampleFormControlTextarea3"
                      rows="3"
                      v-model="model.aboutme"
                    ></textarea>
                  </base-input>

                  <!-- <div class="text-muted font-italic">
                    <small
                      >password strength:
                      <span class="text-success font-weight-700"
                        >strong</span
                      ></small
                    >
                  </div> -->
                  <!-- <b-row class="my-4">
                    <b-col cols="12">
                      <base-input
                        :rules="{ required: { allowFalse: false } }"
                        name="Privacy"
                        Policy
                      >
                        <b-form-checkbox v-model="model.agree">
                          <span class="text-muted"
                            >I agree with the
                            <a href="#!">Privacy Policy</a></span
                          >
                        </b-form-checkbox>
                      </base-input>
                    </b-col>
                  </b-row> -->
                  <div class="text-center">
                    <b-button type="submit" variant="primary" class="mt-4"
                      >회원 가입</b-button
                    >
                  </div>
                </b-form>
              </validation-observer>
            </b-card-body>
          </b-card>
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
  name: "register",
  data() {
    return {
      model: {
        email: "",
        joindate: "",
        userid: "",
        username: "",
        userpwd: "",
        isAdmin: "",
        phone: "",
        age: "",
        country: "",
        city: "",
        aboutme: "",
        job: "",
      },
      useridCheck: "",
      passwordCheck: "",
      passwordCheckFlag: true,
      useridIsValid: false,
    };
  },
  computed: {
    ...mapState(memberStore, [
      "isLogin",
      "isLoginError",
      "userinfo",
      "isSignUp",
      "idCheck",
    ]),
  },
  watch: {
    ...mapGetters(memberStore, ["checkIdCheck"]),
    ...mapActions(memberStore, ["userIdCheck"]),
    useridCheck: async function () {
      await this.checkId(this.useridCheck);
      //console.log(checkIdCheck);
    },
  },
  methods: {
    ...mapGetters(memberStore, ["checkIdCheck"]),
    ...mapActions(memberStore, [
      "userSignup",
      "userConfirm",
      "getUserInfo",
      "userIdCheck",
    ]),
    ...mapState(memberStore, [
      "isLogin",
      "isLoginError",
      "userinfo",
      "isSignUp",
      "idCheck",
    ]),
    async onSubmit() {
      // this will be called only after form is valid. You can do an api call here to register users
      console.log(this.model);
      if (this.useridIsValid == true) {
        await this.userSignup(this.model);
        if (this.isSignUp) {
          alert("회원가입 성공! ID:" + this.model.userid);
          this.$router.push({ name: "login" });
        }
      } else {
        alert("ID 를 확인하세요.");
      }
    },
    async checkId(id) {
      let count = await this.userIdCheck(id);
      console.log(this.idCheck);
      if (this.idCheck == 0) {
        this.model.userid = id;
        this.useridIsValid = true;
      } else {
        this.useridIsValid = false;
      }
    },
    passwordCheckValid() {
      if (this.model.userpwd === this.passwordCheck) {
        this.passwordCheckFlag = true;
      } else {
        this.passwordCheckFlag = false;
      }
    },
  },
};
</script>
<style></style>
