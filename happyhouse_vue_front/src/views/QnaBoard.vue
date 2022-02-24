<template>
  <div>
    <base-header class="pb-6 pb-8 pt-5 pt-md-8 bg-gradient-purple">
      <!--Tables-->
      <!-- <b-row xl="8" class="mb-5 mb-xl-0">
        <b-col>
          <b-card no-body>
            <b-card-header class="border-0">
              <h3 class="mb-0">QnA</h3>
            </b-card-header>
            <b-row class="mb-1">
              <b-col class="text-right">
                <b-button variant="outline-primary" @click="moveWrite()"
                  >글쓰기</b-button
                >
              </b-col>
            </b-row>

            <el-table
              class="table-responsive table-flush"
              header-row-class-name="thead-light"
              :data="articles"
            >
              <el-table-column
                label="No."
                prop="articleno"
                min-width="70px"
                sortable
              >
              </el-table-column>

              <el-table-column
                label="Title"
                prop="subject"
                min-width="340px"
                sortable
              >
              </el-table-column>

              <el-table-column
                label="ID"
                prop="userid"
                min-width="140px"
                sortable
              >
              </el-table-column>

              <el-table-column
                label="regtime"
                prop="regtime"
                min-width="140px"
                sortable
              >
              </el-table-column>

              <el-table-column
                label="hit"
                prop="hit"
                min-width="140px"
                sortable
              >
              </el-table-column>
            </el-table>

            <b-card-footer class="py-4 d-flex justify-content-end">
              <base-pagination
                v-model="currentPage"
                :per-page="10"
                :total="50"
              ></base-pagination>
            </b-card-footer>
          </b-card>
        </b-col>
      </b-row> -->
      <!--End tables-->
      <router-view></router-view>
    </base-header>
  </div>
</template>
<script>
// Charts
import * as chartConfigs from "@/components/Charts/config";
import LineChart from "@/components/Charts/LineChart";
import BarChart from "@/components/Charts/BarChart";

// Components
import BaseProgress from "@/components/BaseProgress";
import StatsCard from "@/components/Cards/StatsCard";

// Tables
import SocialTrafficTable from "./Dashboard/SocialTrafficTable";
import PageVisitsTable from "./Dashboard/PageVisitsTable";
import QnaArticlesTable from "./Dashboard/QnaArticlesTable";
import LightTable from "./RegularTables.vue";
// import projects from "./../projects";
import {
  Table,
  TableColumn,
  DropdownMenu,
  DropdownItem,
  Dropdown,
} from "element-ui";

// api
import http from "@/util/http-common";

export default {
  components: {
    LineChart,
    BarChart,
    BaseProgress,
    StatsCard,
    PageVisitsTable,
    SocialTrafficTable,
    QnaArticlesTable,
    LightTable,
    http,
    [Table.name]: Table,
    [TableColumn.name]: TableColumn,
    [Dropdown.name]: Dropdown,
    [DropdownItem.name]: DropdownItem,
    [DropdownMenu.name]: DropdownMenu,
  },
  data() {
    return {
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
      //   projects,
      currentPage: 1,
      bigLineChart: {
        allData: [
          [0, 20, 10, 30, 15, 40, 20, 60, 60],
          [0, 20, 5, 25, 10, 30, 15, 40, 40],
        ],
        activeIndex: 0,
        chartData: {
          datasets: [
            {
              label: "Performance",
              data: [0, 20, 10, 30, 15, 40, 20, 60, 60],
            },
          ],
          labels: ["May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
        },
        extraOptions: chartConfigs.blueChartOptions,
      },
      redBarChart: {
        chartData: {
          labels: ["Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
          datasets: [
            {
              label: "Sales",
              data: [25, 20, 30, 22, 17, 29],
            },
          ],
        },
        extraOptions: chartConfigs.blueChartOptions,
      },
    };
  },
  created() {
    http.get(`/board`).then(({ data }) => {
      this.articles = data;
    });
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "QnaWrite" });
    },
    viewArticle(article) {
      this.$router.push({
        name: "BoardView",
        params: { articleno: article.articleno },
      });
    },
    initBigChart(index) {
      let chartData = {
        datasets: [
          {
            label: "Performance",
            data: this.bigLineChart.allData[index],
          },
        ],
        labels: ["May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
      };
      this.bigLineChart.chartData = chartData;
      this.bigLineChart.activeIndex = index;
    },
  },
  mounted() {
    this.initBigChart(0);
  },
};
</script>
<style>
.el-table .cell {
  padding-left: 0px;
  padding-right: 0px;
}
</style>
