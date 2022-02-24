<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 class="display-2">Q & A</h1>
      </b-col>
    </b-row>
    <b-card>
      <qna-write-form type="modify" />
    </b-card>
  </b-container>
</template>

<script>
import QnaWriteForm from "./child/QnaWriteForm.vue";

export default {
  name: "QnaUpdate",
  components: {
    QnaWriteForm,
  },
};
</script>

<style></style>
