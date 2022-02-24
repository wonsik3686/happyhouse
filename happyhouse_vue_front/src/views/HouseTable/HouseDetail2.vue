<template>
  <b-container class="bv-example-row">
    <!-- <b-row class="mb-2 mt-1">
      <b-col
        ><b-img :src="require('@/assets/joc.png')" fluid-grow></b-img
      ></b-col>
    </b-row> -->
    <b-row class="mt-4 mb-4">
      <b-col>
        <h1>건물명 : {{ house.aptName }}</h1>
      </b-col>
      <b-button variant="outline-warning" @click="goBack"
        >뒤로 돌아가기</b-button
      >
    </b-row>
    <b-row>
      <b-col>
        <b-alert show variant="info"
          >주소 :
          {{
            house.sidoName +
            " " +
            house.gugunName +
            " " +
            house.dongName +
            " " +
            house.jibun
          }}
        </b-alert>
      </b-col>
    </b-row>
    <!-- <b-row>
      <b-col>
        <b-alert show variant="warning">법정동 : {{ house.dongName }}</b-alert>
      </b-col>
      <b-col>
        <b-alert show variant="warning">층수 : {{ house.floor }}층</b-alert>
      </b-col>
    </b-row> -->
    <b-row>
      <b-col>
        <b-alert show variant="danger"
          >현재 시세 :
          {{
            (parseInt(house.recentPrice.replace(",", "")) * 10000) | price
          }}원</b-alert
        >
      </b-col>
    </b-row>

    <!-- detailrow -->
    <!-- <b-list-group
      v-if="houseDetails && houseDetails.length != 0"
      class="mt-1 padding-top"
    >
      <house-detail-row
        v-for="(item, index) in houseDetails"
        :key="index"
        :item="item"
      />
    </b-list-group> -->
    <b-row>
      <b-col v-if="houseDetails.length" class="bv-example-row mt-3">
        <b-table-simple hover responsive>
          <b-thead head-variant="#ced4da" class="detailhead">
            <b-tr class="detailthr">
              <b-th style="font-size: 1rem">건물 번호</b-th>
              <b-th style="font-size: 1rem">거래금액</b-th>
              <b-th style="font-size: 1rem">전용 면적/ 평</b-th>
              <b-th style="font-size: 1rem">층</b-th>
              <b-th style="font-size: 1rem">거래일자</b-th>
            </b-tr>
          </b-thead>
          <tbody>
            <house-detail-row
              v-for="(item, index) in houseDetails"
              :key="index"
              :item="item"
            />
          </tbody>
        </b-table-simple>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import HouseDetailRow from "@/views/HouseTable/HouseDetailRow.vue";
import { mapState } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseDetail",
  components: {
    HouseDetailRow,
  },
  computed: {
    ...mapState(houseStore, ["house", "houseDetails"]),
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
  },
  filters: {
    price(value) {
      if (!value) return value;
      return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },
};
</script>

<style>
.detailhead {
  background-color: #8898aa;
  color: white;
}
</style>
