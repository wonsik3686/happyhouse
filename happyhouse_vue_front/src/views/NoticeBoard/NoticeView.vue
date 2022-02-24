<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 class="display-2">공지사항</h1>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <base-button variant="outline-primary" @click="listArticle"
          >목록</base-button
        >
      </b-col>
      <b-col class="text-right">
        <base-button
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          >글수정</base-button
        >
        <base-button variant="outline-danger" size="sm" @click="deleteArticle"
          >글삭제</base-button
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.articleno}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.userid}</div><div>${article.regtime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import moment from "moment";
import http from "@/util/http-common";
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "NoticeView",
  components: {},
  data() {
    return {
      article: {},
      answer: {},
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
    message() {
      if (this.article.content)
        return this.article.content.split("\n").join("<br>");
      return "";
    },
    messageAnswer() {
      if (this.answer.content)
        return this.answer.content.split("\n").join("<br>");
      return "";
    },
    // changeDateFormat() {
    //   return moment(new Date(this.article.regtime)).format(
    //     "YYYY.MM.DD hh:mm:ss"
    //   );
    // },
  },
  created() {
    http.get(`/notice/${this.$route.params.no}`).then(({ data }) => {
      this.article = data;
    });
    // http.get(`/answer/${this.$route.params.no}`).then(({ data }) => {
    //   this.answer = data;
    // });
  },
  methods: {
    listArticle() {
      this.$router.push({ name: "NoticeList" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "NoticeModify",
        params: { no: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "NoticeDelete",
          params: { no: this.article.articleno },
        });
      }
    },
  },
};
</script>

<style></style>
