// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import qs from 'qs';
import VueResource from 'vue-resource'
import Vuelidate from 'vuelidate'

Vue.prototype.$qs = qs;
// Vue.prototype.bus = new Vue();
Vue.use(ElementUI)
Vue.use(VueResource)
Vue.use(Vuelidate)
Vue.config.productionTip = false
Vue.prototype.$ajax=axios
axios.defaults.withCredentials=true;

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
