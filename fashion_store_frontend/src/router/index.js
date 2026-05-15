import {
  createRouter,
  createWebHistory
}
from "vue-router";

import HomePage
from "../pages/HomePage.vue";

import CategoryPage
from "../pages/CategoryPage.vue";

import ProductDetailPage
from "../pages/ProductDetailPage.vue";

import CartPage
from "../pages/CartPage.vue";

import CheckoutPage
from "../pages/CheckoutPage.vue";

import MemberPage
from "../pages/MemberPage.vue";

import OrderPage
from "../pages/OrderPage.vue";

import OrderDetailPage
from "../pages/OrderDetailPage.vue";

import FavoritePage
from "../pages/FavoritePage.vue";

const routes = [

  {
    path:"/",
    component:HomePage
  },

  {
    path:"/category",
    component:CategoryPage
  },

  {
    path:"/product/:id",
    component:ProductDetailPage
  },

  {
    path:"/cart",
    component:CartPage
  },

  {
    path:"/checkout",
    component:CheckoutPage
  },

  {
    path:"/member",
    component:MemberPage
  },

  {
    path:"/orders",
    component:OrderPage
  },

  {
    path:"/orders/:id",
    component:OrderDetailPage
  },

  {
    path:"/favorites",
    component:FavoritePage
  }

];

const router = createRouter({

  history:createWebHistory(),

  routes

});

export default router;