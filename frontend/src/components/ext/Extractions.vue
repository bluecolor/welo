<template lang="pug">
div
  v-card(style="max-width: 1200px; margin: auto;" color='grey lighten-4', flat='', height='200px')
    v-toolbar(color='white', light='')
      v-tooltip(top='')
        v-btn(v-show="selected.length>0" slot="activator" flat icon color="deep-orange darken-4")
          v-icon delete
        span Delete
      v-tooltip(top='')
        v-btn(v-show="selected.length===1" slot="activator" flat icon color="blue darken-3")
          v-icon content_copy
        span Clone
      v-tooltip(top='')
        v-btn(v-show="selected.length===1" slot="activator" flat icon color="yellow darken-3")
          v-icon edit
        span Edit
      v-spacer
      v-text-field(append-icon='search', label='Search', single-line='', hide-details='', v-model='search')

    v-data-table.elevation-1(
      v-model='selected',
      v-bind:headers='headers',
      v-bind:items='items',
      select-all,
      v-bind:pagination.sync='pagination',
      item-key='name'
      v-bind:search="search"
    )
      template(slot='headers', slot-scope='props')
        tr
          th
            v-checkbox(primary='', hide-details='', @click.native='toggleAll', :input-value='props.all', :indeterminate='props.indeterminate')
          th(v-for='header in props.headers', :key='header.text', :class="['column sortable', pagination.descending ? 'desc' : 'asc', header.value === pagination.sortBy ? 'active' : '']", @click='changeSort(header.value)')
            v-icon arrow_upward
            |           {{ header.text }}
      template(slot='items', slot-scope='props')
        tr(:active='props.selected', @click='props.selected = !props.selected')
          td
            v-checkbox(primary='', hide-details='', :input-value='props.selected')
          td {{ props.item.name }}
          td.text-xs-right {{ props.item.link }}
          td.text-xs-right {{ props.item.sourceSchema }}
          td.text-xs-right {{ props.item.sourceTable }}
          td.text-xs-right {{ props.item.target }}
  v-btn(fixed='', dark='', fab='', bottom='', right='', color='pink' route, to="/extraction")
    v-icon add
</template>

<script>
export default {
  data () {
    return {
      search: '',
      pagination: {
        sortBy: 'name'
      },
      headers: [{
        text: 'Name',
        align: 'left',
        value: 'name'
      }, {
        text: 'Link',
        value: 'link',
        align: 'left'
      }, {
        text: 'Source schema',
        align: 'left',
        value: 'sourceSchema'
      }, {
        text: 'Source table',
        align: 'left',
        value: 'sourceTable'
      }, {
        text: 'Target',
        align: 'left',
        value: 'target'
      }],
      selected: [],
      items: [{
        name: 'S_DETAY_ARAC',
        link: 'DG',
        sourceSchema: 'BURSA2',
        sourceTable: 'S_DETAY_ARAC',
        target: 'ODS.S_DETAY_ARAC'
      }, {
        name: 'S_DETAY_POS',
        link: 'DG',
        sourceSchema: 'BURSA2',
        sourceTable: 'S_DETAY_POS',
        target: 'ODS.S_DETAY_POS'
      }]
    }
  },
  methods: {
    toggleAll () {
      if (this.selected.length) this.selected = []
      else this.selected = this.items.slice()
    },
    changeSort (column) {
      if (this.pagination.sortBy === column) {
        this.pagination.descending = !this.pagination.descending
      } else {
        this.pagination.sortBy = column
        this.pagination.descending = false
      }
    }
  }
}
</script>

<style>
.content {
  margin: 10px 50px !important;
}
</style>
