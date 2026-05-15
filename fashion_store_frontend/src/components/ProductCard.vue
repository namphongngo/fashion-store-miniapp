<template>

  <div
    class="card border-0 shadow-sm rounded-4 h-100"
    @click="goDetail"
    style="cursor:pointer;"
  >

    <img
      :src="'/images/' + product.image"
      class="card-img-top"
      style="
      height:130px;
      object-fit:cover;
      "
    />

    <div class="card-body p-2">

      <h6 class="fw-bold">
        {{ product.name }}
      </h6>

      <p class="fw-bold mb-0">
        {{ formatPrice(product.price) }}
      </p>

    </div>

  </div>

</template>

<script setup>

import { useRouter }
from "vue-router";

const props = defineProps({

  product:Object
});

const router = useRouter();

const goDetail = () => {

  router.push(

    "/product/" +
    props.product.id
  );
};

const formatPrice = (price) => {

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

</script>