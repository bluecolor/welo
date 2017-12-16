<template lang="pug">
div(
  id="e3"
  style="max-width: 900px; margin: auto;"
  class="lighten-3"
)
  div(
    id="e3"
    style="max-width: 600px; margin: auto;"
    class="lighten-3"
  )
    v-container(fluid='', style='min-height: 0;', grid-list-lg='')
      v-layout(row='', wrap='')
        v-flex(xs12='' v-for='(item, i) in connections',)
          v-card.white--text(color='grey darken-1')
            v-card-title(primary-title='')
              .headline {{item.name}}
                div.url
                  span
                    | {{item.url}}
            v-card-actions
              v-btn Activate
              v-spacer
              v-btn(route to="/connection") Details
              v-btn(color="error") Delete
  v-btn(fixed='', dark='', fab='', bottom='', right='', color='pink' route, to="/connection")
    v-icon add
</template>

<script>
export default {
  data () {
    return {
      connections: [
        {
          name: 'Development',
          url: 'jdbc:/thin:oracle:localhost:1521/orcl',
          username: 'elo'
        }, {
          name: 'Production',
          url: 'jdbc:/thin:oracle:localhost:1521/orcl',
          username: 'elo'
        }, {
          name: 'Production',
          url: 'jdbc:/thin:oracle:localhost:1521/orcl',
          username: 'elo'
        }
      ]
    }
  }
}
</script>

<style>
  .url {
    font-size: 14px !important;
  }
</style>
