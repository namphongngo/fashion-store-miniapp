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
      Giỏ Hàng
    </h4>

    <!-- EMPTY -->

    <div
      v-if="cart.items.length === 0"
      class="text-center mt-5"
    >

      <i class="bi bi-cart fs-1"></i>

      <p class="mt-3">
        Giỏ Hàng Trống
      </p>

    </div>

    <!-- ITEMS -->

    <div
      v-for="item in cart.items"
      :key="item.id + item.size"

      class="card border-0 shadow-sm mb-3"
    >

      <div class="card-body">

        <div class="d-flex gap-3">

          <!-- IMAGE -->

          <img
            :src="'/images/' + item.image"

            style="
            width:90px;
            height:90px;
            object-fit:cover;
            border-radius:12px;
            "
          />

          <!-- INFO -->

          <div class="flex-grow-1">

            <h6 class="fw-bold">
              {{ item.name }}
            </h6>

            <p class="small text-secondary mb-1">
              Size: {{ item.size }}
            </p>

            <p class="fw-bold mb-2">
              {{ formatPrice(item.price) }}
            </p>

            <!-- QUANTITY -->

            <div
              class="d-flex align-items-center gap-2"
            >

              <button
                class="btn btn-outline-dark btn-sm"

                @click="decreaseQuantity(item)"
              >
                -
              </button>

              <span>
                {{ item.quantity }}
              </span>

              <button
                class="btn btn-dark btn-sm"

                @click="increaseQuantity(item)"
              >
                +
              </button>

            </div>

          </div>

          <!-- REMOVE -->

          <button
            class="btn btn-link text-danger"

            @click="removeItem(item)"
          >

            <i class="bi bi-trash"></i>

          </button>

        </div>

      </div>

    </div>

    <!-- TOTAL -->

    <div
      v-if="cart.items.length > 0"
      class="mt-4"
    >

      <h5 class="fw-bold mb-3">

        Tổng:
        {{ formatPrice(totalPrice()) }}

      </h5>

      <router-link
        to="/checkout"

        class="btn btn-dark w-100 py-3"
      >

        Thanh Toán

      </router-link>

    </div>

  </div>

</template>

<script setup>

import { cart }
from "../store/cart";

const increaseQuantity = (item) => {

  item.quantity++;
};

const decreaseQuantity = (item) => {

  if(item.quantity > 1){

    item.quantity--;

  }else{

    removeItem(item);
  }
};

const removeItem = (item) => {

  cart.items =
  cart.items.filter(

    i =>

      !(
        i.id === item.id
        &&
        i.size === item.size
      )
  );
};

const totalPrice = () => {

  return cart.items.reduce(

    (sum,item) =>

      sum +
      item.price * item.quantity,

    0
  );
};

const formatPrice = (price) => {

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

</script>