<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 class="display-2">글작성</h1>
      </b-col>
    </b-row>
    <b-card>
      <notice-write-form type="register" />
    </b-card>
  </b-container>
</template>

<script>
import NoticeWriteForm from "./child/NoticeWriteForm.vue";

export default {
  name: "NoticeWrite",
  components: {
    NoticeWriteForm,
  },
};
</script>

<style></style>
