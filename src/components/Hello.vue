<template lang="pug">
v-container(fluid='')
  v-slide-y-transition(mode='out-in')
    v-layout(column='', align-center='')
      img.mb-5(src='/static/img/v.png', alt='Vuetify.js')
      blockquote
        | “First, solve the problem. Then, write the code.”
        footer
          small
            em —John Johnson
</template>
