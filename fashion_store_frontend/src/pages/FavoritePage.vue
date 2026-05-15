<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <h4 class="fw-bold mb-4">

      Sản phẩm yêu thích

    </h4>

    <div class="row g-3">

      <div
        class="col-6"

        v-for="favorite in favorites"
        :key="favorite.id"
      >

        <ProductCard
          :product="favorite.product"
        />

      </div>

    </div>

  </div>

</template>

<script setup>

import {
  ref,
  onMounted
}
from "vue";

import api
from "../services/api";

import ProductCard
from "../components/ProductCard.vue";

const favorites = ref([]);

const loadFavorites = async () => {

  const response =
  await api.get("/favorites");

  favorites.value =
  response.data;
};

onMounted(() => {

  loadFavorites();

});

</script>