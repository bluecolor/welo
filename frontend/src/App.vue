<template lang="pug">
v-app(light='')
  v-navigation-drawer(fixed='', :mini-variant='miniVariant', :clipped='clipped', v-model='drawer', app='')
    v-list.pt-0
      v-list-tile(value='true', v-for='(item, i) in items', :key='i', exact='', router :to='item.to')
        v-list-tile-action
          v-icon(light='', v-html='item.icon')
        v-list-tile-content
          v-list-tile-title(v-text='item.title')
  v-toolbar(fixed='', app='', :clipped-left='clipped')
    v-toolbar-side-icon(@click.stop='drawer = !drawer', light='')
    v-btn(icon='', light='', @click.stop='miniVariant = !miniVariant')
      v-icon(v-html="miniVariant ? 'chevron_right' : 'chevron_left'")
    //- v-btn(icon='', light='', @click.stop='clipped = !clipped')
    //-   v-icon web
    //- v-btn(icon='', light='', @click.stop='fixed = !fixed')
    //-   v-icon remove
    v-toolbar-title(v-text='title')
    v-spacer
    v-btn(icon='', light='')
      v-icon settings

  v-content.content
    router-view
  v-footer(:fixed='fixed', app='')
    span © 2017 bluecolor
</template>

<script>
  export default {
    data () {
      return {
        clipped: true,
        drawer: true,
        fixed: true,
        connections: [
          {
            name: 'Development'
          }, {
            name: 'Production'
          }
        ],
        items: [{
          icon: 'cloud',
          title: 'Connections',
          to: 'connections'
        }, {
          icon: 'perm_identity',
          title: 'Users',
          to: 'users'
        }, {
          icon: 'storage',
          title: 'Extractions',
          to: 'extractions'
        }],
        miniVariant: false,
        right: true,
        rightDrawer: false,
        title: ''
      }
    },
    methods: {
      click () {
        console.log('clikc')
      }
    }
  }
</script>


<style>
</style>
