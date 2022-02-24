import Vue from "vue";
import Vuex from "vuex";
import http from "@/util/http-common.js";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

import memberStore from "./modules/memberStore.js";
import houseStore from "./modules/houseStore.js";
import interestStore from "./modules/interestStore.js";

const store = new Vuex.Store({
  modules: {
    memberStore,
    houseStore,
    interestStore,
  },
  plugins: [
    createPersistedState({
      // 브라우저 종료 시 제거하기 위해 localStrage가 아닌 sessionStorage로 변경.
      storage: sessionStorage,
    }),
  ],
});

export default store;
