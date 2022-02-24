<template>
  <div class="wrapper">
    <notifications></notifications>
    <side-bar
      logo="https://user-images.githubusercontent.com/70436955/142898700-2b5af92f-46bc-4fb1-a317-ab9754e577fe.png"
    >
      <template slot="links">
        <sidebar-item
          :link="{
            name: '홈',
            path: '/dashboard',
            icon: 'ni ni-shop text-primary',
          }"
        >
        </sidebar-item>

        <!-- <sidebar-item
          :link="{
            name: 'Icons',
            path: '/icons',
            icon: 'ni ni-planet text-blue',
          }"
        >
        </sidebar-item> -->

        <sidebar-item
          :link="{
            name: '지도',
            path: '/house',
            icon: 'ni ni-building text-blue',
          }"
        >
        </sidebar-item>

        <!-- <sidebar-item
          :link="{
            name: '차트',
            path: '/chart',
            icon: 'ni ni-chart-bar-32 text-navy',
          }"
        >
        </sidebar-item> -->

        <sidebar-item
          :link="{
            name: '회원 프로필',
            path: '/profile',
            icon: 'ni ni-single-02 text-yellow',
          }"
        >
        </sidebar-item>

        <!-- <sidebar-item
          :link="{
            name: 'Tables',
            path: '/tables',
            icon: 'ni ni-bullet-list-67 text-red',
          }"
        >
        </sidebar-item> -->

        <!-- <sidebar-item
          :link="{
            name: 'Login',
            path: '/login',
            icon: 'ni ni-key-25 text-info',
          }"
        >
        </sidebar-item> -->

        <!-- <sidebar-item
          :link="{
            name: 'Register',
            path: '/register',
            icon: 'ni ni-circle-08 text-pink',
          }"
        >
        </sidebar-item> -->

        <sidebar-item
          :link="{
            name: '공지사항',
            path: '/notice',
            icon: 'ni ni-notification-70 text-orange',
          }"
        >
        </sidebar-item>

        <sidebar-item
          :link="{
            name: 'Q & A',
            path: '/qna',
            icon: 'ni ni-chat-round text-purple',
          }"
        >
        </sidebar-item>
      </template>

      <template slot="links-after">
        <hr class="my-3" />
        <h6 class="navbar-heading p-0 text-muted">Happy House</h6>

        <b-nav class="navbar-nav mb-md-3">
          <b-nav-item
            href="https://www.creative-tim.com/learning-lab/bootstrap-vue/quick-start/argon-dashboard"
          >
            <i class="ni ni-spaceship"></i>
            <b-nav-text class="p-0">Getting started</b-nav-text>
          </b-nav-item>
          <b-nav-item
            href="https://www.creative-tim.com/learning-lab/bootstrap-vue/colors/argon-dashboard"
          >
            <i class="ni ni-palette"></i>
            <b-nav-text class="p-0">Foundation</b-nav-text>
          </b-nav-item>
          <b-nav-item
            href="https://www.creative-tim.com/learning-lab/bootstrap-vue/avatar/argon-dashboard"
          >
            <i class="ni ni-ui-04"></i>
            <b-nav-text class="p-0">Components</b-nav-text>
          </b-nav-item>
        </b-nav>
      </template>
    </side-bar>
    <div class="main-content">
      <dashboard-navbar :type="$route.meta.navbarType"></dashboard-navbar>

      <div @click="$sidebar.displaySidebar(false)">
        <fade-transition :duration="200" origin="center top" mode="out-in">
          <!-- your content here -->
          <router-view></router-view>
        </fade-transition>
      </div>
      <content-footer v-if="!$route.meta.hideFooter"></content-footer>
    </div>
  </div>
</template>
<script>
/* eslint-disable no-new */
import PerfectScrollbar from "perfect-scrollbar";
import "perfect-scrollbar/css/perfect-scrollbar.css";

function hasElement(className) {
  return document.getElementsByClassName(className).length > 0;
}

function initScrollbar(className) {
  if (hasElement(className)) {
    new PerfectScrollbar(`.${className}`);
  } else {
    // try to init it later in case this component is loaded async
    setTimeout(() => {
      initScrollbar(className);
    }, 100);
  }
}

import DashboardNavbar from "./DashboardNavbar.vue";
import ContentFooter from "./ContentFooter.vue";
import DashboardContent from "./Content.vue";
import { FadeTransition } from "vue2-transitions";

import { mapState } from "vuex";

import store from "@/store/index.js";
const memberStore = "memberStore";

export default {
  components: {
    DashboardNavbar,
    ContentFooter,
    DashboardContent,
    FadeTransition,
  },
  data() {
    return {
      // isAdmin: false,
    };
  },
  // async updated() {
  //   console.log("updated");
  //   const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  //   const getUserInfo = store._actions["memberStore/getUserInfo"];
  //   let token = sessionStorage.getItem("access-token");
  //   if (checkUserInfo == null && token) {
  //     await getUserInfo(token);
  //   }
  //   if (checkUserInfo.isAdmin !== "y") {
  //     this.isAdmin = false;
  //   } else {
  //     this.isAdmin = true;
  //   }
  // },
  computed: {
    ...mapState(memberStore, ["isAdmin"]),
  },
  methods: {
    initScrollbar() {
      let isWindows = navigator.platform.startsWith("Win");
      if (isWindows) {
        initScrollbar("sidenav");
      }
    },
  },
  mounted() {
    this.initScrollbar();
  },
};
</script>
<style lang="scss"></style>
