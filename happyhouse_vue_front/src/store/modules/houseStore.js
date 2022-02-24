//import { sidoList, gugunList, houseList } from "@/api/house.js";
import http from "@/util/http-common.js";

const houseStore = {
  namespaced: true,
  state: {
    sidos: [],
    guguns: [],
    dongs: [],
    houses: [],
    house: null,
    houseDetails: [],
    //
    type: "deal",
    pay: "apart",
    sidoCode: "",
    gugunCode: "",
    dongCode: "",
    deals: [],
    deal: {},
    rents: [],
    rent: {},
    sidoName: "",
    gugunName: "",
    dongName: "",
  },

  getters: {
    getsidoName(state) {
      return state.sidoName;
    },
    getgugunName(state) {
      return state.gugunName;
    },
    getdongName(state) {
      return state.dongName;
    },
    getDealList(state) {
      return state.deals;
    },
    getDeal(state) {
      return state.deal;
    },
    getRentList(state) {
      return state.rents;
    },
    getRent(state) {
      return state.rent;
    },
    getType(state) {
      return state.type;
    },
    getPay(state) {
      return state.pay;
    },
    getSidoCode(state) {
      return state.sidoCode;
    },
    getGugunCode(state) {
      return state.gugunCode;
    },
    getDongCode(state) {
      return state.dongCode;
    },
    getPosition(state) {
      if (state.pay == "rent" || state.pay == "deposit") {
        console.log("123");
        return state.rents;
      } else {
        console.log("456");
        return state.deals;
      }
    },
  },

  mutations: {
    SET_SIDO_LIST(state, sidos) {
      state.sidos = [];
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      state.guguns = [];
      guguns.forEach((gugun) => {
        state.guguns.push({ value: gugun.gugunCode, text: gugun.gugunName });
      });
    },
    SET_DONG_LIST(state, dongs) {
      state.dongs = [];
      dongs.forEach((dong) => {
        state.dongs.push({ value: dong.dongCode, text: dong.dongName });
      });
    },
    CLEAR_SIDO_LIST(state) {
      state.sidos = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_GUGUN_LIST(state) {
      state.guguns = [{ value: null, text: "선택하세요" }];
    },
    CLEAR_DONG_LIST(state) {
      state.dongs = [{ value: null, text: "선택하세요" }];
    },
    SET_HOUSE_LIST(state, houses) {
      state.houses = houses;
    },
    SET_HOUSEDETAIL_LIST(state, housedetails) {
      state.houseDetails = housedetails;
    },
    SET_DETAIL_HOUSE(state, house) {
      state.house = house;
    },
    SET_SIDO_NAME(state, sidoName) {
      state.sidoName = sidoName;
    },
    SET_GUGUN_NAME(state, gugunName) {
      state.gugunName = gugunName;
    },
    SET_DONG_NAME(state, dongName) {
      state.dongName = dongName;
    },
    resetState(state) {
      Object.assign(state, getDefaultState());
    },
    resetStateAll(state) {
      Object.assign(state, getDefaultState());
      state.type = "";
      state.pay = "";
      state.sidoCode = "";
      state.gugunCode = "";
      state.dongCode = "";
    },
    SET_SELECT_DEAL(state, deal) {
      state.deal = deal;
    },
    SET_SELECT_RENT(state, rent) {
      state.rent = rent;
    },

    SET_TYPE(state, type) {
      state.type = type;
    },
    SET_PAY(state, pay) {
      state.pay = pay;
    },
    SET_SIDO_CODE(state, sidoCode) {
      state.sidoCode = sidoCode;
    },
    SET_GUGUN_CODE(state, gugunCode) {
      state.gugunCode = gugunCode;
    },
    SET_DONG_CODE(state, dongCode) {
      state.dongCode = dongCode;
    },
    GET_APT_DEAL_LIST(state, deals) {
      state.deals = deals;
      state.rent = [];
    },
    GET_APT_RENT_LIST(state, rents) {
      state.rents = rents;
      state.deals = [];
    },
    GET_HOME_DEAL_LIST(state, deals) {
      state.deals = deals;
      state.rent = [];
    },
    GET_HOME_RENT_LIST(state, rents) {
      state.rents = rents;
      state.deals = [];
    },
    GET_OFFICE_DEAL_LIST(state, deals) {
      state.deals = deals;
      state.rent = [];
    },
    GET_OFFICE_RENT_LIST(state, rents) {
      state.rents = rents;
      state.deals = [];
    },
  },

  actions: {
    resetCartState({ commit }) {
      commit("resetState");
    },
    resetCartStateAll({ commit }) {
      commit("resetStateAll");
    },
    setSelectDeal({ commit }, deal) {
      commit("SET_SELECT_DEAL", deal);
    },
    setSelectRent({ commit }, rent) {
      commit("SET_SELECT_RENT", rent);
    },
    /* 타입 설정 */
    setType({ commit }, type) {
      commit("SET_TYPE", type);
    },
    setPay({ commit }, pay) {
      commit("SET_PAY", pay);
    },
    /* 지역 설정 */
    setSidoCode({ commit }, sidoCode) {
      commit("SET_SIDO_CODE", sidoCode);
    },
    setGugunCode({ commit }, gugunCode) {
      commit("SET_GUGUN_CODE", gugunCode);
    },
    setDongCode({ commit }, dongCode) {
      commit("SET_DONG_CODE", dongCode);
    },
    setSidoName({ commit }, sidoName) {
      commit("SET_SIDO_NAME", sidoName);
    },
    setGugunName({ commit }, gugunName) {
      commit("SET_GUGUN_NAME", gugunName);
    },
    setDongName({ commit }, dongName) {
      commit("SET_DONG_NAME", dongName);
    },
    getSido({ commit }) {
      http
        .get(`/map/sido`)
        .then((response) => {
          // console.log(data)
          commit("SET_SIDO_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getGugun({ commit }, sidoCode) {
      const params = { sido: sidoCode };
      http
        .get(`/map/gugun`, { params })
        .then((response) => {
          // console.log(commit, response);
          commit("SET_GUGUN_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    getDong({ commit }, gugunCode) {
      const params = { gugun: gugunCode };
      http
        .get(`/map/dong`, { params })
        .then((response) => {
          //console.log(commit, response);
          commit("SET_DONG_LIST", response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    // getHouseList({ commit }, dongCode) {
    //   const params = { dong: dongCode };
    //   http
    //     .get(`/map/apt`, { params })
    //     .then((response) => {
    //       //console.log(commit, response);
    //       commit("SET_HOUSE_LIST", response.data);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // },

    // gethousedetails({ commit }, house) {
    //   // 나중에 house.일련번호를 이용하여 API 호출

    //   const params = { aptCode: house.aptCode };
    //   http
    //     .get(`/map/deal`, { params })
    //     .then((response) => {
    //       //console.log(commit, response);
    //       commit("SET_HOUSEDETAIL_LIST", response.data);
    //     })
    //     .catch((error) => {
    //       console.log(error);
    //     });
    // },
    // detailHouse({ commit }, house) {
    //   // 나중에 house.일련번호를 이용하여 API 호출
    //   commit("SET_DETAIL_HOUSE", house);
    // },
    /* 아파트 */
    getAptDealList({ commit }, paramList) {
      http
        .get(
          "/house/aptDealList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2]
        )
        .then(({ data }) => {
          //console.log("data=> ", data);
          commit("GET_APT_DEAL_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getAptRentList({ commit }, paramList) {
      http
        .get(
          "/house/aptRentList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2] +
            "/" +
            paramList[3]
        )
        .then(({ data }) => {
          //console.log(data);
          commit("GET_APT_RENT_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    /* 연립 다세대 */
    getHomeDealList({ commit }, paramList) {
      http
        .get(
          "/house/homeDealList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2]
        )
        .then(({ data }) => {
          commit("GET_HOME_DEAL_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getHomeRentList({ commit }, paramList) {
      http
        .get(
          "/house/homeRentList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2] +
            "/" +
            paramList[3]
        )
        .then(({ data }) => {
          commit("GET_HOME_RENT_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    /* 오피스텔 */
    getOfficeDealList({ commit }, paramList) {
      http
        .get(
          "/house/officeDealList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2]
        )
        .then(({ data }) => {
          commit("GET_OFFICE_DEAL_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
    getOfficeRentList({ commit }, paramList) {
      http
        .get(
          "/house/officeRentList/" +
            paramList[0] +
            "/" +
            paramList[1] +
            "/" +
            paramList[2] +
            "/" +
            paramList[3]
        )
        .then(({ data }) => {
          commit("GET_OFFICE_RENT_LIST", data);
        })
        .catch(() => {
          alert("에러가 발생했습니다.");
        });
    },
  },
};

export default houseStore;
