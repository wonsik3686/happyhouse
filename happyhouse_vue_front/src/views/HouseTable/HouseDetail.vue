<template>
  <b-container class="bv-example-row">
    <!-- <b-row class="mb-2 mt-1">
      <b-col
        ><b-img :src="require('@/assets/joc.png')" fluid-grow></b-img
      ></b-col>
    </b-row> -->
    <b-row class="text-center mt-3">
      <b-col
        ><b-alert show variant="default" style="font-size: 30px">{{
          deal.name
        }}</b-alert></b-col
      >
    </b-row>
    <b-row>
      <b-col>
        <b-alert
          show
          variant=""
          style="background: #ced4da"
          class="border border-5"
          >매매 금액 :
          {{ (deal.dealAmount.replace(",", "") * 10000) | price }}원</b-alert
        >
      </b-col>
    </b-row>

    <b-row>
      <b-col>
        <b-alert
          show
          variant=""
          style="background: #ced4da"
          class="border border-5"
          >층수 : {{ deal.floor }}층</b-alert
        >
      </b-col>
      <b-col>
        <b-alert
          show
          variant=""
          style="background: #ced4da"
          class="border border-5"
          >법정동 : {{ deal.dong }}</b-alert
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-alert
          show
          variant=""
          style="background: #ced4da"
          class="border border-5"
          >전용 면적 / 평 : {{ deal.area }} ㎡ /
          {{ Math.round(this.deal.area / 3.3057) }} 평
        </b-alert>
      </b-col>
    </b-row>
    <b-button variant="outline-warning" @click="goBack">뒤로 돌아가기</b-button>
  </b-container>
</template>

<script>
import HouseDetailRow from "@/views/HouseTable/HouseDetailRow.vue";
import { mapGetters } from "vuex";
const houseStore = "houseStore";
export default {
  name: "HouseDetail",
  data() {
    return {
      deal: "",
      rent: "",
    };
  },
  components: {
    HouseDetailRow,
  },
  computed: {},
  created() {
    this.deal = this.getDeal();
    this.rent = this.getRent();
  },
  methods: {
    ...mapGetters("houseStore", ["getDeal", "getRent"]),
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
