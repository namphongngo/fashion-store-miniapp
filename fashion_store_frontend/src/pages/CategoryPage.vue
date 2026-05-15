<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <h4 class="fw-bold mb-3">
      Danh Mục
    </h4>

    <!-- CATEGORY LIST -->

    <div class="d-flex gap-2 mb-4 flex-wrap">

      <button
        class="btn"

        :class="
        selectedCategory === null
        ? 'btn-dark'
        : 'btn-outline-dark'
        "

        @click="loadAllProducts"
      >
        All
      </button>

      <button
        v-for="category in categories"
        :key="category.id"

        class="btn"

        :class="
        selectedCategory === category.id
        ? 'btn-dark'
        : 'btn-outline-dark'
        "

        @click="
        loadProductsByCategory(category)
        "
      >

        {{ category.name }}

      </button>

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

const categories = ref([]);

const products = ref([]);

const selectedCategory = ref(null);

const loadCategories = async () => {

  const response =
  await api.get("/categories");

  categories.value =
  response.data;
};

const loadAllProducts = async () => {

  selectedCategory.value = null;

  const response =
  await api.get("/products");

  products.value =
  response.data;
};

const loadProductsByCategory =
async (category) => {

  selectedCategory.value =
  category.id;

  const response =
  await api.get(

    "/products/category/" +
    category.id
  );

  products.value =
  response.data;
};

onMounted(() => {

  loadCategories();

  loadAllProducts();

});

</script>