<template>
  <b-tr>
    <b-td>{{ item.no }}</b-td>
    <b-td>{{ item.dealAmount }}</b-td>
    <b-td>{{ item.area }} ㎡ / {{ Math.round(item.area / 3.3057) }} 평</b-td>
    <b-td>{{ item.floor }}</b-td>
    <b-td>{{ item.dealYear }}/ {{ item.dealMonth }}/ {{ item.dealDay }}</b-td>
  </b-tr>
</template>

<script>
export default {
  name: "HouseDetailRow",
  props: {
    item: Object,
  },
};
</script>

<style></style>
