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
      Đơn Hàng
    </h4>

    <!-- CUSTOMER INFO -->

    <div class="card border-0 shadow-sm mb-4">

      <div class="card-body">

        <h5 class="fw-bold mb-3">
          Thông Tin Khách Hàng
        </h5>

        <input
          v-model="customerName"
          class="form-control mb-3"
          placeholder="Họ Tên"
        />

        <input
          v-model="phone"
          class="form-control mb-3"
          placeholder="Số Điện Thoại"
        />

        <textarea
          v-model="address"
          class="form-control"
          placeholder="Địa Chỉ Nhận Hàng"
        ></textarea>

      </div>

    </div>

    <!-- PRODUCT REVIEW -->

    <div class="card border-0 shadow-sm mb-4">

      <div class="card-body">

        <h5 class="fw-bold mb-3">
          Sản Phẩm 
        </h5>

        <div
          v-for="item in cart.items"
          :key="item.id + item.size"

          class="
          d-flex
          gap-3
          mb-3
          border-bottom
          pb-3
          "
        >

          <!-- IMAGE -->

          <img
            :src="'/images/' + item.image"

            style="
            width:80px;
            height:80px;
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

              Size:
              {{ item.size }}

            </p>

            <p class="small mb-1">

              Quantity:
              {{ item.quantity }}

            </p>

            <p class="fw-bold">

              {{ formatPrice(item.price) }}

            </p>

          </div>

        </div>

      </div>

    </div>

    <!-- TOTAL -->

    <div class="card border-0 shadow-sm mb-4">

      <div class="card-body">

        <div
          class="
          d-flex
          justify-content-between
          align-items-center
          "
        >

          <h5 class="fw-bold">
            Tổng:
          </h5>

          <h5 class="fw-bold">

            {{ formatPrice(totalPrice()) }}

          </h5>

        </div>

      </div>

    </div>

    <!-- BUTTON -->

    <button
      class="btn btn-dark w-100 py-3"

      @click="checkout"
    >

      Đặt Hàng

    </button>

  </div>

</template>

<script setup>

import { ref }
from "vue";

import api
from "../services/api";

import { cart }
from "../store/cart";

const customerName = ref("");

const phone = ref("");

const address = ref("");

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

const checkout = async () => {

  // VALIDATE

  if(!customerName.value){

    alert("Please enter full name");

    return;
  }

  if(!phone.value){

    alert("Please enter phone");

    return;
  }

  if(!address.value){

    alert("Please enter address");

    return;
  }

  if(cart.items.length === 0){

    alert("Cart is empty");

    return;
  }

  // API

  await api.post(

    "/checkout",

    {

      customerName:
      customerName.value,

      phone:
      phone.value,

      address:
      address.value,

      totalAmount:
      totalPrice(),

      items:
      cart.items.map(item => ({

        productId:item.id,

        quantity:item.quantity,

        size:item.size,

        unitPrice:item.price

      }))
    }
  );

  alert("Order Success!");

  cart.items = [];
};

</script>