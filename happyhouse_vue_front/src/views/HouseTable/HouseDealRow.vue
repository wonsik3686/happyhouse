<template>
  <b-list-group-item
    class="m-1"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="10" class="text-center">
      <h2 class="font-weight-bold">{{ deal.name }}</h2>
      <h3>매매 / {{ deal.dealAmount }}만원</h3>
    </b-col>
  </b-list-group-item>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "HouseDealRow",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    deal: Object,
  },
  methods: {
    ...mapActions("houseStore", ["setSelectDeal"]),
    colorChange(flag) {
      this.isColor = flag;
    },
    selectHouse() {
      this.setSelectDeal(this.deal);
      this.$router.push({
        name: "HouseDetail",
      });
    },
  },
};
</script>

<style scoped>
.apt {
  width: 30px;
}
.mouse-over-bgcolor {
  background-color: lightblue;
}
</style>
