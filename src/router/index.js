import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Connection from '@/components/connection/Connection'
import Connections from '@/components/connection/Connections'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    }, {
      path: '/connection',
      name: 'Connection',
      component: Connection
    }, {
      path: '/connections',
      name: 'Connections',
      component: Connections
    }
  ]
})
