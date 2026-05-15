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

      Đơn hàng của tôi

    </h4>

    <!-- EMPTY -->

    <div
      v-if="bills.length === 0"
      class="text-center mt-5"
    >

      <i class="bi bi-bag fs-1"></i>

      <p class="mt-3">
        Chưa có đơn hàng
      </p>

    </div>

    <!-- BILL -->

    <div
      v-for="bill in bills"
      :key="bill.id"

      class="
      card
      border-0
      shadow-sm
      mb-3
      "

      @click="goDetail(bill.id)"

      style="cursor:pointer;"
    >

      <div class="card-body">

        <div
          class="
          d-flex
          justify-content-between
          "
        >

          <h6 class="fw-bold">

            Đơn #{{ bill.id }}

          </h6>

          <span class="badge bg-dark">

            {{ bill.status }}

          </span>

        </div>

        <p class="small text-secondary mb-1">

          {{ formatDate(bill.createdAt) }}

        </p>

        <p class="fw-bold mb-0">

          {{ formatPrice(bill.totalAmount) }}

        </p>

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

import {
  useRouter
}
from "vue-router";

import api
from "../services/api";

const router = useRouter();

const bills = ref([]);

const loadBills = async () => {

  const response =
  await api.get("/bills");

  bills.value =
  response.data;
};

const goDetail = (billId) => {

  router.push(

    "/orders/" + billId
  );
};

const formatPrice = (price) => {

  return new Intl.NumberFormat("vi-VN")
    .format(price) + " đ";
};

const formatDate = (date) => {

  return new Date(date)
    .toLocaleDateString("vi-VN");
};

onMounted(() => {

  loadBills();

});

</script>