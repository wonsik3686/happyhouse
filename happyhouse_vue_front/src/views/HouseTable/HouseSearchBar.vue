<template>
  <div class="search_container">
    <b-row class="mb-3">
      <b-col cols="" align="left">
        <b-button-group>
          <b-button variant="primary" value="apart" @click="setHouseType"
            >아파트</b-button
          >
          <b-button variant="primary" value="house" @click="setHouseType"
            >빌라</b-button
          >
          <b-button variant="primary" value="office" @click="setHouseType"
            >오피스텔</b-button
          >
        </b-button-group>
      </b-col>
      <!-- <b-col cols="3"></b-col> -->

      <b-col cols="5" align="left">
        <b-button-group>
          <b-button variant="success" value="deal" @click="setHousePay"
            >매매</b-button
          >
          <b-button variant="success" value="deposit" @click="setHousePay"
            >전세</b-button
          >
          <b-button variant="success" value="rent" @click="setHousePay"
            >월세</b-button
          >
        </b-button-group>
      </b-col>
    </b-row>

    <b-row class="ml-2">
      <b-col class="sm-3">
        <b-form-select v-model="sidoCode" @change="gugunList">
          <option value="" disabled selected>도,광역시</option>
          <option
            v-for="(sido, index) in sidos"
            :key="index"
            :value="sido.value"
          >
            {{ sido.text }}
          </option>
        </b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select v-model="gugunCode" @change="dongList">
          <option value="" disabled selected>구,군</option>
          <option
            v-for="(gugun, index) in guguns"
            :key="index"
            :value="gugun.value"
          >
            {{ gugun.text }}
          </option>
        </b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select v-model="dongCode" @change="setDongCode_Method">
          <option value="" disabled selected>동</option>
          <option
            v-for="(dong, index) in dongs"
            :key="index"
            :value="dong.value"
          >
            <!-- :value="{ code: dong.value, text: dong.name }" -->
            {{ dong.text }}
          </option>
        </b-form-select>
        <!-- <b-form-select
          v-model="dongCode"
          :options="dongs"
          @change="setDongCode_Method"
        ></b-form-select> -->
      </b-col>
      <b-col cols="" align="left">
        <b-button variant="outline-warning" @click="sendSearch">검색</b-button>
      </b-col>
    </b-row>
    <b-row class="ml-2 mt-3">
      <b-col class="sm-3" align="left">
        <b-button variant="outline-warning" @click.prevent="setInterest"
          >관심지역 등록</b-button
        >
      </b-col>
      <b-col class="sm-3">
        <small>관심지역 선택</small>
        <b-form-select v-model="selectedInterest" @change="sendInterestSearch">
          <option value="" disabled selected>관심지역</option>
          <option
            v-for="(inter, index) in interests"
            :key="index"
            :value="index"
          >
            {{ inter.sido }} {{ inter.gugun }} {{ inter.dong }}
          </option>
        </b-form-select>
      </b-col>
    </b-row>
  </div>
</template>

<script>
import { mapState, mapActions, mapMutations, mapGetters } from "vuex";
const houseStore = "houseStore";
const interestStore = "interestStore";
const memberStore = "memberStore";

export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
      dongName: "",
      type: "",
      pay: "",
      paramList: [],
      sname: "",
      gname: "",
      dname: "",
      interestLoc: {
        dong: "",
        gugun: "",
        sido: "",
        userid: "",
      },
      selectedInterest: 0,
    };
  },
  computed: {
    ...mapState(houseStore, [
      "sidos",
      "guguns",
      "dongs",
      "sidoName",
      "gugunName",
    ]),
    ...mapState(interestStore, ["interests", "isSRIL"]),
    ...mapState(memberStore, ["userInfo", "isSRIL"]),

    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    //this.CLEAR_SIDO_LIST();
    this.sidoCode = this.getSidoCode();
    this.gugunCode = this.getGugunCode();
    this.dongCode = this.getDongCode();
    this.type = this.getType();
    this.pay = this.getPay();

    this.getSido();
    if (this.sidoCode == "") {
      return;
    }

    this.getInterestLocation(this.userInfo.userid);
  },
  methods: {
    ...mapActions(houseStore, [
      "getSido",
      "getGugun",
      "getDong",
      "setType",
      "setPay",
      "setSidoCode",
      "setGugunCode",
      "setDongCode",
      "getAptDealList",
      "getAptRentList",
      "getHomeDealList",
      "getHomeRentList",
      "getOfficeDealList",
      "getOfficeRentList",
      "setSidoName",
      "setGugunName",
      "setDongName",
    ]),
    ...mapActions(interestStore, [
      "setInterestLocation",
      "getInterestLocation",
    ]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    ...mapGetters(houseStore, [
      "getType",
      "getPay",
      "getSidoCode",
      "getGugunCode",
      "getDongCode",
    ]),
    // ...mapState(houseStore, ["sidoName", "gugunName", "dongName"]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      this.setSidoCode(this.sidoCode);
      //console.log(this.sidoCode);
      //this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      this.setGugunCode(this.gugunCode);
      //console.log(this.gugunCode);
      //this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    setDongCode_Method() {
      this.dongName = this.setDongCode(this.dongCode);
    },
    async setInterest() {
      for (var i = 0; i < this.sidos.length; i++) {
        if (this.sidos[i].value === this.sidoCode) {
          this.setSidoName(this.sidos[i].text);
        }
      }
      for (var i = 0; i < this.guguns.length; i++) {
        if (this.guguns[i].value === this.gugunCode) {
          this.setGugunName(this.guguns[i].text);
        }
      }
      for (var i = 0; i < this.dongs.length; i++) {
        if (this.dongs[i].value === this.dongCode) {
          this.dongName = this.dongs[i].text;
          this.setDongName(this.dongs[i].text);
        }
      }
      this.interestLoc.sido = this.sidoName;
      this.interestLoc.gugun = this.gugunName;
      this.interestLoc.dong = this.dongName;
      this.interestLoc.userid = this.userInfo.userid;

      await this.setInterestLocation(this.interestLoc);
      await this.getInterestLocation(this.userInfo.userid);
    },
    async sendInterestSearch() {
      for (var i = 0; i < this.sidos.length; i++) {
        if (this.sidos[i].text === this.interests[this.selectedInterest].sido) {
          this.sidoCode = this.sidos[i].value;
          console.log(this.sidoCode);
        }
      }
      await this.setSidoCode(this.sidoCode);
      for (var i = 0; i < this.guguns.length; i++) {
        if (
          this.guguns[i].text === this.interests[this.selectedInterest].gugun
        ) {
          this.gugunCode = this.guguns[i].value;
          console.log(this.gugunCode);
        }
      }
      await this.setGugunCode(this.gugunCode);
      this.dongCode = null;
      if (this.gugunCode) await this.getDong(this.gugunCode);
      console.log(this.dongs);
      for (var i = 0; i < this.dongs.length; i++) {
        if (this.dongs[i].text === this.interests[this.selectedInterest].dong) {
          this.dongCode = this.dongs[i].value;
          console.log(this.dongCode);
        }
      }
      this.dongName = await this.setDongCode(this.dongCode);
      await this.setDongCode(this.dongCode);
      await this.sendSearch();
    },
    sendSearch() {
      // console.log("sidoCode = ", this.sidoCode);
      // console.log("gugunCode = ", this.gugunCode);
      // console.log("dongCode = ", this.dongCode);
      if (this.sidoCode == "" || this.gugunCode == "" || this.dongCode == "") {
        alert("도/군/동을 입력해주세요");
        return;
      } //디폴트 아파트 // 매매
      if (this.sidoCode == "") {
        this.setSidoCode(11);
      }
      if (this.type == "") {
        this.type = "apart";
      }
      if (this.pay == "") {
        this.pay = "deal";
      }
      for (var i = 0; i < this.sidos.length; i++) {
        if (this.sidos[i].value === this.sidoCode) {
          this.setSidoName(this.sidos[i].text);
        }
      }
      for (var i = 0; i < this.guguns.length; i++) {
        if (this.guguns[i].value === this.gugunCode) {
          this.setGugunName(this.guguns[i].text);
        }
      }
      for (var i = 0; i < this.dongs.length; i++) {
        if (this.dongs[i].value === this.dongCode) {
          this.dongName = this.dongs[i].text;
          this.setDongName(this.dongs[i].text);
        }
      }
      /* 아파트 */
      if (this.sidoCode && this.type == "apart" && this.pay == "deal") {
        // 매매
        //console.log("dongName=>", this.dongName);
        this.paramList = [this.gugunCode, this.dongName, 1];
        this.getAptDealList(this.paramList);
      } else if (this.sidoCode && this.type == "apart" && this.pay == "rent") {
        // 월세
        this.paramList = [1, this.gugunCode, this.dongName, 1];
        this.getAptRentList(this.paramList);
      } else if (
        this.sidoCode &&
        this.type == "apart" &&
        this.pay == "deposit"
      ) {
        // 전세
        this.paramList = [2, this.gugunCode, this.dongName, 1];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == "house" && this.pay == "deal") {
        /* 연립 다세대 */
        // 매매
        this.paramList = [this.gugunCode, this.dongName, 1];
        this.getHomeDealList(this.paramList);
      } else if (this.sidoCode && this.type == "house" && this.pay == "rent") {
        // 월세
        this.paramList = [1, this.gugunCode, this.dongName, 1];
        this.getHomeRentList(this.paramList);
      } else if (
        this.sidoCode &&
        this.type == "house" &&
        this.pay == "deposit"
      ) {
        // 전세
        this.paramList = [2, this.gugunCode, this.dongName, 1];
        this.getHomeRentList(this.paramList);
      } else if (this.sidoCode && this.type == "office" && this.pay == "deal") {
        /* 오피스텔 */
        // 매매
        this.paramList = [this.gugunCode, this.dongName, 1];
        this.getOfficeDealList(this.paramList);
      } else if (this.sidoCode && this.type == "office" && this.pay == "rent") {
        // 월세
        this.paramList = [1, this.gugunCode, this.dongName, 1];
        this.getOfficeRentList(this.paramList);
      } else if (
        this.sidoCode &&
        this.type == "office" &&
        this.pay == "deposit"
      ) {
        // 전세
        this.paramList = [2, this.gugunCode, this.dongName, 1];
        this.getOfficeRentList(this.paramList);
      }
      this.$router
        .push({
          name: "houseList",
        })
        .catch(() => {});
    },
    setHouseType: function (event) {
      var thisBtn = event.currentTarget;
      thisBtn.classList.add("active");
      let sibling = thisBtn.parentNode.firstChild;

      while (sibling) {
        if (sibling.nodeType === 1 && sibling !== thisBtn) {
          sibling.classList.remove("active");
        }
        sibling = sibling.nextSibling;
      }
      this.type = event.currentTarget.value;
      // store에 저장
      this.setType(this.type);
    },
    setHousePay: function (event) {
      var thisBtn = event.currentTarget;
      thisBtn.classList.add("active");
      let sibling = thisBtn.parentNode.firstChild;

      while (sibling) {
        if (sibling.nodeType === 1 && sibling !== thisBtn) {
          sibling.classList.remove("active");
        }
        sibling = sibling.nextSibling;
      }
      this.pay = event.currentTarget.value;
      // store에 저장
      this.setPay(this.pay);
    },
  },
};
</script>

<style></style>
