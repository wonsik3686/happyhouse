<template>
  <div>
    <b-list-group v-if="deals && deals.length != 0" class="table-flush">
      <b-row>
        <b-col>
          <house-deal-row
            v-for="(deal, index) in deals"
            :key="index"
            :deal="deal"
          />
        </b-col>
      </b-row>
    </b-list-group>
    <b-list-group v-else-if="rents && rents.length != 0" class="table-flush">
      <b-row>
        <b-col>
          <house-rent-row
            v-for="(rent, index) in rents"
            :key="index"
            :rent="rent"
          />
        </b-col>
      </b-row>
    </b-list-group>
    <b-list-group v-else class="bv-example-row mt-3">
      <b-row>
        <b-col><b-alert show>검색된 목록이 없습니다.</b-alert></b-col>
      </b-row>
    </b-list-group>
    <b-pagination
      v-model="currentPage"
      :total-rows="totalPage"
      :per-page="perPage"
      align="center"
      @page-click="pageClick"
    ></b-pagination>
  </div>
</template>

<script>
import HouseDealRow from "@/views/HouseTable/HouseDealRow.vue";
import HouseRentRow from "@/views/HouseTable/HouseRentRow.vue";
import http from "@/util/http-common";
import { mapGetters, mapActions } from "vuex";
export default {
  name: "HouseList",
  components: {
    HouseDealRow,
    HouseRentRow,
  },
  data() {
    return {
      currentPage: 1,
      perPage: 10,
      totalPage: "",
      paramList: [],
    };
  },
  created() {
    this.getTotPage();
  },
  computed: {
    ...mapGetters("houseStore", {
      deals: "getDealList",
      rents: "getRentList",
      type: "getType",
      pay: "getPay",
      sidoCode: "getSidoCode",
      gugunCode: "getGugunCode",
      dongCode: "getDongCode",
      dongName: "getdongName",
    }),
  },
  watch: {
    deals: function () {
      this.getTotPage();
    },
    rents: function () {
      this.getTotPage();
    },
  },
  methods: {
    ...mapActions("houseStore", [
      "setType",
      "setPay",
      "setSidoCode",
      "setGugunCode",
      "setDong",
      "getAptDealList",
      "getAptRentList",
      "getHomeDealList",
      "getHomeRentList",
      "getOfficeDealList",
      "getOfficeRentList",
    ]),

    pageClick: function (button, page) {
      this.currentPage = page;
      this.sendKeyword();
    },
    sendKeyword() {
      /* 아파트 */
      if (this.sidoCode && this.type == "apart" && this.pay == "deal") {
        // 매매
        this.paramList = [this.gugunCode, this.dongName, this.currentPage];
        this.getAptDealList(this.paramList);
      } else if (this.sidoCode && this.type == "apart" && this.pay == "rent") {
        // 월세
        this.paramList = [1, this.gugunCode, this.dongName, this.currentPage];
        this.getAptRentList(this.paramList);
      } else if (
        this.sidoCode &&
        this.type == "apart" &&
        this.pay == "deposit"
      ) {
        // 전세
        this.paramList = [2, this.gugunCode, this.dongName, this.currentPage];
        this.getAptRentList(this.paramList);
      } else if (this.sidoCode && this.type == "house" && this.pay == "deal") {
        /* 연립 다세대 */
        // 매매
        this.paramList = [this.gugunCode, this.dongName, this.currentPage];
        this.getHomeDealList(this.paramList);
      } else if (this.sidoCode && this.type == "house" && this.pay == "rent") {
        // 월세
        this.paramList = [1, this.gugunCode, this.dongName, this.currentPage];
        this.getHomeRentList(this.paramList);
      } else if (
        this.sidoCode &&
        this.type == "house" &&
        this.pay == "deposit"
      ) {
        // 전세
        this.paramList = [2, this.gugunCode, this.dongName, this.currentPage];
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
    },
    getTotPage() {
      var url = "";
      // console.log(this.sidoCode);
      // console.log(this.type);
      // console.log(this.pay);
      if (this.sidoCode == 0) {
        this.totalPage = 0;
        return;
      }
      /* 아파트 */
      if (this.sidoCode && this.type == "apart" && this.pay == "deal") {
        // 매매
        url = "/house/getTotCntAptDeal/" + this.gugunCode + "/" + this.dongName;
      } else if (this.sidoCode && this.type == "apart" && this.pay == "rent") {
        // 월세
        url =
          "/house/getTotCntAptRent/" +
          1 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      } else if (
        this.sidoCode &&
        this.type == "apart" &&
        this.pay == "deposit"
      ) {
        // 전세
        url =
          "/house/getTotCntAptRent/" +
          2 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      } else if (this.sidoCode && this.type == "house" && this.pay == "deal") {
        /* 연립 다세대 */
        // 매매
        url =
          "/house/getTotCntHomeDeal/" + this.gugunCode + "/" + this.dongName;
      } else if (this.sidoCode && this.type == "house" && this.pay == "rent") {
        // 월세
        url =
          "/house/getTotCntHomeRent/" +
          1 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      } else if (
        this.sidoCode &&
        this.type == "house" &&
        this.pay == "deposit"
      ) {
        // 전세
        url =
          "/house/getTotCntHomeRent/" +
          2 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      } else if (this.sidoCode && this.type == "office" && this.pay == "deal") {
        /* 오피스텔 */
        // 매매
        url =
          "/house/getTotCntOfficeDeal/" + this.gugunCode + "/" + this.dongName;
      } else if (this.sidoCode && this.type == "office" && this.pay == "rent") {
        // 월세
        url =
          "/house/getTotCntOfficeRent/" +
          1 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      } else if (
        this.sidoCode &&
        this.type == "office" &&
        this.pay == "deposit"
      ) {
        // 전세
        url =
          "/house/getTotCntOfficeRent/" +
          2 +
          "/" +
          this.gugunCode +
          "/" +
          this.dongName;
      }

      http
        .get(url)
        .then((response) => {
          this.totalPage = response.data;
        })
        .catch(() => {
          console.log("페이지 처리 실패");
        });
    },
  },
};
</script>

<style scoped></style>
