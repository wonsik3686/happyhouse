<template>
  <!-- <div>
    <base-header class="bg-gradient-info">
      <b-row>
        <b-col>
          <h2>Happyhouse 검색</h2>
        </b-col>
      </b-row>
    </base-header>
    <b-container id="mainContent" fluid class="mt-1">
      <house-search-bar />
      <b-row>
        <b-col cols="8">
          <KakaoMap id="kakaomap" />
        </b-col>
        <b-col class="p-0">
          <HouseList />
          <router-view />
        </b-col>
      </b-row>
    </b-container>
  </div> -->

  <div>
    <base-header class="bg-gradient-info pd-5">
      <b-row class="">
        <b-col class="mb-5">
          <h2>Happyhouse 검색</h2>
        </b-col>
      </b-row>
    </base-header>
    <b-container id="mainContent" fluid class="mt-1">
      <b-row class="mt-4 justify-content-md-end">
        <b-col cols="2">
          <base-button size="lg" type="info" @click="toggleBar">{{
            toggleButtonText
          }}</base-button>
        </b-col>
      </b-row>

      <b-row class="mt-2">
        <b-col :cols="colsMap">
          <KakaoMap />
        </b-col>
        <b-col :cols="colsBar" :v-show="showBar" :style="closeBar">
          <div
            class="overflow-auto"
            style="height: 700px; background-color: white"
          >
            <house-search-bar />
            <router-view />
          </div>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>
<script>
import HouseSearchBar from "@/views/HouseTable/HouseSearchBar.vue";
// import HouseList from "@/views/HouseTable/HouseList.vue";
// import HouseDetail from "@/components/house/HouseDetail.vue";
import KakaoMap from "@/views/HouseTable/KakaoMap.vue";
// import HouseDetail from "@/views/HouseTable/HouseDetail.vue";
export default {
  name: "HouseTable",
  data() {
    return {
      colsMap: 7,
      colsBar: 4,
      toggle: true,
      showBar: false,
      toggleButtonText: "검색창 닫기",
      openBar: "display: ;",
      closeBar: "display: none;",
    };
  },
  // data: {
  //   colsMap: 1,
  // },
  computed: {},
  components: {
    KakaoMap,
    HouseSearchBar,
  },
  methods: {
    toggleBar() {
      if (this.toggle) {
        this.colsMap = 7;
        this.colsBar = 5;
        this.showBar = true;
        this.toggle = false;
        this.toggleButtonText = "검색창 닫기";
        this.closeBar = "display: ;";
      } else {
        this.colsMap = 12;
        this.colsBar = 0;
        this.showBar = false;
        this.toggle = true;
        this.toggleButtonText = "검색창 열기";
        this.closeBar = "display: none;";
      }
    },
  },
};
</script>
<style>
#mainContent {
  padding-left: 0px;
  padding-right: 0px;
}
</style>
