<template lang="pug">
form.content
  v-text-field(label='Name', v-model='name', :error-messages='nameErrors', :counter='10', @input='$v.name.$touch()', @blur='$v.name.$touch()', required='')
  v-text-field(label='Jdbc Url', v-model='email',  required='')
  v-text-field(label='Username', v-model='email',  required='')
  v-text-field(label='Password', v-model='email',  required='')
  v-btn(@click='submit') submit
  v-btn(@click='clear') clear
</template>

<script>
export default {

}
</script>

<style>
.content {
  margin: 10px 50px !important;
}
</style>
