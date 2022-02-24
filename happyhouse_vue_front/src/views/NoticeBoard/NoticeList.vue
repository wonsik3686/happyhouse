<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 class="display-2">공지사항</h1>
      </b-col>
    </b-row>
    <card>
      <!-- 필터 -->
      <b-row>
        <b-col lg="5" class="my-1">
          <b-form-group
            label="검색"
            label-for="filter-input"
            label-cols-sm="3"
            label-align-sm="right"
            label-size="sm"
            class="mb-0"
          >
            <b-input-group size="sm">
              <b-form-input
                id="filter-input"
                v-model="filter"
                type="search"
                placeholder="검색어를 입력하세요"
              ></b-form-input>

              <!-- <b-input-group-append>
                <b-button :disabled="!filter" @click="filter = ''"
                  >초기화</b-button
                >
              </b-input-group-append> -->
            </b-input-group>
          </b-form-group>
        </b-col>
        <b-col lg="7" class="my-1">
          <b-form-group
            v-model="sortDirection"
            label="검색 대상"
            label-cols-sm="3"
            label-align-sm="right"
            label-size="sm"
            class="mb-0"
            v-slot="{ ariaDescribedby }"
          >
            <b-form-checkbox-group
              v-model="filterOn"
              :aria-describedby="ariaDescribedby"
              class="mt-0"
            >
              <b-form-checkbox value="subject">제목</b-form-checkbox>
              <b-form-checkbox value="userid">작성자</b-form-checkbox>
              <!-- <b-form-checkbox value="regtime">작성일</b-form-checkbox> -->
            </b-form-checkbox-group>
          </b-form-group>
        </b-col>
      </b-row>
      <!-- 글쓰기 버튼 -->
      <b-row class="mb-1">
        <b-col class="text-right">
          <base-button
            size="sm"
            type="default"
            @click="moveWrite()"
            class="mb-2"
            ><span class="btn-inner--icon"
              ><i class="ni ni-ruler-pencil"></i
            ></span>
            글쓰기</base-button
          >
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-table
            hover
            responsive
            head-variant="light"
            :items="articles"
            :fields="fields"
            @row-clicked="viewArticle"
            :current-page="currentPage"
            :per-page="perPage"
            :filter="filter"
            :filter-included-fields="filterOn"
            :sort-by.sync="sortBy"
            :sort-desc.sync="sortDesc"
            :sort-direction="sortDirection"
            stacked="md"
            show-empty
            @filtered="onFiltered"
          >
            <template #cell(subject)="data">
              <router-link
                :to="{
                  name: 'NoticeView',
                  params: { no: data.item.articleno },
                }"
                >{{ data.item.subject }}</router-link
              >
            </template>
          </b-table>
        </b-col>
      </b-row>
      <!-- 페이지네이션 -->
      <b-row class="mt-4">
        <b-col sm="5" md="4" class="my-1">
          <b-form-group
            label="글 개수"
            label-for="per-page-select"
            label-cols-sm="6"
            label-cols-md="4"
            label-cols-lg="3"
            label-align-sm="right"
            label-size="sm"
            class="mb-0"
          >
            <b-form-select
              id="per-page-select"
              v-model="perPage"
              :options="pageOptions"
              size="sm"
            ></b-form-select>
          </b-form-group>
        </b-col>

        <b-col sm="7" md="8" class="my-1">
          <b-pagination
            v-model="currentPage"
            :total-rows="totalRows"
            :per-page="perPage"
            align="end"
            size="sm"
            class="my-0"
          ></b-pagination>
        </b-col>
      </b-row>
    </card>
  </b-container>
</template>

<script>
import http from "@/util/http-common";
// import BoardListRow from "@/components/board/BoardListRow";

export default {
  name: "NoticeList",
  components: {
    // BoardListRow,
  },
  data() {
    return {
      articles: [],
      fields: [
        {
          key: "articleno",
          label: "글번호",
          tdClass: "tdClass",
          sortable: true,
        },
        { key: "subject", label: "제목", tdClass: "tdSubject", sortable: true },
        { key: "userid", label: "작성자", tdClass: "tdClass", sortable: true },
        { key: "regtime", label: "작성일", tdClass: "tdClass", sortable: true },
        { key: "hit", label: "조회수", tdClass: "tdClass", sortable: true },
      ],
      // 필터
      filter: null,
      filterOn: [],
      // 페이지
      totalRows: 1,
      currentPage: 1,
      perPage: 5,
      pageOptions: [5, 10, 15, { value: 200, text: "전체 보기" }],
      sortBy: "",
      sortDesc: false,
      sortDirection: "asc",
    };
  },
  created() {
    http.get(`/notice?spp=10`).then(({ data }) => {
      this.articles = data;
      console.log(">>> qu get >>", data);
    });
    this.onFiltered(this.articles);
  },
  updated() {
    this.totalRows = this.articles.length;
    this.onFiltered(this.articles);
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "NoticeWrite" });
    },
    viewArticle(article) {
      this.$router.push({
        name: "NoticeView",
        params: { no: article.articleno },
      });
    },
    onFiltered(filteredItems) {
      // Trigger pagination to update the number of buttons/pages due to filtering
      this.totalRows = filteredItems.length;
      this.currentPage = 1;
      console.log("filtered");
    },
    sortOptions() {
      // Create an options list from our fields
      return this.fields
        .filter((f) => f.sortable)
        .map((f) => {
          return { text: f.label, value: f.key };
        });
    },
  },
};
</script>
