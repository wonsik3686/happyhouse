<template>
  <b-list-group-item
    class="m-1"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="10" class="text-center">
      <h2 class="font-weight-bold">{{ rent.name }}</h2>
      <div
        v-if="rent.rentMoney == 0"
        class="d-flex w-100 justify-content-between"
      >
        <h3>전세 / {{ rent.deposit }} 만원</h3>
      </div>
      <div v-else class="d-flex w-100 justify-content-between">
        <h3 class="mb-1">월세 / {{ rent.rentMoney }}</h3>
        <h3>보증금 {{ rent.deposit }}만원</h3>
      </div>
    </b-col>
  </b-list-group-item>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "HouseRentRow",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    rent: Object,
  },
  methods: {
    ...mapActions("houseStore", ["setSelectRent"]),
    colorChange(flag) {
      this.isColor = flag;
    },
    selectHouse() {
      this.setSelectRent(this.rent);
      this.$router.push({
        name: "RentDetail",
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
