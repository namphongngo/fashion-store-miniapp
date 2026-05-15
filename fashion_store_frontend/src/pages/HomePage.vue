<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <!-- LOGO -->

    <h4 class="fw-bold mb-3">
      NIKE
    </h4>

    <!-- BANNER -->

    <div
      id="bannerCarousel"
      class="carousel slide mb-4"
      data-bs-ride="carousel"
    >

      <div class="carousel-inner rounded-4">

        <div class="carousel-item active">

          <img
            src="/images/banner1.jpg"
            class="d-block w-100"
            style="
            height:140px;
            object-fit:cover;
            "
          />

        </div>

        <div class="carousel-item">

          <img
            src="/images/banner2.jpg"
            class="d-block w-100"
            style="
            height:140px;
            object-fit:cover;
            "
          />

        </div>

      </div>

    </div>

    <!-- PRODUCTS -->

    <div class="row g-3">

      <div
        class="col-6"
        v-for="product in products"
        :key="product.id"
      >

        <ProductCard
          :product="product"
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

const products = ref([]);

const loadProducts = async () => {

  const response =
  await api.get("/products");

  products.value =
  response.data;
};

onMounted(() => {

  loadProducts();

});

</script>