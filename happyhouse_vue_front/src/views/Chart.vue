<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-8 bg-gradient-blue">
      <router-view></router-view>
      <b-row>
        <b-col cols="4">
          <b-card>
            <pie-chart :data="chartData" :options="chartOptions"></pie-chart>
          </b-card>
        </b-col>
      </b-row>
    </base-header>
  </div>
</template>
<script>
// import {} from chart.js;

// api
import http from "@/util/http-common";

import PieChart from "./PieChart.js";

export default {
  components: {
    PieChart,
  },
  data() {
    return {
      chartOptions: {
        hoverBorderWidth: 20,
      },
      chartData: {
        hoverBackgroundColor: "red",
        hoverBorderWidth: 10,
        labels: ["Green", "Red", "Blue", "dd"],
        datasets: [
          {
            label: "Data One",
            backgroundColor: ["#41B883", "#E46651", "#00D8FF"],
            data: [1, 10, 5, 4],
          },
        ],
      },
    };
  },
  created() {},
  methods: {},
  mounted() {},
};
</script>
