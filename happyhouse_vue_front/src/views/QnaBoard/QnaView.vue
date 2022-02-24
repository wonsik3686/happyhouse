<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 class="display-2">Q & A</h1>
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
    <b-row>
      <b-col>
        <b-card
          v-if="answer"
          :header-html="`<h3>
          답변 </h3><div><h6>${answer.userid}</div><div>${article.regtime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="messageAnswer"></div>
          </b-card-body>
          <b-button variant="outline-danger" size="sm" @click="deleteAnswer"
            >답변 삭제</b-button
          >
          <!-- <b-button variant="outline-warning" size="sm" @click="modifyAnswer"
            >답변 수정</b-button
          > -->
        </b-card>
      </b-col>
    </b-row>
    <b-row v-if="!answer">
      <b-col>
        <b-card>
          <qna-answer-write-form type="register" />
          <!-- <b-button
            variant="outline-info"
            size="sm"
            @click="moveModifyArticle"
            class="mr-2"
            >답변 작성</b-button
          > -->
        </b-card>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
// import moment from "moment";
import http from "@/util/http-common";
import QnaAnswerWriteForm from "./child/QnaAnswerWriteForm.vue";

export default {
  name: "QnaView",
  components: {
    QnaAnswerWriteForm,
  },
  data() {
    return {
      article: {},
      answer: {},
    };
  },
  computed: {
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
    http.get(`/question/${this.$route.params.no}`).then(({ data }) => {
      this.article = data;
    });
    http.get(`/answer/${this.$route.params.no}`).then(({ data }) => {
      this.answer = data;
    });
  },
  methods: {
    listArticle() {
      this.$router.push({ name: "QnaList" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "QnaModify",
        params: { no: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "QnaDelete",
          params: { no: this.article.articleno },
        });
      }
    },
    deleteAnswer() {
      if (confirm("정말로 삭제?")) {
        this.$router.replace({
          name: "QnaAnswerDelete",
          params: { no: this.article.articleno },
        });
      }
    },
    modifyAnswer() {
      this.$router.replace({
        name: "QnaAnswerWriteForm",
        params: { no: this.article.articleno },
        props: { type: "modify" },
      });
    },
  },
};
</script>

<style></style>
