<template>

  <div
    class="modal fade"
    id="productModal"
    tabindex="-1"
  >

    <div class="modal-dialog modal-dialog-centered">

      <div class="modal-content border-0 rounded-4">

        <div class="modal-body p-0">

          <img
            :src="'/images/' + product?.image"
            class="w-100"
            style="
            height:300px;
            object-fit:cover;
            border-top-left-radius:16px;
            border-top-right-radius:16px;
            "
          />

          <div class="p-3">

            <h4>
              {{ product?.name }}
            </h4>

            <p class="text-secondary">
              {{ product?.description }}
            </p>

            <h5 class="fw-bold mb-3">
              {{ formatPrice(product?.price || 0) }}
            </h5>

            <button
              class="btn btn-dark w-100"
              @click="addToCart"
            >
              Add To Cart
            </button>

          </div>

        </div>

      </div>

    </div>

  </div>

</template>

<script setup>

import { cart } from "../store/cart";

const props = defineProps({
  product:Object
});

const addToCart = () => {

  cart.items.push({
    ...props.product,
    quantity:1
  });
};

const formatPrice = (price) => {

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

</script>