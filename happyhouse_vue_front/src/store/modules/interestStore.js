import http from "@/util/http-common.js";
import { setInterest, getInterest } from "@/api/interest.js";

const interestStore = {
  namespaced: true,
  state: {
    interests: [],
    isSRIL: false,
  },

  mutations: {
    SET_INTEREST(state, interest) {
      state.interests = interest;
    },
    SET_ISSRIL(state, isSRIL) {
      state.isSRIL = isSRIL;
    },
  },

  actions: {
    async setInterestLocation({ commit }, location) {
      await setInterest(
        location,
        (response) => {
          if (response.data.message === "success") {
            console.log("관심지역 등록 성공");
            commit("SET_ISSRIL", true);
          } else {
            console.log("관심지역 등록 실패");
            commit("SET_ISSRIL", false);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
    async getInterestLocation({ commit }, userid) {
      await getInterest(
        userid,
        (response) => {
          //   if (response.data.message === "success") {
          //     console.log("관심지역 가져오기 성공");
          //     commit("SET_INTEREST", interests);
          //   } else {
          //     console.log(response);
          //     console.log("관심지역 가져오기 실패");
          //   }
          console.log("관심지역 가져오기 성공");
          commit("SET_INTEREST", response.data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default interestStore;
