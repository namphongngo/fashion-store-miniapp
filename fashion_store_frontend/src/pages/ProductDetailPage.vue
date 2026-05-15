<template>

  <div
    class="p-3"
    style="
    height:100%;
    overflow-y:auto;
    padding-bottom:90px;
    "
  >

    <!-- SLIDER -->

    <div
      id="productSlider"
      class="carousel slide mb-3"
      data-bs-ride="carousel"
    >

      <div class="carousel-inner rounded-4">

        <div class="carousel-item active">

          <img
            :src="'/images/' + product.image"
            class="d-block w-100"
            style="
            height:320px;
            object-fit:cover;
            "
          />

        </div>

        <div class="carousel-item">

          <img
            :src="'/images/' + product.image"
            class="d-block w-100"
            style="
            height:320px;
            object-fit:cover;
            "
          />

        </div>

      </div>

    </div>

    <!-- INFO -->

    <h3 class="fw-bold">
      {{ product.name }}
    </h3>

    <h4 class="fw-bold mb-3">
      {{ formatPrice(product.price) }}
    </h4>

    <p class="text-secondary">
      {{ product.description }}
    </p>

    <!-- SIZE -->

    <h5 class="mt-4 mb-3">
      Chọn kích thước
    </h5>

    <div class="d-flex gap-2 mb-4">

      <button
        v-for="size in sizes"
        :key="size"

        class="btn"

        :class="
        selectedSize === size
        ? 'btn-dark'
        : 'btn-outline-dark'
        "

        @click="selectedSize = size"
      >
        {{ size }}
      </button>

    </div>

    <!-- ADD TO CART -->

    <button
      class="
      btn
      btn-dark
      w-100
      py-3
      mb-3
      "

      @click="addToCart"
    >

      Thêm vào giỏ hàng

    </button>

    <!-- FAVORITE -->

    <button
      class="
      btn
      btn-light
      border
      w-100
      py-3
      "

      @click="addFavorite"
    >

      <i class="bi bi-heart me-2"></i>

      Thêm vào yêu thích

    </button>

  </div>

</template>

<script setup>

import {
  ref,
  onMounted
}
from "vue";

import {
  useRoute
}
from "vue-router";

import api
from "../services/api";

import { cart }
from "../store/cart";

const route = useRoute();

const product = ref({});

const selectedSize = ref("M");

const sizes = [

  "S",
  "M",
  "L",
  "XL"
];

const loadProduct = async () => {

  const response =
  await api.get(

    "/products/" +
    route.params.id
  );

  product.value =
  response.data;
};

const addFavorite = async () => {

  await api.post(

    "/favorites/" +
    product.value.id
  );

  alert("Đã thêm vào yêu thích");
};

const addToCart = () => {

  const existItem =
  cart.items.find(

    item =>

      item.id === product.value.id
      &&
      item.size === selectedSize.value
  );

  if(existItem){

    existItem.quantity++;

  }else{

    cart.items.push({

      ...product.value,

      size:selectedSize.value,

      quantity:1
    });
  }

  alert("Đã thêm vào giỏ hàng");
};

const formatPrice = (price) => {

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

onMounted(() => {

  loadProduct();

});

</script>