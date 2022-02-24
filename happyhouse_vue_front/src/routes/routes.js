import DashboardLayout from "@/views/Layout/DashboardLayout.vue";
import AuthLayout from "@/views/Pages/AuthLayout.vue";

import NotFound from "@/views/NotFoundPage.vue";
import router from "./router";

import store from "@/store/index.js";

// https://router.vuejs.org/kr/guide/advanced/navigation-guards.html
const onlyAuthUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const getUserInfo = store._actions["memberStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo === null) {
    alert("로그인이 필요한 페이지입니다..");
    // next({ name: "SignIn" });
    router.push({ name: "login" });
  } else {
    console.log("로그인 했다.");
    next();
  }
};

const onlyAdminUser = async (to, from, next) => {
  // console.log(store);
  const checkUserInfo = store.getters["memberStore/checkUserInfo"];
  const getUserInfo = store._actions["memberStore/getUserInfo"];
  let token = sessionStorage.getItem("access-token");
  if (checkUserInfo == null && token) {
    await getUserInfo(token);
  }
  if (checkUserInfo.isAdmin !== "y") {
    alert("관리자 권한이 필요합니다.");
    // next({ name: "SignIn" });
    router.push({ name: "dashboard" });
  } else {
    console.log("관리자 입니다.");
    next();
  }
};

const routes = [
  {
    path: "/",
    redirect: "dashboard",
    component: DashboardLayout,
    children: [
      {
        path: "/dashboard",
        name: "dashboard",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Dashboard.vue"),
      },
      {
        path: "/icons",
        name: "icons",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Icons.vue"),
      },
      {
        path: "/profile",
        name: "profile",
        beforeEnter: onlyAuthUser,
        component: () =>
          import(
            /* webpackChunkName: "demo" */ "../views/Pages/UserProfile.vue"
          ),
      },
      {
        path: "/chart",
        name: "chart",
        beforeEnter: onlyAdminUser,
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Chart.vue"),
      },
      {
        path: "/house",
        name: "house",
        // redirect: "/house/",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/HouseTable.vue"),
        children: [
          {
            path: "/houseList",
            name: "houseList",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/HouseTable/HouseList.vue"
              ),
          },
          {
            path: "housedetail",
            name: "HouseDetail",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/HouseTable/HouseDetail.vue"
              ),
          },
          {
            path: "rentdetail",
            name: "RentDetail",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/HouseTable/RentDetail.vue"
              ),
          },
        ],
      },
      {
        path: "/tables",
        name: "tables",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/RegularTables.vue"),
      },
      {
        path: "/notice",
        name: "notice",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Notice.vue"),
        redirect: "/notice/list",
        children: [
          {
            path: "list",
            name: "NoticeList",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/NoticeBoard/NoticeList.vue"
              ),
          },
          {
            path: "write",
            name: "NoticeWrite",
            beforeEnter: onlyAdminUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/NoticeBoard/NoticeWrite.vue"
              ),
          },
          {
            path: "modify/:no",
            name: "NoticeModify",
            beforeEnter: onlyAdminUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/NoticeBoard/NoticeModify.vue"
              ),
          },
          {
            path: "view/:no",
            name: "NoticeView",
            beforeEnter: onlyAuthUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/NoticeBoard/NoticeView.vue"
              ),
            // children: [
            //   {
            //     path: "writeanswer/:no",
            //     name: "QnaAnswerWriteForm",
            //     component: () =>
            //       import(
            //         /* webpackChunkName: "demo" */ "../views/QnaBoard/child/QnaAnswerWriteForm.vue"
            //       ),
            //   },
            // ],
          },
          {
            path: "delete/:no",
            name: "NoticeDelete",
            beforeEnter: onlyAdminUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/NoticeBoard/NoticeDelete.vue"
              ),
          },
        ],
      },
      {
        path: "/qna",
        name: "qna",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/QnaBoard.vue"),
        redirect: "/qna/list",
        children: [
          {
            path: "list",
            name: "QnaList",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaList.vue"
              ),
          },
          {
            path: "write",
            name: "QnaWrite",
            beforeEnter: onlyAuthUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaWrite.vue"
              ),
          },
          {
            path: "modify/:no",
            name: "QnaModify",
            beforeEnter: onlyAuthUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaModify.vue"
              ),
          },
          {
            path: "view/:no",
            name: "QnaView",
            beforeEnter: onlyAuthUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaView.vue"
              ),
            // children: [
            //   {
            //     path: "writeanswer/:no",
            //     name: "QnaAnswerWriteForm",
            //     component: () =>
            //       import(
            //         /* webpackChunkName: "demo" */ "../views/QnaBoard/child/QnaAnswerWriteForm.vue"
            //       ),
            //   },
            // ],
          },
          {
            path: "delete/:no",
            name: "QnaDelete",
            beforeEnter: onlyAuthUser,
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaDelete.vue"
              ),
          },
          {
            path: "deleteanswer/:no",
            name: "QnaAnswerDelete",
            component: () =>
              import(
                /* webpackChunkName: "demo" */ "../views/QnaBoard/QnaAnswerDelete.vue"
              ),
          },
        ],
      },
    ],
  },
  {
    path: "/",
    redirect: "login",
    component: AuthLayout,
    children: [
      {
        path: "/login",
        name: "login",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Pages/Login.vue"),
      },
      {
        path: "/register",
        name: "register",
        component: () =>
          import(/* webpackChunkName: "demo" */ "../views/Pages/Register.vue"),
      },
      { path: "*", component: NotFound },
    ],
  },
];

export default routes;
