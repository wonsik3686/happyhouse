<template>
  <b-list-group-item
    class="m-1"
    @click="selectHouse"
    @mouseover="colorChange(true)"
    @mouseout="colorChange(false)"
    :class="{ 'mouse-over-bgcolor': isColor }"
  >
    <b-col cols="10" class="text-center">
      <h2 class="font-weight-bold">{{ house.aptName }}</h2>
      <small>{{
        house.sidoName + house.gugunName + house.dongName + house.jibun
      }}</small>
    </b-col>
  </b-list-group-item>
</template>

<script>
import { mapActions } from "vuex";
export default {
  name: "HouseListRow",
  data() {
    return {
      isColor: false,
    };
  },
  props: {
    deal: Object,
    rent: Object,
  },
  methods: {
    ...mapActions(houseStore, ["detailHouse", "gethousedetails"]),
    colorChange(flag) {
      this.isColor = flag;
    },
    selectHouse() {
      this.detailHouse(this.house);
      this.gethousedetails(this.house);
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
