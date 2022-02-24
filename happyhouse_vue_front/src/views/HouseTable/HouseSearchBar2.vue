<template>
  <b-row class="search_container">
    <b-row class="mb-3">
      <b-col cols="" align="left">
        <b-button-group>
          <b-button variant="warning" value="apart" @click="setHouseType"
            >아파트</b-button
          >
          <b-button variant="warning" value="house" @click="setHouseType"
            >빌라</b-button
          >
          <b-button variant="warning" value="office" @click="setHouseType"
            >오피스텔</b-button
          >
        </b-button-group>
      </b-col>
      <!-- <b-col cols="3"></b-col> -->

      <b-col cols="5" align="left">
        <b-button-group>
          <b-button variant="warning" value="deal" @click="setHousePay"
            >매매</b-button
          >
          <b-button variant="warning" value="deposit" @click="setHousePay"
            >전세</b-button
          >
          <b-button variant="warning" value="rent" @click="setHousePay"
            >월세</b-button
          >
        </b-button-group>
      </b-col>
    </b-row>

    <b-row class="ml-2">
      <b-col class="sm-3">
        <b-form-select
          v-model="sidoCode"
          :options="sidos"
          @change="gugunList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="gugunCode"
          :options="guguns"
          @change="dongList"
        ></b-form-select>
      </b-col>
      <b-col class="sm-3">
        <b-form-select
          v-model="dongCode"
          :options="dongs"
          @change="searchApt"
        ></b-form-select>
      </b-col>
    </b-row>
  </b-row>
</template>

<script>
import { mapState, mapActions, mapMutations } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseSearchBar",
  data() {
    return {
      sidoCode: null,
      gugunCode: null,
      dongCode: null,
    };
  },
  computed: {
    ...mapState(houseStore, ["sidos", "guguns", "dongs", "houses"]),
    // sidos() {
    //   return this.$store.state.sidos;
    // },
  },
  created() {
    // this.$store.dispatch("getSido");
    // this.sidoList();
    this.CLEAR_SIDO_LIST();

    this.getSido();
  },
  methods: {
    ...mapActions(houseStore, [
      "getSido",
      "getGugun",
      "getDong",
      "getHouseList",
    ]),
    ...mapMutations(houseStore, [
      "CLEAR_SIDO_LIST",
      "CLEAR_GUGUN_LIST",
      "CLEAR_DONG_LIST",
    ]),
    // sidoList() {
    //   this.getSido();
    // },
    gugunList() {
      //console.log(this.sidoCode);
      this.CLEAR_GUGUN_LIST();
      this.gugunCode = null;
      if (this.sidoCode) this.getGugun(this.sidoCode);
    },
    dongList() {
      //console.log(this.gugunCode);
      this.CLEAR_DONG_LIST();
      this.dongCode = null;
      if (this.gugunCode) this.getDong(this.gugunCode);
    },
    searchApt() {
      if (this.dongCode) this.getHouseList(this.dongCode);
    },
  },
};
</script>

<style></style>
