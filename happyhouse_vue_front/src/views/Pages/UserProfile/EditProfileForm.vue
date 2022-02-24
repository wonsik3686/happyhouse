<template>
  <card>
    <b-row align-v="center" slot="header">
      <b-col cols="8">
        <h3 class="mb-0">Edit profile</h3>
      </b-col>
      <b-col cols="4" class="text-right">
        <a @click="updateProfile" class="btn btn-sm btn-primary">Settings</a>
      </b-col>
    </b-row>

    <b-form @submit.prevent="handleSubmit(onSubmit)">
      <h6 class="heading-small text-muted mb-4">User information</h6>

      <div class="pl-lg-4">
        <b-row>
          <b-col lg="6">
            <base-input
              type="text"
              label="이름"
              placeholder="Username"
              v-model="umodel.username"
            >
            </base-input>
          </b-col>
          <b-col lg="6">
            <base-input
              type="email"
              label="이메일 주소"
              placeholder="mike@email.com"
              v-model="umodel.email"
            >
            </base-input>
          </b-col>
        </b-row>
        <b-row>
          <b-col lg="6">
            <base-input
              type="text"
              label="직업"
              placeholder="Job"
              v-model="umodel.job"
            >
            </base-input>
          </b-col>
        </b-row>
        <!-- <b-row>
          <b-col lg="6">
            <base-input
              type="text"
              label="First Name"
              placeholder="First Name"
              v-model="user.firstName"
            >
            </base-input>
          </b-col>
          <b-col lg="6">
            <base-input
              type="text"
              label="Last Name"
              placeholder="Last Name"
              v-model="user.lastName"
            >
            </base-input>
          </b-col>
        </b-row> -->
      </div>
      <hr class="my-4" />

      <!-- Address -->
      <h6 class="heading-small text-muted mb-4">Contact information</h6>

      <div class="pl-lg-4">
        <!-- <b-row>
          <b-col md="12">
            <base-input
              type="text"
              label="Address"
              placeholder="Home Address"
              v-model="user.address"
            >
            </base-input>
          </b-col>
        </b-row> -->
        <b-row>
          <b-col lg="4">
            <base-input
              type="text"
              label="도시"
              placeholder="City"
              v-model="umodel.city"
            >
            </base-input>
          </b-col>
          <b-col lg="4">
            <base-input
              type="text"
              label="국가"
              placeholder="Country"
              v-model="umodel.country"
            >
            </base-input>
          </b-col>
          <!-- <b-col lg="4">
            <base-input
              label="Postal Code"
              placeholder="ZIP Code"
              v-model="user.postalCode"
            >
            </base-input>
          </b-col> -->
        </b-row>
        <b-row>
          <b-col md="12">
            <base-input
              type="text"
              label="전화번호"
              placeholder="Phone Number"
              v-model="umodel.phone"
            >
            </base-input>
          </b-col>
        </b-row>
      </div>

      <hr class="my-4" />
      <!-- Description -->
      <h6 class="heading-small text-muted mb-4">About me</h6>
      <div class="pl-lg-4">
        <b-form-group
          label="소개"
          label-class="form-control-label"
          class="mb-0"
          label-for="about-form-textaria"
        >
          <!--  <label class="form-control-label">About Me</label> -->
          <b-form-textarea
            rows="4"
            value="A beautiful premium dashboard for BootstrapVue."
            id="about-form-textaria"
            placeholder="A few words about you ..."
            v-model="umodel.aboutme"
          ></b-form-textarea>
        </b-form-group>
      </div>
      <hr class="my-4" />
    </b-form>
    <div class="text-center">
      <base-button type="danger" @click="OnDeleteUser" class="my-4"
        >회원 탈퇴</base-button
      >
    </div>
  </card>
</template>
<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  data() {
    return {
      user: {
        company: "Creative Code Inc.",
        username: "michael23",
        email: "",
        firstName: "Mike",
        lastName: "Andrew",
        address: "Bld Mihail Kogalniceanu, nr. 8 Bl 1, Sc 1, Ap 09",
        city: "New York",
        country: "USA",
        postalCode: "",
        aboutMe: `Lamborghini Mercy, Your chick she so thirsty, I'm in that two seat Lambo.`,
      },
      umodel: {
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
      str: "",
    };
  },
  created() {
    let name = "";
    let email = "";
    let phone = "";
    let age = "";
    let country = "";
    let city = "";
    let aboutme = "";
    let job = "";
    name = this.userInfo.username;
    email = this.userInfo.email;
    phone = this.userInfo.phone;
    age = this.userInfo.age;
    country = this.userInfo.country;
    city = this.userInfo.city;
    aboutme = this.userInfo.aboutme;
    job = this.userInfo.job;
    this.umodel.username = name;
    this.umodel.email = email;
    this.umodel.age = age;
    this.umodel.country = country;
    this.umodel.city = city;
    this.umodel.phone = phone;
    this.umodel.aboutme = aboutme;
    this.umodel.job = job;
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(memberStore, [
      "userConfirm",
      "getUserInfo",
      "userUpdate",
      "deleteUser",
    ]),
    onSubmit() {
      console.log(">>> onSubmit!!");
      // this will be called only after form is valid. You can do api call here to login
      updateProfile();
    },
    async updateProfile() {
      alert("Your data: " + JSON.stringify(this.umodel));
      this.umodel.userid = this.userInfo.userid;
      await this.userUpdate(this.umodel);
      await this.userConfirm(this.umodel);
      let token = sessionStorage.getItem("access-token");
      await this.getUserInfo(token);
    },
    async OnDeleteUser() {
      alert("정말 탈퇴하시겠습니까?");
      let token = sessionStorage.getItem("access-token");
      await this.deleteUser(token);
      this.$router.push({ name: "dashboard" });
    },
  },
};
</script>
<style></style>
